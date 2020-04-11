/**
 * 
 * 
 */

public class savingsAccount {
    
    private double balance;
    private int accountNumber;
    

    public savingsAccount(){
        balance = 0;
        accountNumber = 0;
    }


    public void addBalance(double amount){
        balance += amount;
    }


    public void minusBalance(double amount){
        balance -= amount;
    }


    public double getBalance(){
        return balance;
    }
    

    // public void setAccountNumber(int number){
    //     accountNumber = number;
    // }


    public int getAccountNumber(){
        return accountNumber;
    }


    public void hasMoney(){
        
    }
       
}

/**
 * Self Note :
 * # add some security features
 * # Minimum balance requirments
 * # Fees
 * # overdraft amout
 */