/* 
@author Andre, Shaan, Cesar, Shoraj
checkingAccount class manages all information regarding a customers checking account.
*/
public class checkingAccount { 

    private double balance;
    private int accountNumber;
    
    /**
     * checkingAccount constructor to initialize the variable
     * when it is called
     */
    public checkingAccount(){
        balance = 0.0;
        accountNumber = 0;
    }

    /**
     * add amount to the current balance in account
     * balance = balance + amount
     * 
     * @param amount
     */
    public void addBalance(double amount){
        balance += amount;
    }
    
    /**
     * subtract amount to the current balance
     * balance = balance - amount
     * 
     * @param amount
     */
    public void minusBalance(double amount){
    		if(balance - amount > 0)
    		balance -= amount;
    }

    /**
     * set the initial checking balance
     * @param bal
     */
    public void setBalance(double bal){
        balance = bal;
    }

    /**
     * get the current checking balance
     * @return balance
     */
    public double getBalance(){
        return balance;
    }
    
    /**
     * set the user account number
     */
    public void setAccountNumber(int aNumber){
        accountNumber = aNumber;
    }

    /**
     * get the account number
     * @return balance
     */
    public int getAccountNumber(){
        return accountNumber;
    }
    
}
