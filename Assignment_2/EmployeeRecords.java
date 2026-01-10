package Assignment_2;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Employee {
    private int empId;
    private String name;
    private String department;
    private double salary;

    public Employee(int empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getEmpId() { return empId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "ID: " + empId + ", Name: " + name + ", Dept: " + department + ", Salary: " + salary;
    }
}

public class EmployeeRecords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Employee> hashMap = new HashMap<>();
        Map<Integer, Employee> hashTable = new Hashtable<>();
        Map<Integer, Employee> treeMap = new TreeMap<>();

        int choice;

        do {
            System.out.println("\nEmployee Records Menu ->");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double sal = sc.nextDouble();
                        sc.nextLine();

                        Employee emp = new Employee(id, name, dept, sal);

                        // Add to HashMap
                        hashMap.put(id, emp);
                        // Add to Hashtable
                        try {
                            hashTable.put(id, emp);
                        } catch (NullPointerException e) {
                            System.out.println("Hashtable does not allow null key/value.");
                        }
                        // Add to TreeMap
                        treeMap.put(id, emp);

                        System.out.println("Employee added successfully!");
                        break;

                    case 2:
                        System.out.println("\nHashMap Employees ->");
                        hashMap.forEach((k, v) -> System.out.println(v));

                        System.out.println("\nHashtable Employees ->");
                        hashTable.forEach((k, v) -> System.out.println(v));

                        System.out.println("\nTreeMap Employees (Sorted by ID) ->");
                        treeMap.forEach((k, v) -> System.out.println(v));
                        break;

                    case 3:
                        System.out.print("Enter Employee ID to search: ");
                        int sId = sc.nextInt();
                        sc.nextLine();

                        if (hashMap.containsKey(sId)) System.out.println("Found in HashMap -> " + hashMap.get(sId));
                        else System.out.println("Not found in HashMap.");

                        if (hashTable.containsKey(sId)) System.out.println("Found in Hashtable -> " + hashTable.get(sId));
                        else System.out.println("Not found in Hashtable.");

                        if (treeMap.containsKey(sId)) System.out.println("Found in TreeMap -> " + treeMap.get(sId));
                        else System.out.println("Not found in TreeMap.");
                        break;

                    case 4:
                        System.out.print("Enter Employee ID to delete: ");
                        int dId = sc.nextInt();
                        sc.nextLine();

                        if (hashMap.remove(dId) != null) System.out.println("Deleted from HashMap -> ID: " + dId);
                        else System.out.println("Not found in HashMap.");

                        if (hashTable.remove(dId) != null) System.out.println("Deleted from Hashtable -> ID: " + dId);
                        else System.out.println("Not found in Hashtable.");

                        if (treeMap.remove(dId) != null) System.out.println("Deleted from TreeMap -> ID: " + dId);
                        else System.out.println("Not found in TreeMap.");
                        break;

                    case 5:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter correct data.");
                sc.nextLine(); // consume invalid input
                choice = 0;
            }

        } while (choice != 5);

        sc.close();
    }
}
