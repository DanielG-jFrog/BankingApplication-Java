import java.util.Scanner;

public class BankAccount {

    //customer properties
    public static int balance;
    public static String customerName;
    public static int customerId;
    public static Scanner scanner;


    //methods

    public static void userIdentification(){
        scanner =  new Scanner(System.in);
        System.out.println("Hello and welcome");
        System.out.println("Please enter your name and ID below:");
        System.out.println("Name:");
        String name = scanner.next();
        customerName = name;
        System.out.println("ID:");
        String id = scanner.next();
        //TODO perform a match between the entered data to the data on disk
    }

    public static void userIntecation(){
        System.out.println("Hello "+ customerName + " Please choose your wanted operation:");
        System.out.println("A - Make a Deposit");
        System.out.println("B - Show current Balance");
        System.out.println("C - Withdraw amount");
        System.out.println("D - Cancel operation");
        scanner = new Scanner(System.in);
        String action = scanner.next();
        String userAction = action.toUpperCase();

        switch (userAction){
            case "A":
                deposit();
                break;
            case "B":
                showBalance();
                break;
            case "C":
                withdraw();
                break;
            case "D":
                System.exit(0);
                break;
            default:
               System.out.println("Please enter a valid operation code");
        }
    }

    public static int withdraw(){
        scanner = new Scanner(System.in);
        int withDrawAmount = 0;
        try {
            withDrawAmount = Integer.parseInt(scanner.next());
        }
        catch (Exception e){
            System.out.println("Please enter a valid withdraw amount");
        }

        int newBalance = balance - withDrawAmount;

        if (newBalance >= 0){
            balance = balance - withDrawAmount;
        }
        else{
            System.out.println("The balance is not sufficient to complete the withdraw");
        }
        return balance;
    }

    public static void deposit(){
        scanner = new Scanner(System.in);
        System.out.println("Please enter your deposit amount");
        try {
            int depositAmount = scanner.nextInt();
            balance = balance + depositAmount;
        }
        catch (Exception e){
            System.out.println("Please enter a valid deposit amount");
        }
    }

    public static void showBalance(){
        System.out.println(balance);
    }

    public static void validateUseIdIsValid(int id){
        //TODO check that user id has a valid pattern and exists on disk
    }


    public static void main(String[] args){
        BankAccount account = new BankAccount();
        account.balance = 1000;
        account.userIdentification();
        account.userIntecation();
    }
}
