	

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class UsaSQLite {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:test.bd");
        System.out.println("Connectat!");
        conn.close();
    }
}

