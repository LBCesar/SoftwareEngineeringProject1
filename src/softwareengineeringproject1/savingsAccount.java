/* 
@author Andre, Shaan, Cesar, Shoraj
savingsAccount class manages all information regarding a customers savings account.
*/
public class savingsAccount {
    
    private double balance;
    private int accountNumber;
    
    /**
     * checkingAccount constructor to initialize the variable
     */
    public savingsAccount(){
        balance = 0;
        accountNumber = 0;
    }

    /**
     * add amount to the current balance in account
     * balance = balance + amount
     * 
     * @param amount
     */
    public void addBalance(double amount) {
        balance += amount;
    }

    /**
     * subtract amount to the current balance
     * balance = balance - amount
     * 
     * @param amount
     */
    public void minusBalance(double amount){
        balance -= amount;
    }

    /**
     * set the savings balance
     * @param bal
     */
    public void setBalance(double bal){
        balance = bal;
    }

    /**
     * get the current savings balance
     * @return balance
     */
    public double getBalance(){
        return balance;
    }
    
    /**
     * set the savings Account Number
     * @param accNumber
     */
    public void setAccountNumber(int accNumber){
        accountNumber = accNumber;
    }

    /**
     * get savings account number
     * @return
     */
    public int getAccountNumber(){
        return accountNumber;
    }       
    
}
