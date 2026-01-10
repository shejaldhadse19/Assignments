package Assignment_4;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnectionTest {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String pass = "Root@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            if (con != null) {
                System.out.println("Connection Successful");
            }
            con.close();

        } catch (Exception e) {
            System.out.println("Unable to connect");
        }
    }
}
