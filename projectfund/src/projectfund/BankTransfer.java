package projectfund;
import java.util.Scanner;

public class BankTransfer {
    String fromAcc;
    String toAcc;
    double amount;
    String branch;
    double fromAccBalance = 20000;
    Scanner scanner;

    public BankTransfer() {
        scanner = new Scanner(System.in);
    }

    public void checkBalance() {
        System.out.println("Current balance in account " + fromAcc + ": " + fromAccBalance);
    }

    public void fundTransfer() {
        if (fromAccBalance >= amount) {
            fromAccBalance -= amount;
            System.out.println(amount + " Transaction successful");
        } else {
            System.out.println("Insufficient funds or invalid amount for transfer");
        }
    }

    public void startTransaction() {
        System.out.println(fromAcc);
        System.out.println(toAcc);
        System.out.println(branch);

        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Fund Transfer");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
            	case 1:
            		checkBalance();
            		break;
            	case 2:
                	System.out.print("Enter amount to transfer: ");
                    amount = scanner.nextDouble();
                    fundTransfer();
                    checkBalance();
                    break;
               
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        BankTransfer transaction = new BankTransfer();
        transaction.fromAcc = "93455";
        transaction.toAcc = "66949";
        transaction.branch = "Indian Bank Mela Anupanadi";
        
        transaction.startTransaction();
    }
}