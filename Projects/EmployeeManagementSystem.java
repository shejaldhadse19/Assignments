package Projects;
import java.io.*;
import java.util.*;

// Employee class
class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary;
    }
}

// Main Employee Management System
public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.dat";
    private static Map<Integer, Employee> employees = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadEmployees();
        if (!login()) {
            System.out.println("Login Failed! Exiting...");
            System.exit(0);
        }

        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Sorted Employees");
            System.out.println("7. Display Departments");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> displayAllEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateSalary();
                case 5 -> deleteEmployee();
                case 6 -> displaySortedEmployees();
                case 7 -> displayDepartments();
                case 8 -> {
                    saveEmployees();
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // Secure Login System
    private static boolean login() {
        System.out.println("--- Login ---");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        // Simple validation (can be enhanced)
        return username.equals("admin") && password.equals("admin123");
    }

    // Add Employee
    private static void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            if (employees.containsKey(id)) {
                System.out.println("Error: Employee ID already exists!");
                return;
            }

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            if (dept.isEmpty()) {
                System.out.println("Error: Department cannot be empty!");
                return;
            }

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            if (salary <= 0) {
                System.out.println("Error: Salary must be positive!");
                return;
            }

            Employee emp = new Employee(id, name, dept, salary);
            employees.put(id, emp);
            saveEmployees();
            System.out.println("Employee added successfully!");

        } catch (Exception e) {
            System.out.println("Error: Invalid input!");
            sc.nextLine(); // clear buffer
        }
    }

    // Display All Employees
    private static void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        employees.values().forEach(System.out::println);
    }

    // Search Employee by ID
    private static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();
        Employee emp = employees.get(id);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Update Employee Salary
    private static void updateSalary() {
        System.out.print("Enter Employee ID to update salary: ");
        int id = sc.nextInt();
        Employee emp = employees.get(id);
        if (emp != null) {
            System.out.print("Enter new salary: ");
            double salary = sc.nextDouble();
            if (salary <= 0) {
                System.out.println("Error: Salary must be positive!");
                return;
            }
            emp.setSalary(salary);
            saveEmployees();
            System.out.println("Salary updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Delete Employee
    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();
        if (employees.remove(id) != null) {
            saveEmployees();
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Display Sorted Employees (by Name)
    private static void displaySortedEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        employees.values().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);
    }

    // Display Departments
    private static void displayDepartments() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        Set<String> departments = new HashSet<>();
        for (Employee emp : employees.values()) {
            departments.add(emp.getDepartment());
        }
        System.out.println("Departments: " + departments);
    }

    // Save employees to file
    private static void saveEmployees() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    // Load employees from file
    private static void loadEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (Map<Integer, Employee>) ois.readObject();
        } catch (Exception e) {
            employees = new HashMap<>();
        }
    }
}
