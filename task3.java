import java.util.*;  // Importing utility package for List and Scanner

class Atm {
    // Static variables to store account details and a counter for account numbers
    public static int count = 0;
    public static List<String> acc_name = new ArrayList<String>();  // List to store account holder names
    public static List<Integer> acc_money = new ArrayList<Integer>();  // List to store account balances

    // Method to display the account number
    public static void acc_number() {
        System.out.println("Your Account Number : " + count);
    }

    // Method to create a new account
    public static void Create_account() {
        System.out.println("Enter your name: ");
        Scanner val = new Scanner(System.in);  // Creating a scanner object for name input
        String name = val.nextLine();  // Taking name input
        acc_name.add(name);  // Adding the name to the acc_name list
        count++;  // Incrementing account number
        acc_number();  // Display the new account number
        System.out.println("Enter the amount you want to add: ");
        Scanner amt = new Scanner(System.in);  // Creating another scanner object for money input
        int money = amt.nextInt();  // Taking money input
        acc_money.add(money);  // Adding the money to the acc_money list
        System.out.println("Account created successfully.");
    }

    // Method to withdraw money from an account
    public static void Withdraw() {
        System.out.println("Enter your Account number: ");
        Scanner number = new Scanner(System.in);  // Creating scanner object for account number input
        int acc_see = number.nextInt();  // Reading the account number
        int account = acc_see - 1;  // Adjusting for 0-based index
        System.out.println("Please enter the amount you wish to withdraw: ");
        Scanner amt = new Scanner(System.in);  // Scanner for withdrawal amount input
        int money = amt.nextInt();  // Reading the amount to withdraw
        int totalmoney = acc_money.get(account);  // Getting the current balance of the account

        // Check if withdrawal amount is greater than available balance
        if (money >= totalmoney) {
            System.out.println("Money can't be withdrawn as you have insufficient balance.");
        } else {
            int balance = totalmoney - money;  // Deducting the withdrawal amount from the balance
            acc_money.set(account, balance);  // Updating the account balance
            System.out.println("Money withdrawn successfully.");
        }
    }

    // Method to check the account balance
    public static void Check_balance() {
        System.out.println("Enter your Account number: ");
        Scanner number = new Scanner(System.in);  // Scanner for account number input
        int acc_see = number.nextInt();  // Reading account number
        int account = acc_see - 1;  // Adjusting for 0-based index
        System.out.println(acc_name.get(account));  // Displaying the account holder's name
        System.out.println(acc_money.get(account));  // Displaying the current balance
    }

    // Method to deposit money into an account
    public static void Deposit() {
        System.out.println("Enter your Account number: ");
        Scanner number = new Scanner(System.in);  // Scanner for account number input
        int acc_see = number.nextInt();  // Reading the account number
        int account = acc_see - 1;  // Adjusting for 0-based index
        System.out.println("Enter the amount to deposit: ");
        Scanner dep = new Scanner(System.in);  // Scanner for deposit amount input
        int dep_money = dep.nextInt();  // Reading the deposit amount
        int money = acc_money.get(account);  // Getting the current balance
        int totalmoney = money + dep_money;  // Adding the deposit to the current balance
        acc_money.set(account, totalmoney);  // Updating the account balance
    }

    // Method to transfer money between accounts
    public static void Transfer_money() {
        System.out.println("Enter your Account number: ");
        Scanner number = new Scanner(System.in);  // Scanner for account number input
        int acc_see = number.nextInt();  // Reading the sender's account number
        int account = acc_see - 1;  // Adjusting for 0-based index
        System.out.println("Please enter the account number you would like to transfer to: ");
        Scanner num2 = new Scanner(System.in);  // Scanner for recipient's account number input
        int acc_see2 = num2.nextInt();  // Reading the recipient's account number
        int account2 = acc_see2 - 1;  // Adjusting for 0-based index
        System.out.println("Enter the amount you would like to transfer: ");
        Scanner mo = new Scanner(System.in);  // Scanner for transfer amount input
        int money = mo.nextInt();  // Reading the transfer amount

        // Check if the sender has enough money to transfer
        if (acc_money.get(account) >= money) {
            int rupee = acc_money.get(account);  // Getting sender's current balance
            int rupee2 = acc_money.get(account2);  // Getting recipient's current balance
            rupee = rupee - money;  // Deducting the amount from the sender
            rupee2 = rupee2 + money;  // Adding the amount to the recipient
            acc_money.set(account, rupee);  // Updating sender's balance
            acc_money.set(account2, rupee2);  // Updating recipient's balance
            System.out.println("Money transferred successfully.");
        } else {
            System.out.println("You have insufficient funds to transfer.");
        }
    }

    // Method to exit the application
    public static void Exit() {
        System.exit(0);  // Exits the program
    }

    // Main interface for the ATM application
    public static void Atm_interface() {
        while (true) {  // Infinite loop for continuous operations
            System.out.println(" *** Banking Application *** ");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Transfer Money");
            System.out.println("6. Exit");
            Scanner num = new Scanner(System.in);  // Scanner for menu input
            int choice = num.nextInt();  // Reading the user's choice

            // Based on user choice, call appropriate function
            if (choice == 1) {
                Create_account();
            } else if (choice == 2) {
                Withdraw();
            } else if (choice == 3) {
                Check_balance();
            } else if (choice == 4) {
                Deposit();
            } else if (choice == 5) {
                Transfer_money();
            } else if (choice == 6) {
                Exit();
            } else {
                System.out.println("Invalid input from the user");
            }
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        Atm_interface();  // Calling the ATM interface method to start the program
    
    }
}