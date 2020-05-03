/**
 * 
 * CECS 343
 * Project_ATM
 * 05/04/2020
 * 
 * @author Andre Cortes, Shaan Shariff, Cesar Gonzalez & Shoraj Manandhar
 * 
 */

import java.util.*;

/**
 * A user can set and retrive their information
 * 
 * Each instance will have the customer’s information including: 
 * Name, Email, Address, Account Number & PIN number.
 * 
 * it also has an instance of CheckingAccount and SavingsAccount
 * which makes it able to modify and get the balance of the customer.
 */
public class BankCustomer {

    private String name;
    private String email;
    private String address;
    private int cardNumber;
    private int pin;

    //  Customers are only allowed to have one checking and one savings account.
    private checkingAccount cAccount = new checkingAccount();
    private savingsAccount sAccount = new savingsAccount();

    /**
     * Constructor with all parameters
     */
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


//===================================== Personal Information =====================================
    /**
     * A get method to return the name of the user
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * A set method to set the name of the user
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * A get method to return the Email of the user
     * @return email
     */
    public String getEmail(){
        return email;
    }

    /**
     * A set method to set the email of the user
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * A get method to get the address
     * @return address
     */
    public String getAddress(){
        return address;
    }

    /**
     * a set method to set the address
     * @param address
     */
    public void setAddress(String address){
        this.address = address;
    }

//================================ Banking Information =====================================
    
    /**
     * A get method that returns the Checking Account
     * @return cAccount
     */
    public checkingAccount getCheckingAccount(){
    	return cAccount;
    }

    /**
     * A get method that returns the Savings Account
     * @return sAccount
     */
    public savingsAccount getSavingsAccount(){
    	return sAccount;
    }

    /**
     * A get method that returns the user Account (Card) Number
     * @return cardNumber
     */
    public int getCardNumber(){
        return cardNumber;
    }

    /**
     * A set method that sets the Account Number
     * @param cardNumber
     */
    public void setCardNumber(int cardNumber){
        this.cardNumber = cardNumber;
    }

    /**
     * A get method that returns the PIN number
     * @return pin
     */
    public int getPIN(){
        return pin;
    }

    /**
     * A set method that sets the PIN number
     * @param pin
     */
    public void setPIN(int pin){
        this.pin = pin;
    }

//========================================== Checking Account =====================================
    
    /**
     * get the user checkings account number
     * @return getAccountNumber
     */
    public int getCheckingsAccountNumber(){
        return cAccount.getAccountNumber();
    }

    /**
     * set the user checking account number
     * @param cAccount.setAccountNumber
     */
    public void setCheckingsAccountNumber(int cAccNumber){
        cAccount.setAccountNumber(cAccNumber);
    }

    /**
     * get the user current checking balance 
     * @return cAccount.getBalance
     */
    public double getCheckingsBalance(){
        return cAccount.getBalance();
    }

    /**
     * set the user checking balance
     * @param balance
     */
    public void setCheckingsBalance(double balance){
        cAccount.setBalance(balance);
    }

    /**
     * Deposit balance increase the checking balance + amount
     * @param amount
     */
    public void checkingsDeposit(double amount){
        cAccount.addBalance(amount);
    }

    /**
     * Withdraw balance decrease the checking balance - amount
     * @param amount
     */
    public void checkingsWithdraw(double amount){
        cAccount.minusBalance(amount);
    }
    
//======================================== Savings Account =====================================
    
    /**
     * get the user savings account number
     * @return getAccountNumber
     */
    public int getSavingsAccountNumber(){
        return sAccount.getAccountNumber();
    }

    /**
     * set the user savings account number
     * @param sAccount.setAccountNumber
     */
    public void setSavingsAccountNumber(int sAccNumber){
        sAccount.setAccountNumber(sAccNumber);
    }

    /**
     * get the user current saving balance 
     * @return getBalance
     */
    public double getSavingsBalance(){
        return sAccount.getBalance();
    }

    /**
     * set the user savings balance
     * @param balance
     */
    public void setSavingsBalance(double balance){
        sAccount.setBalance(balance);
    }
    
    /**
     * Deposit balance increase the savings balance + amount
     * @param amount
     */
    public void savingsDeposit(double amount){
        sAccount.addBalance(amount);
    }

    /**
     * Withdraw balance decrease the savings balance - amount
     * @param amount
     */
    public void savingsWithdraw(double amount){
        sAccount.minusBalance(amount);
    }


}