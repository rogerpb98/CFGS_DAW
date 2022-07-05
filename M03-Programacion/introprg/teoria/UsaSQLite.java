import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class UsaSQLite {
    public static void main( String args[] ) {
        final String nom_bd = "test.bd";  // nom de la base de dades a la que intentarem connectar
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + nom_bd);
            System.out.println("Connectat amb la base de dades " + nom_bd);
        } catch (SQLException e) {
            System.out.println("No es pot connectar a la base de dades " + nom_bd);
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("No es pot tancar la connexió amb la base de dades " + nom_bd);
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                }
            }
        }
    }
}
