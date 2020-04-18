

import java.util.*;

public class BankCustomer {
    private String name;
    private String email;
    private String address;
    private int cardNumber;
    private int pin;

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
        cAccount.setAccountNumber(a1);
        cAccount.setBalance(b1);
        sAccount.setAccountNumber(a2);
        sAccount.setBalance(b2);
    }


//=====================================Personal Information===========
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
    //================================Banking Information===============
    public checkingAccount getCheckingAccount()
    {
    	return cAccount;
    }
    public savingsAccount getSavingsAccount()
    {
    	return sAccount;
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
//==========================================Checking Account===========
    public int getCheckingsAccountNumber(){
        return cAccount.getAccountNumber();
    }

    public void setCheckingsAccountNumber(int cAccNumber){
        cAccount.setAccountNumber(cAccNumber);
    }

    public double getCheckingsBalance(){
        return cAccount.getBalance();
    }

    public void setCheckingsBalance(double balance){
        cAccount.setBalance(balance);
    }
    public void checkingsDeposit(double amount){
        cAccount.addBalance(amount);
    }

    public void checkingsWithdraw(double amount){
        cAccount.minusBalance(amount);
    }
    
//========================================Savings Account==============
    public int getSavingsAccountNumber(){
        return sAccount.getAccountNumber();
    }

    public void setSavingsAccountNumber(int sAccNumber){
        sAccount.setAccountNumber(sAccNumber);
    }

    public double getSavingsBalance(){
        return sAccount.getBalance();
    }

    public void setSavingsBalance(double balance){
        sAccount.setBalance(balance);
    }
    
    public void savingsDeposit(double amount){
        sAccount.addBalance(amount);
    }

    public void savingsWithdraw(double amount){
        sAccount.minusBalance(amount);
    }

}
