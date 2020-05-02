/* 
@author Andre, Shaan, Cesar, Shoraj
savingsAccount class manages all information regarding a customers savings account.
*/
public class savingsAccount {
    
    private double balance;
    private int accountNumber;
    
    public savingsAccount(){
        balance = 0;
        accountNumber = 0;
    }

    public void addBalance(double amount) {
        balance += amount;
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
    
    public void setAccountNumber(int accNumber){
        accountNumber = accNumber;
    }

    public int getAccountNumber(){
        return accountNumber;
    }       
}
