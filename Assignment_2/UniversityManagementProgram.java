package Assignment_2;
import java.util.*;
import java.util.regex.*;

// INTERFACE
interface StudentOperations {
    void addStudent();
    void displayStudents();
    void removeStudentById();
    void searchStudentById();
    void sortStudentsByMarks();
}

// STUDENT CLASS (RENAMED)
class StudentA1 {
    int id;
    String name;
    String course;
    double marks;

    StudentA1(int id, String name, String course, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public String toString() {
        return id + "\t" + name + "\t" + course + "\t" + marks;
    }
}

// MANAGEMENT CLASS
class UniversityManagement implements StudentOperations {

    List<StudentA1> arrayList = new ArrayList<>();
    Vector<StudentA1> vector = new Vector<>();
    Stack<StudentA1> stack = new Stack<>();

    HashMap<Integer, StudentA1> hashMap = new HashMap<>();
    Hashtable<Integer, StudentA1> hashtable = new Hashtable<>();
    Set<String> courseSet = new HashSet<>();

    Scanner sc = new Scanner(System.in);

    Pattern nameRegex = Pattern.compile("^[A-Za-z ]+$");
    Pattern courseRegex = Pattern.compile("^[A-Za-z]+$");

    // ADD STUDENT
    public void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            if (hashMap.containsKey(id))
                throw new Exception("Duplicate Student ID not allowed");

            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            if (!nameRegex.matcher(name).matches())
                throw new Exception("Invalid Name");

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            if (!courseRegex.matcher(course).matches())
                throw new Exception("Invalid Course Name");

            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();

            StudentA1 s = new StudentA1(id, name, course, marks);

            arrayList.add(s);
            vector.add(s);
            stack.push(s);
            hashMap.put(id, s);
            hashtable.put(id, s);
            courseSet.add(course);

            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DISPLAY STUDENTS
    public void displayStudents() {
        if (arrayList.isEmpty()) {
            System.out.println("No student records found");
            return;
        }

        System.out.println("\nID\tName\tCourse\tMarks");
        for (StudentA1 s : arrayList)
            System.out.println(s);
    }

    // REMOVE STUDENT
    public void removeStudentById() {
        System.out.print("Enter ID to remove: ");
        int id = sc.nextInt();

        StudentA1 s = hashMap.remove(id);
        if (s != null) {
            arrayList.remove(s);
            vector.remove(s);
            stack.remove(s);
            hashtable.remove(id);
            System.out.println("Student Removed Successfully!");
        } else {
            System.out.println("Student Not Found");
        }
    }

    // SEARCH STUDENT
    public void searchStudentById() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        StudentA1 s = hashMap.get(id);
        if (s != null)
            System.out.println("Student Found: " + s);
        else
            System.out.println("Student Not Found");
    }

    // SORT BY MARKS
    public void sortStudentsByMarks() {
        arrayList.sort(Comparator.comparingDouble(st -> st.marks));
        System.out.println("Students Sorted By Marks");
        displayStudents();
    }

    // HASHMAP TO TREEMAP
    public void convertToTreeMap() {
        TreeMap<Integer, StudentA1> treeMap = new TreeMap<>(hashMap);

        System.out.println("\nTreeMap (Sorted by ID):");
        for (Map.Entry<Integer, StudentA1> e : treeMap.entrySet())
            System.out.println(e.getValue());
    }

    // COURSE-WISE COUNT
    public void countCourseWise() {
        HashMap<String, Integer> countMap = new HashMap<>();

        for (StudentA1 s : arrayList)
            countMap.put(s.course, countMap.getOrDefault(s.course, 0) + 1);

        System.out.println("\nCourse-wise Student Count:");
        for (Map.Entry<String, Integer> e : countMap.entrySet())
            System.out.println(e.getKey() + " : " + e.getValue());
    }

    // DISPLAY COURSES
    public void displayCourses() {
        System.out.println("\nAvailable Courses:");
        for (String c : courseSet)
            System.out.println(c);
    }
}

// MAIN CLASS
public class UniversityManagementProgram {

    public static void main(String[] args) {

        UniversityManagement um = new UniversityManagement();
        try (Scanner sc = new Scanner(System.in)) {
			while (true) {
			    System.out.println("\nUNIVERSITY STUDENT MANAGEMENT ->");
			    System.out.println("1. Add Student");
			    System.out.println("2. Display Students");
			    System.out.println("3. Remove Student by ID");
			    System.out.println("4. Search Student by ID");
			    System.out.println("5. Sort Students by Marks");
			    System.out.println("6. Convert HashMap to TreeMap");
			    System.out.println("7. Count Students Course-wise");
			    System.out.println("8. Display All Courses");
			    System.out.println("9. Exit");

			    System.out.print("Enter Choice: ");
			    int choice = sc.nextInt();

			    switch (choice) {
			        case 1 -> um.addStudent();
			        case 2 -> um.displayStudents();
			        case 3 -> um.removeStudentById();
			        case 4 -> um.searchStudentById();
			        case 5 -> um.sortStudentsByMarks();
			        case 6 -> um.convertToTreeMap();
			        case 7 -> um.countCourseWise();
			        case 8 -> um.displayCourses();
			        case 9 -> {
			            System.out.println("Thank You!");
			            System.exit(0);
			        }
			        default -> System.out.println("Invalid Choice");
			    }
			}
		}
    }
}
