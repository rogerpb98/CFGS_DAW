import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class UsaPostgreSQL {
    public static void main(String[] args) throws SQLException {
        String usuari   = "roger";
        String password = "passwordsupersecret";
        String host     = "127.0.0.1";
        String bd       = "roger";         // el nom de la base de dades

        String cadenaConnexio
            = "jdbc:postgresql://" + host
            + "/"                  + bd
            + "?user="             + usuari
            + "&password="         + password;

        Connection conn = DriverManager.getConnection(cadenaConnexio);
        System.out.println("Connectat!");
        conn.close();
    }
}

