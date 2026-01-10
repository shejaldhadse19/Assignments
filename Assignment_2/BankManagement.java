package Assignment_2;

import java.util.Scanner;

	// Interface for banking operations
	interface BankOperations {
	    void deposit(double amount);
	    void withdraw(double amount);
	    void checkBalance();
	}

	// Interface for customer-related operations
	interface CustomerOperations {
	    void displayCustomerDetails();
	}

	// BankAccount class implementing multiple interfaces
	class BankAccount implements BankOperations, CustomerOperations {

	    private int accountNumber;
	    private String customerName;
	    private double balance;

	    // Constructor
	    BankAccount(int accNo, String name, double initialBalance) {
	        this.accountNumber = accNo;
	        this.customerName = name;
	        this.balance = initialBalance;
	    }

	    // Deposit method
	    public void deposit(double amount) {
	        try {
	            if (amount <= 0)
	                throw new IllegalArgumentException("Invalid deposit amount!");

	            balance += amount;
	            System.out.println("Deposit Successful. Amount: " + amount);
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    // Withdraw method
	    public void withdraw(double amount) {
	        try {
	            if (amount <= 0)
	                throw new IllegalArgumentException("Invalid withdrawal amount!");

	            if (amount > balance)
	                throw new ArithmeticException("Insufficient balance!");

	            balance -= amount;
	            System.out.println("Withdrawal Successful. Amount: " + amount);
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    // Check balance
	    public void checkBalance() {
	        System.out.println("Current Balance: " + balance);
	    }

	    // Display customer details
	    public void displayCustomerDetails() {
	        System.out.println("\n--- Customer Details ---");
	        System.out.println("Account Number : " + accountNumber);
	        System.out.println("Customer Name  : " + customerName);
	        System.out.println("Balance        : " + balance);
	    }
	}

	// Main class
	public class BankManagement {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        // Creating bank account object
	        BankAccount account = new BankAccount(101, "Rahul Sharma", 5000);

	        int choice;

	        do {
	            System.out.println("\n--- Bank Menu ---");
	            System.out.println("1. Deposit");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Check Balance");
	            System.out.println("4. Display Customer Details");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");

	            choice = sc.nextInt();

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
	                    account.displayCustomerDetails();
	                    break;

	                case 5:
	                    System.out.println("Thank you for banking with us!");
	                    break;

	                default:
	                    System.out.println("Invalid choice!");
	            }

	        } while (choice != 5);

	        sc.close();
	    }
	}
