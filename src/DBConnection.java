import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/studentdb";
            String username = "root";
            String password = "yourrealpasswordhere";;  // put your actual MySQL password here
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully!");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return con;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
