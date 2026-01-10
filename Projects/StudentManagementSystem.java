package Projects;

import java.io.*;
import java.util.*;

/* ================= STUDENT MANAGEMENT SYSTEM ================= */
public class StudentManagementSystem {

    /* ---------- Student class ---------- */
    static class Student implements Serializable {
        private int eno;
        private String name;
        private String branch;
        private int semester;
        private double percentage;

        public Student(int eno, String name, String branch, int semester, double percentage) {
            this.eno = eno;
            this.name = name;
            this.branch = branch;
            this.semester = semester;
            this.percentage = percentage;
        }

        public int getEno() { return eno; }
        public String getName() { return name; }
        public String getBranch() { return branch; }
        public int getSemester() { return semester; }
        public double getPercentage() { return percentage; }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        @Override
        public String toString() {
            return "Eno: " + eno +
                   ", Name: " + name +
                   ", Branch: " + branch +
                   ", Semester: " + semester +
                   ", Percentage: " + percentage;
        }
    }

    /* ---------- Data members ---------- */
    private static final String FILE_NAME = "students.dat";
    private static Map<Integer, Student> students = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    /* ---------- MAIN METHOD ---------- */
    public static void main(String[] args) {

        loadStudents();

        if (!login()) {
            System.out.println("Login Failed! Exiting...");
            return;
        }

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Enrollment No");
            System.out.println("4. Update Student Branch");
            System.out.println("5. Delete Student");
            System.out.println("6. Display Students Sorted by Name");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateBranch();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    displaySortedStudents();
                    break;
                case 7:
                    saveStudents();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    /* ---------- Login ---------- */
    private static boolean login() {
        System.out.println("--- Login ---");
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        return user.equals("admin") && pass.equals("admin123");
    }

    /* ---------- Add Student ---------- */
    private static void addStudent() {
        System.out.print("Enter Enrollment No: ");
        int eno = sc.nextInt();
        sc.nextLine();

        if (students.containsKey(eno)) {
            System.out.println("Enrollment No already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter Semester: ");
        int sem = sc.nextInt();

        System.out.print("Enter Percentage: ");
        double per = sc.nextDouble();

        students.put(eno, new Student(eno, name, branch, sem, per));
        saveStudents();
        System.out.println("Student added successfully!");
    }

    /* ---------- Display All ---------- */
    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Student s : students.values()) {
            System.out.println(s);
        }
    }

    /* ---------- Search ---------- */
    private static void searchStudent() {
        System.out.print("Enter Enrollment No: ");
        int eno = sc.nextInt();

        Student s = students.get(eno);
        if (s != null)
            System.out.println(s);
        else
            System.out.println("Student not found!");
    }

    /* ---------- Update Branch ---------- */
    private static void updateBranch() {
        System.out.print("Enter Enrollment No: ");
        int eno = sc.nextInt();
        sc.nextLine();

        Student s = students.get(eno);
        if (s != null) {
            System.out.print("Enter new Branch: ");
            s.setBranch(sc.nextLine());
            saveStudents();
            System.out.println("Branch updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    /* ---------- Delete ---------- */
    private static void deleteStudent() {
        System.out.print("Enter Enrollment No: ");
        int eno = sc.nextInt();

        if (students.remove(eno) != null) {
            saveStudents();
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    /* ---------- Display Sorted ---------- */
    private static void displaySortedStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        List<Student> list = new ArrayList<>(students.values());
        list.sort(Comparator.comparing(Student::getName));

        for (Student s : list) {
            System.out.println(s);
        }
    }

    /* ---------- File Save ---------- */
    private static void saveStudents() {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving data");
        }
    }

    /* ---------- File Load ---------- */
    private static void loadStudents() {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (Map<Integer, Student>) in.readObject();
        } catch (Exception e) {
            students = new HashMap<>();
        }
    }
}
