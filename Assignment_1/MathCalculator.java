package Assignment_1;
import java.util.Scanner;

public class MathCalculator {

	    // Addition
	    static int add(int a, int b) {
	        return a + b;
	    }

	    // Subtraction
	    static int subtract(int a, int b) {
	        return a - b;
	    }

	    // Multiplication
	    static int multiply(int a, int b) {
	        return a * b;
	    }

	    // Division
	    static int divide(int a, int b) {
	        return a / b;
	    }

	    // Remainder
	    static int remainder(int a, int b) {
	        return a % b;
	    }

	    // Square
	    static int square(int a) {
	        return a * a;
	    }

	    // Cube
	    static int cube(int a) {
	        return a * a * a;
	    }

	    // Absolute
	    static int absolute(int a) {
	        return Math.abs(a);
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        char choice;

	        do {
	            System.out.println("\n----- BASIC MATH OPERATIONS -----");
	            System.out.println("1. Addition");
	            System.out.println("2. Subtraction");
	            System.out.println("3. Multiplication");
	            System.out.println("4. Division");
	            System.out.println("5. Remainder");
	            System.out.println("6. Square");
	            System.out.println("7. Cube");
	            System.out.println("8. Absolute Value");

	            System.out.print("Enter your choice (1-8): ");
	            int option = sc.nextInt();

	            System.out.print("Enter first number: ");
	            int num1 = sc.nextInt();

	            int num2 = 0;
	            if (option <= 5) {
	                System.out.print("Enter second number: ");
	                num2 = sc.nextInt();
	            }

	            switch (option) {

	                case 1:
	                    System.out.println("Result: " + add(num1, num2));
	                    break;

	                case 2:
	                    System.out.println("Result: " + subtract(num1, num2));
	                    break;

	                case 3:
	                    System.out.println("Result: " + multiply(num1, num2));
	                    break;

	                case 4:
	                    System.out.println("Result: " + divide(num1, num2));
	                    break;

	                case 5:
	                    System.out.println("Result: " + remainder(num1, num2));
	                    break;

	                case 6:
	                    System.out.println("Square: " + square(num1));
	                    break;

	                case 7:
	                    System.out.println("Cube: " + cube(num1));
	                    break;

	                case 8:
	                    System.out.println("Absolute Value: " + absolute(num1));
	                    break;

	                default:
	                    System.out.println("Invalid Choice!");
	            }

	            System.out.print("\nDo you want to perform another operation? (y/n): ");
	            choice = sc.next().charAt(0);

	        } while (choice == 'y' || choice == 'Y');

	        System.out.println("\nThank you! Program Ended.");
	        sc.close();
	    }
	}
