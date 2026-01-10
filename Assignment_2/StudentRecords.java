package Assignment_2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

class Student {
    private int rollNo;
    private String name;
    private String branch;
    private double percentage;

    public Student(int rollNo, String name, String branch, double percentage) {
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.percentage = percentage;
    }

    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getBranch() { return branch; }
    public double getPercentage() { return percentage; }

    public void setName(String name) { this.name = name; }
    public void setBranch(String branch) { this.branch = branch; }
    public void setPercentage(double percentage) { this.percentage = percentage; }

    @Override
    public String toString() {
        return "RollNo: " + rollNo + ", Name: " + name + ", Branch: " + branch + ", %: " + percentage;
    }
}

public class StudentRecords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        List<Student> studentVector = new Vector<>();

        int choice;

        do {
            System.out.println("\nStudent Records Menu ->");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Delete Student by Roll No");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Roll No: ");
                        int roll = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Branch: ");
                        String branch = sc.nextLine();
                        System.out.print("Enter Percentage: ");
                        double per = sc.nextDouble();
                        sc.nextLine();

                        Student s = new Student(roll, name, branch, per);
                        students.add(s);        // Add to ArrayList
                        studentVector.add(s);   // Add to Vector
                        System.out.println("Student added successfully!");
                        break;

                    case 2:
                        System.out.println("\nAll Students in ArrayList ->");
                        if (students.isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            students.forEach(System.out::println);
                        }
                        System.out.println("\nAll Students in Vector ->");
                        if (studentVector.isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            studentVector.forEach(System.out::println);
                        }
                        break;

                    case 3:
                        System.out.print("Enter Roll No to search: ");
                        int rSearch = sc.nextInt();
                        sc.nextLine();
                        boolean found = false;
                        for (Student st : students) {
                            if (st.getRollNo() == rSearch) {
                                System.out.println("Student found: " + st);
                                found = true;
                                break;
                            }
                        }
                        if (!found) System.out.println("Student not found.");
                        break;

                    case 4:
                        System.out.print("Enter Roll No to delete: ");
                        int rDel = sc.nextInt();
                        sc.nextLine();
                        boolean removed = students.removeIf(st -> st.getRollNo() == rDel);
                        studentVector.removeIf(st -> st.getRollNo() == rDel);
                        if (removed) System.out.println("Student removed successfully!");
                        else System.out.println("Student not found.");
                        break;

                    case 5:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter correct data type.");
                sc.nextLine(); 
                choice = 0; // reset choice
            }

        } while (choice != 5);

        sc.close();
    }
}
