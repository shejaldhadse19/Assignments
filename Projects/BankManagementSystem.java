package Projects;

import java.io.*;
import java.util.*;

// Abstract class for Bank Account
abstract class BankAccount implements Serializable {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public abstract void displayAccountDetails();

    // Deposit method (can be overloaded)
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void deposit(double amount, String remark) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | Remark: " + remark);
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

// Savings Account class
class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    // Overriding abstract method
    @Override
    public void displayAccountDetails() {
        System.out.println("----- Savings Account Details -----");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

// Current Account class
class CurrentAccount extends BankAccount {

    public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    // Overriding abstract method
    @Override
    public void displayAccountDetails() {
        System.out.println("----- Current Account Details -----");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

// Main Bank Management System
public class BankManagementSystem {
    private static final String FILE_NAME = "accounts.dat";
    private static List<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        loadAccounts();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount(sc);
                case 2 -> depositMoney(sc);
                case 3 -> withdrawMoney(sc);
                case 4 -> checkBalance(sc);
                case 5 -> displayAccountDetails(sc);
                case 6 -> {
                    saveAccounts();
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // Create account
    private static void createAccount(Scanner sc) {
        sc.nextLine(); // consume newline
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        System.out.print("Select Account Type (1. Savings 2. Current): ");
        int type = sc.nextInt();

        BankAccount account;
        if (type == 1) {
            account = new SavingsAccount(accNo, name, balance);
        } else {
            account = new CurrentAccount(accNo, name, balance);
        }
        accounts.add(account);
        System.out.println("Account created successfully!");
    }

    // Deposit
    private static void depositMoney(Scanner sc) {
        BankAccount account = findAccount(sc);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amt = sc.nextDouble();
            account.deposit(amt);
        }
    }

    // Withdraw
    private static void withdrawMoney(Scanner sc) {
        BankAccount account = findAccount(sc);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amt = sc.nextDouble();
            account.withdraw(amt);
        }
    }

    // Check balance
    private static void checkBalance(Scanner sc) {
        BankAccount account = findAccount(sc);
        if (account != null) {
            account.checkBalance();
        }
    }

    // Display account details
    private static void displayAccountDetails(Scanner sc) {
        BankAccount account = findAccount(sc);
        if (account != null) {
            account.displayAccountDetails();
        }
    }

    // Find account by account number
    private static BankAccount findAccount(Scanner sc) {
        sc.nextLine(); // consume newline
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        for (BankAccount acc : accounts) {
            if (acc.accountNumber.equals(accNo)) {
                return acc;
            }
        }
        System.out.println("Account not found!");
        return null;
    }

    // Save accounts to file
    private static void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    // Load accounts from file
    private static void loadAccounts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            accounts = (List<BankAccount>) ois.readObject();
        } catch (Exception e) {
            accounts = new ArrayList<>();
        }
    }
}
