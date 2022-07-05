import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.sql.ResultSet;
public class Zoo {
    private static final String NOM_BASE_DE_DADES = "animals.bd";
    private static final String CADENA_DE_CONNEXIO = "jdbc:sqlite:" +
                                                     NOM_BASE_DE_DADES;
    private Connection conn = null;

    public void connecta() throws SQLException {
        if (conn != null) return;   // ja connectat
        conn = DriverManager.getConnection(CADENA_DE_CONNEXIO);
    }

    public void desconnecta() throws SQLException {
        if (conn == null) return; // ja desconnectat
        conn.close();
    }
    public void creaTaulaCategories() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS CATEGORIES (" +
                     "       id        INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "       nom       VARCHAR(40))";
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }
    public void eliminaTaulaCategories() throws SQLException {
        eliminaTaulaAnimals();
        String sql = "DROP TABLE IF EXISTS CATEGORIES";
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }
    public void afegeixCategoria(Categoria categoria) throws SQLException {
        String sql = String.format(
                "INSERT INTO CATEGORIES (nom) VALUES ('%s')",
                categoria.getNom());
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) {
                st.close();
            }
            //Ampliació
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            categoria.setId(id);
        }
    }
    public Categoria obteCategoriaPerNom(String nom) throws SQLException {
        Categoria categoria=null;
        String sql = "SELECT * FROM CATEGORIES WHERE nom = \'" + nom + "\' ORDER BY id LIMIT 1";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int bdId = rs.getInt("id");
            categoria = new Categoria(bdId, nom);
            rs.close();
            //return categoria;
        } finally {
            if (st != null) {
                st.close();
            }
            return categoria;
        }
    }
    public List<Categoria> recuperaCategories() throws SQLException {
        String sql = "SELECT * FROM CATEGORIES ORDER BY nom";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Categoria> categories = new LinkedList<>();
            while (rs.next()) {
                int bdId = rs.getInt("id");
                String nom = rs.getString("nom");
                Categoria categoria = new Categoria(bdId, nom);
                categories.add(categoria);
            }
            rs.close();
            return categories;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }
    public void creaTaulaAnimals() throws SQLException {
        creaTaulaCategories();
        String sql = "CREATE TABLE IF NOT EXISTS ANIMALS (" +
                     "       id        INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "       nom       VARCHAR(40)," +
                     "       categoria INTEGER)";
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }
    public void eliminaTaulaAnimals() throws SQLException {
        String sql = "DROP TABLE IF EXISTS ANIMALS";
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }
    /* retorna el nom de les taules definides a la bd */
    public String getNomTaules() throws SQLException {
        String sql = "SELECT name FROM sqlite_schema " +
                    "WHERE name NOT LIKE 'sqlite%' " +
                    "ORDER BY name";
        List<String> taules = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) { taules.add(rs.getString("name")); }
            rs.close();
        }
        return taules.size() > 0 ? String.join(", ", taules) : "cap";
    }
    public void afegeixAnimal(Animal animal) throws SQLException {
        //Si la categoria no existeix a la abse de dades, la inserta
        if (obteCategoriaPerNom(animal.getCategoria().getNom())==null) {
            afegeixCategoria(animal.getCategoria());
        }
        //Extreu id de la categoria de l'animal introduit
        int categoriaId = obteCategoriaPerNom(animal.getCategoria().getNom()).getId();
        //Inserta l'Id de la categoría corresponent a la cat de l'animal
        if (animal.getCategoria().idIndefinit()) {
            animal.getCategoria().setId(categoriaId);
        }
        String sql = String.format(
            "INSERT INTO ANIMALS (nom, categoria) VALUES ('%s', '%d')",
            animal.getNom(),
            animal.getCategoria().getId()
        );
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) {
                st.close();
            }
            //Ampliació
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            animal.setId(id);
        }
    }
    public Animal obteAnimalPerNom(String nom) throws SQLException {
        Animal animal=null;
        String sql = "SELECT ANIMALS.id as id_animal, "+
                     "  ANIMALS.nom as nom_animal, "+
                     "  CATEGORIES.id as id_categoria, "+
                     "  CATEGORIES.nom as nom_categoria "+
                     "  FROM ANIMALS, CATEGORIES "+
                     "  WHERE ANIMALS.categoria = CATEGORIES.id "+
                     "  AND nom_animal = \'" + nom + "\' ORDER BY id_animal LIMIT 1";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int id = rs.getInt("id_animal");
            String nomAnimal = rs.getString("nom_animal");
            String nomCategoria = rs.getString("nom_categoria");
            Categoria categoria = obteCategoriaPerNom(nomCategoria);
            animal = new Animal(id, nomAnimal, categoria);
            rs.close();
        } finally {
            if (st != null) {
                st.close();
            }
            return animal;
        }
    }
    public List<Animal> recuperaAnimals() throws SQLException {
        String sql = "SELECT ANIMALS.id as id_animal, "+
                     "  ANIMALS.nom as nom_animal, "+
                     "  CATEGORIES.id as id_categoria, "+
                     "  CATEGORIES.nom as nom_categoria "+
                     "  FROM ANIMALS, CATEGORIES "+
                     "  WHERE ANIMALS.categoria = CATEGORIES.id "+
                     "  ORDER BY ANIMALS.nom";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Animal> animals = new LinkedList<>();
            while (rs.next()) {
                int id = rs.getInt("id_animal");
                String nom = rs.getString("nom_animal");
                String nomCategoria = rs.getString("nom_categoria");
                Categoria categoria = obteCategoriaPerNom(nomCategoria);
                Animal animal = new Animal(id, nom, categoria);
                animals.add(animal);
            }
            rs.close();
            return animals;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }
}
