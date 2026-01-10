package Assignment_2;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegularExpression {

    // Method to validate input using regex
    public static boolean validate(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        try {
            do {
                System.out.println("REGEX Input Validation Menu");
                System.out.println("1. Validate Mobile Number");
                System.out.println("2. Validate Email ID");
                System.out.println("3. Validate Username");
                System.out.println("4. Validate Password");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Mobile Number: ");
                        String mobile = sc.nextLine();
                        String mobileRegex = "^[6-9][0-9]{9}$";

                        if (validate(mobile, mobileRegex))
                            System.out.println("Welcome! Valid Mobile Number.");
                        else
                            System.out.println("Invalid Mobile Number!");
                        break;

                    case 2:
                        System.out.print("Enter Email ID: ");
                        String email = sc.nextLine();
                        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

                        if (validate(email, emailRegex))
                            System.out.println("Welcome! Valid Email ID.");
                        else
                            System.out.println("Invalid Email ID!");
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        String username = sc.nextLine();
                        String userRegex = "^[A-Za-z0-9_]{5,15}$";

                        if (validate(username, userRegex))
                            System.out.println("Welcome! Valid Username.");
                        else
                            System.out.println("Invalid Username!");
                        break;

                    case 4:
                        System.out.print("Enter Password: ");
                        String password = sc.nextLine();
                        String passRegex =
                                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

                        if (validate(password, passRegex))
                            System.out.println("Welcome! Strong Password.");
                        else
                            System.out.println("Invalid Password!");
                        break;

                    case 5:
                        System.out.println("Exiting Program. Thank you!");
                        break;

                    default:
                        System.out.println("Invalid Choice! Please try again.");
                }

            } while (choice != 5);

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter correct data.");
        } finally {
            sc.close();
        }
    }
}
