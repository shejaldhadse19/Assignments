package Assignment_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class IncreaseCSEPercentage {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc_demo", "root", "Root@123");
            Statement stmt = con.createStatement();

            String updateQuery =
                "UPDATE Students SET percentage = percentage + 5 " +
                "WHERE branch = 'CSE'";

            int rows = stmt.executeUpdate(updateQuery);

            System.out.println(rows + " CSE student(s) updated");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
