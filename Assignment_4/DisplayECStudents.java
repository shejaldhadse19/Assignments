package Assignment_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayECStudents {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc_demo", "root", "Root@123");
            Statement stmt = con.createStatement();

            String selectQuery =
                "SELECT * FROM Students WHERE semester = 7 AND branch = 'EC'";

            ResultSet rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getFloat("percentage")
                );
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
