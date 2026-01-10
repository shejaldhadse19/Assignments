package Assignment_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableInsert {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_demo", "root", "Root@123");
            Statement stmt = con.createStatement();

            String createTable =
                "CREATE TABLE IF NOT EXISTS Students (" +
                "id INT PRIMARY KEY," +
                "name VARCHAR(50)," +
                "branch VARCHAR(20)," +
                "semester INT," +
                "percentage FLOAT," +
                "year_of_passing INT)";

            stmt.executeUpdate(createTable);

            String insertData =
                "INSERT IGNORE INTO Students " +
                "(id, name, branch, semester, percentage, year_of_passing) VALUES " +
                "(1,'Rahul','CSE',7,70,2024)," +
                "(2,'Priya','EC',7,75,2025)," +
                "(3,'Amit','Civil',6,68,2024)," +
                "(4,'Neha','CSE',5,80,2026)";

            stmt.executeUpdate(insertData);

            System.out.println("Table created and records inserted successfully");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
