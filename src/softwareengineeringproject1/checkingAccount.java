
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
        balance += amount;
    }


    public void minusBalance(double amount){
    	if(balance - amount > 0)
    		balance -= amount;
    	else 
    		System.out.println("Sorry, you dont have enough funds");
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
