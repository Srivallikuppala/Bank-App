import java.util.Scanner;

// Class representing a Bank Account
class BankAccount {
    // Attributes of the Bank Account
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor to initialize the account
    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check account balance
    public void checkBalance() {
        System.out.println("Account Balance: " + balance);
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}

// Main class
public class BankApp {
    public static void main(String[] args) {
        // Scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Creating a new bank account
        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(accountHolderName, accountNumber, initialBalance);

        int choice;

        // Basic menu-driven program
        do {
            System.out.println("\nBank Account Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.displayAccountDetails();
                    break;

                case 5:
                    System.out.println("Thank you for using the Bank App.");
                    break;

                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while (choice != 5);

        // Close the scanner to prevent resource leaks
        sc.close();
    }
}
