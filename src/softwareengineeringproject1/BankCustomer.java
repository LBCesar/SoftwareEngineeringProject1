

import java.util.*;

public class BankCustomer {
    private String name;
    private String email;
    private String address;
    private int cardNumber;
    private int pin;
    //private double totalBalance;//Needed?

    //private int savingsAccountNumber;
    //private double savingsBalance;//Needed?
    //private int checkingsAccountNumber;
    //private double checkingsBalance;//Needed?

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
        //checkingsAccountNumber = a1;
        cAccount.setAccountNumber(a1);
        //checkingsBalance = b1;
        cAccount.setBalance(b1);
        //savingsAccountNumber = a2;
        sAccount.setAccountNumber(a2);
        //savingsBalance = b2;
        sAccount.setBalance(b2);
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


//    public int getCheckingsAccountNumber(){
//        return checkingsAccountNumber;
//    }
    public int getCheckingsAccountNumber(){
        return cAccount.getAccountNumber();
    }

//    public void setCheckingsAccountNumber(int cAccNumber){
//        cAccount.setAccountNumber(cAccNumber);
//        checkingsAccountNumber = cAccount.getAccountNumber();
//    }
    public void setCheckingsAccountNumber(int cAccNumber){
        cAccount.setAccountNumber(cAccNumber);
    }

    public double getCheckingsBalance(){
        //return checkingsBalance;      
        return cAccount.getBalance();
    }

//    public void setCheckingsBalance(double balance){
//        cAccount.setBalance(balance);
//        checkingsBalance  = cAccount.getBalance();
//    }
    public void setCheckingsBalance(double balance){
        cAccount.setBalance(balance);
    }

// -----------------------------------------------------------------------------

//    public int getSavingsAccountNumber(){
//        return savingsAccountNumber;
//    }
    public int getSavingsAccountNumber(){
        return sAccount.getAccountNumber();
    }

//    public void setSavingsAccountNumber(int sAccNumber){
//        sAccount.setAccountNumber(sAccNumber);
//        savingsAccountNumber = sAccount.getAccountNumber();
//    }
    public void setSavingsAccountNumber(int sAccNumber){
        sAccount.setAccountNumber(sAccNumber);
    }

    public double getSavingsBalance(){
        //return savingsBalance;
        return sAccount.getBalance();
    }

//    public void setSavingsBalance(double balance){
//        sAccount.setBalance(balance);
//        savingsBalance  = sAccount.getBalance();
//    }
    public void setSavingsBalance(double balance){
        sAccount.setBalance(balance);
    }


// -----------------------------------------------------------------------------

//    //If we calculate this with sAccount and cAccount function we wont need to stare any data in BankCustomer
//    public void checkBalance() {
//        totalBalance = savingsBalance + checkingsBalance;
//        System.out.println("Checkings Account Balance: " + "$ " + checkingsBalance);
//        System.out.println("Savings Account Balance: " + "$ " + savingsBalance);
//        System.out.println("Total Balance: " + "$ " + totalBalance);
//    }
//
//
//    public void transferBalance(){
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Transfer Balance");
//
//        // System.out.println("1. Transfer from checkings to savings");
//        // System.out.println("2. Transfer from savings to checkings");
//
//        // int option = scan.nextInt();
//        int option = 1;
//        double transferAmount;          // user input transfer amount
//        double t;                       // a dummy transfer variable
//
//        if(option == 1){
//            System.out.println("Transfering from checkings to savings: $50.00");
//            // System.out.print("Enter the amount you want to transfer: ");
//            // transferAmount = scan.nextDouble();
//            transferAmount = 50;
//            
//            checkingsWithdraw(transferAmount);
//            savingsDeposit(transferAmount);
//        }
//
//        else if(option == 2){
//            System.out.println("Transfering from savings to checkings");
//            // System.out.print("Enter the amount you want to transfer: ");
//            transferAmount = scan.nextDouble();
//
//            savingsWithdraw(transferAmount);
//            checkingsDeposit(transferAmount);
//        }
//
//    }


// -----------------------------------------------------------------------------

     public checkingAccount getCheckingAccount()
    {
    	return cAccount;
    }
    public savingsAccount getSavingsAccount()
    {
    	return sAccount;
    }

    public void checkingsDeposit(double amount){//Delete all output later
        cAccount.addBalance(amount);
        //checkingsBalance = cAccount.getBalance();
        //cAccount.setBalance(checkingsBalance);
    }

//    public void checkingsWithdraw(double amount){
//        cAccount.minusBalance(amount);
//        checkingsBalance = cAccount.getBalance();
//        cAccount.setBalance(checkingsBalance);
//    }
    public void checkingsWithdraw(double amount){
        cAccount.minusBalance(amount);
    }

    public void savingsDeposit(double amount){//Delete all output later.

        sAccount.addBalance(amount);
        //savingsBalance = sAccount.getBalance();
        //sAccount.setBalance(savingsBalance);
    }

//    public void savingsWithdraw(double amount){
//        sAccount.minusBalance(amount);
//        savingsBalance = sAccount.getBalance();
//        sAccount.setBalance(savingsBalance);
//    }
    public void savingsWithdraw(double amount){
        sAccount.minusBalance(amount);
    }

}
