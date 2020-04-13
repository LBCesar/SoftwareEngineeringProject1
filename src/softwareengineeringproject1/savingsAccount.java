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


    public void addBalance(double amount) {
        System.out.println("Savings\nBefore:" + balance);
        balance += amount;
        System.out.println("After:" + balance);

    }


    public void minusBalance(double amount){
        balance -= amount;
    }


    public void setBalance(double bal){
        balance = bal;
    }

    public double getBalance(){
        return balance;
    }
    

    public void setAccountNumber(int assNumber){
        accountNumber = assNumber;
    }

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