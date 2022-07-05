import java.sql.SQLException;
public class UsaZoo {
    public static void main( String args[]) throws SQLException {
        Zoo zoo = new Zoo();

        System.out.print("Primer connectem amb la base de dades: ");
        zoo.connecta();
        System.out.println("connectat");

        //System.out.println("Creem la taula CATEGORIES");
        //zoo.creaTaulaCategories();
        Categoria ocell = new Categoria("ocell");
        zoo.afegeixCategoria(ocell);

        System.out.print("Finalment tanquem la connexió amb la base de dades: ");
        zoo.desconnecta();
        System.out.println("desconnectat");
    }
}
