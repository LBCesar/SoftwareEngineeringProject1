

import java.util.*;

public class BankCustomer {

    private String name;
    private String email;
    private String address;
    private int cardNumber;
    private int pin;

    private int savingsAccountNumber;
    private double savingsBalance;
    private int checkingsAccountNumber;
    private double checkingsBalance;


    private checkingAccount cAccount = new checkingAccount();
    private savingsAccount sAccount = new savingsAccount();


    public BankCustomer(){

    }

    // public void BankCustomer(String n, String e, String a, int c, int p, int a1, double b1, int a2, double b2) {
    public void BankCustomer(String n, String e, String a, int c, int p, int a1, double b1) {
        name = n;
        email= e;
        address = a;
        cardNumber = c;
        pin = p;
        checkingsAccountNumber = a1;
        checkingsBalance = b1;
        // sAccount.setAccountNumber(a1);
        // sAccount.setBalance(b1);
        // cAccount.setAccountNumber(a2);
        // cAccount.setBalance(b2);
    }


    // public double deposit(double amount){
    //     return 0;
    // }


    // public double withdraw(double amount) {
    //     return amount;
    // }


    // public void balance() {
    //     System.out.println();
    // }


    // public void transfer(){
        
    // }


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
    

    public int getCheckingsAccountNumber(){
        return checkingsAccountNumber;
    }

    public void setCheckingsAccountNumber(int cAccNumber){
        cAccount.setAccountNumber(cAccNumber);
        checkingsAccountNumber = cAccount.getAccountNumber();
    }

    public double getCheckingsBalance(){
        return checkingsBalance;
    }

    public void setCheckingsBalance(double balance){
        cAccount.setBalance(balance);
        checkingsBalance  = cAccount.getBalance();
    }


    public int getSavingsAccountNumber(){
        return savingsAccountNumber;
    }

    public void setSavingsAccountNumber(int sAccNumber){
        sAccount.setAccountNumber(sAccNumber);
        savingsAccountNumber = sAccount.getAccountNumber();
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public void setSavingsBalance(double balance){
        sAccount.setBalance(balance);
        savingsBalance  = sAccount.getBalance();
    }

}
