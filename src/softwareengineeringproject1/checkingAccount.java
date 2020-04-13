/**
 * 
 * 
 */

public class checkingAccount {
    
    private double balance;
    private int accountNumber;
    

    public checkingAccount(){
        balance = 0.0;
        accountNumber = 0;
    }


    public void addBalance(double amount){
               System.out.println("Checkings\nBefore:" + balance);
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
    

    public void setAccountNumber(int aNumber){
        accountNumber = aNumber;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

}


/**
 * Self Note
 * # add some security features
 * # Minimum balance requirments
 * # Fees
 * # overdraft amout
 */