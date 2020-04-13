

import java.util.*;

public class BankCustomer {
    //We can delete some of these variables, thier job can be done with function calls to cAccount and sAccount
    private String name;
    private String email;
    private String address;
    private int cardNumber;
    private int pin;
    private double totalBalance;//Needed?

    private int savingsAccountNumber;
    private double savingsBalance;//Needed?
    private int checkingsAccountNumber;
    private double checkingsBalance;//Needed?

    private checkingAccount cAccount = new checkingAccount();
    private savingsAccount sAccount = new savingsAccount();


    public BankCustomer(){

    }

    public void BankCustomer(String n, String e, String a, int c, int p, int a1, double b1, int a2, double b2) {
        name = n;
        email= e;
        address = a;
        cardNumber = c;
        pin = p;
        checkingsAccountNumber = a1;
        checkingsBalance = b1;
        savingsAccountNumber = a2;
        savingsBalance = b2;
    }


// -----------------------------------------------------------------------------


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }


    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }


    public int getCardNumber(){
        return cardNumber;
    }

    public void setCardNumber(int cardNumber){
        this.cardNumber = cardNumber;
    }


    public int getPIN(){
        return pin;
    }

    public void setPIN(int pin){
        this.pin = pin;
    }


// -----------------------------------------------------------------------------    


    public int getCheckingsAccountNumber(){
        return checkingsAccountNumber;
    }

    public void setCheckingsAccountNumber(int cAccNumber){
        cAccount.setAccountNumber(cAccNumber);
        checkingsAccountNumber = cAccount.getAccountNumber();
    }

    public double getCheckingsBalance(){
        //return checkingsBalance;       This was returning the variable in customer, should be from the checking object.
        return cAccount.getBalance();
    }

    public void setCheckingsBalance(double balance){
        cAccount.setBalance(balance);
        checkingsBalance  = cAccount.getBalance();
    }

// -----------------------------------------------------------------------------

    public int getSavingsAccountNumber(){
        return savingsAccountNumber;
    }

    public void setSavingsAccountNumber(int sAccNumber){
        sAccount.setAccountNumber(sAccNumber);
        savingsAccountNumber = sAccount.getAccountNumber();
    }

    public double getSavingsBalance(){
        //return savingsBalance;
        return sAccount.getBalance();
    }

    public void setSavingsBalance(double balance){
        sAccount.setBalance(balance);
        savingsBalance  = sAccount.getBalance();
    }


// -----------------------------------------------------------------------------

    //If we calculate this with sAccount and cAccount function we wont need to stare any data in BankCustomer
    public void checkBalance() {
        totalBalance = savingsBalance + checkingsBalance;
        System.out.println("Checkings Account Balance: " + "$ " + checkingsBalance);
        System.out.println("Savings Account Balance: " + "$ " + savingsBalance);
        System.out.println("Total Balance: " + "$ " + totalBalance);
    }


    public void transferBalance(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Transfer Balance");

        // System.out.println("1. Transfer from checkings to savings");
        // System.out.println("2. Transfer from savings to checkings");

        // int option = scan.nextInt();
        int option = 1;
        double transferAmount;          // user input transfer amount
        double t;                       // a dummy transfer variable

        if(option == 1){
            System.out.println("Transfering from checkings to savings: $50.00");
            // System.out.print("Enter the amount you want to transfer: ");
            // transferAmount = scan.nextDouble();
            transferAmount = 50;
            
            checkingsWithdraw(transferAmount);
            savingsDeposit(transferAmount);
        }

        else if(option == 2){
            System.out.println("Transfering from savings to checkings");
            // System.out.print("Enter the amount you want to transfer: ");
            transferAmount = scan.nextDouble();

            savingsWithdraw(transferAmount);
            checkingsDeposit(transferAmount);
        }

    }


// -----------------------------------------------------------------------------


    public void checkingsDeposit(double amount){//Delete all output later
        System.out.println("BankCustomer: $"+amount);
        cAccount.addBalance(amount);
        //checkingsBalance = cAccount.getBalance();
        //cAccount.setBalance(checkingsBalance);
    }

    public void checkingsWithdraw(double amount){
        cAccount.minusBalance(amount);
        checkingsBalance = cAccount.getBalance();
        cAccount.setBalance(checkingsBalance);
    }


    public void savingsDeposit(double amount){//Delete all output later.
                System.out.println("BankCustomer: $"+amount);

        sAccount.addBalance(amount);
        //savingsBalance = sAccount.getBalance();
        //sAccount.setBalance(savingsBalance);
    }

    public void savingsWithdraw(double amount){
        sAccount.minusBalance(amount);
        savingsBalance = sAccount.getBalance();
        sAccount.setBalance(savingsBalance);
    }

}
