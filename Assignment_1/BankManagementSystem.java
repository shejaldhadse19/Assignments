package Assignment_1;
import java.util.Scanner;

//Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 public InsufficientBalanceException(String message) {
     super(message);
 }
}

//Bank Account Class
class BankAccount {

 private int accountNumber;
 private String accountHolderName;
 private double balance;

 // Constructor
 BankAccount(int accNo, String name, double bal) {
     accountNumber = accNo;
     accountHolderName = name;
     balance = bal;
 }

 // Deposit Method
 void deposit(double amount) throws IllegalArgumentException {
     if (amount <= 0) {
         throw new IllegalArgumentException("Deposit amount must be greater than zero.");
     }
     balance += amount;
     System.out.println("Amount Deposited Successfully!");
 }

 // Withdraw Method
 void withdraw(double amount) throws InsufficientBalanceException {
     if (amount > balance) {
         throw new InsufficientBalanceException("Insufficient Balance!");
     }
     balance -= amount;
     System.out.println("Amount Withdrawn Successfully!");
 }

 // Balance Enquiry
 void checkBalance() {
     System.out.println("Current Balance: ₹" + balance);
 }

 // Display Account Details
 void displayDetails() {
     System.out.println("\n--- Account Details ---");
     System.out.println("Account Number : " + accountNumber);
     System.out.println("Account Holder : " + accountHolderName);
     System.out.println("Balance        : ₹" + balance);
 }
}

//Main Class
public class BankManagementSystem {

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     System.out.println("=== Create Bank Account ===");
     System.out.print("Enter Account Number: ");
     int accNo = sc.nextInt();
     sc.nextLine();

     System.out.print("Enter Account Holder Name: ");
     String name = sc.nextLine();

     System.out.print("Enter Initial Balance: ");
     double balance = sc.nextDouble();

     BankAccount account = new BankAccount(accNo, name, balance);

     int choice;

     do {
         System.out.println("\n===== BANK MENU =====");
         System.out.println("1. Deposit");
         System.out.println("2. Withdraw");
         System.out.println("3. Balance Enquiry");
         System.out.println("4. Account Details");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");

         choice = sc.nextInt();

         try {
             switch (choice) {

                 case 1:
                     System.out.print("Enter amount to deposit: ");
                     double depAmount = sc.nextDouble();
                     account.deposit(depAmount);
                     break;

                 case 2:
                     System.out.print("Enter amount to withdraw: ");
                     double withAmount = sc.nextDouble();
                     account.withdraw(withAmount);
                     break;

                 case 3:
                     account.checkBalance();
                     break;

                 case 4:
                     account.displayDetails();
                     break;

                 case 5:
                     System.out.println("Thank you for using Bank Management System!");
                     break;

                 default:
                     System.out.println("Invalid Choice! Please select 1 to 5.");
             }

         } catch (IllegalArgumentException e) {
             System.out.println("Error: " + e.getMessage());

         } catch (InsufficientBalanceException e) {
             System.out.println("Error: " + e.getMessage());
         }

     } while (choice != 5);

     sc.close();
 }
}

