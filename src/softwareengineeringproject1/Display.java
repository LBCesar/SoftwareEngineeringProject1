import java.text.DecimalFormat;
import java.util.*;
/**
 * 
 * @author Andre, Shaan, Cesar, Shoraj
 * The Display class manages all console messages and inputs from the 
 * user for the ATM class
 */
public class Display {
	/**
	 * Scanner myObj: is a Scanner object that handles user input
	 */
    Scanner myObj = new Scanner(System.in);  
    
    /**
     * DecimalFormat df2: is the object that handles all our formatting for our doubles
     */
    DecimalFormat df2 = new DecimalFormat("#.##");
    
    /**
     * 
     * @param low     Lower bound for our input
     * @param high    upper bound for our input
     * @return User input between low and high
     * 
     * The user has to enter an integer value between our high and low
     * parameters and if enters any number outside that scope the user
     * is prompted to enter a value until the condition is met
     */
    public double screen(int low, int high) {//This is sort of now the keypad/ main landing zone.
    	double input = 0;
		boolean valid = false;
		while( !valid ) {
			if( myObj.hasNextDouble()) {
				input = myObj.nextDouble();
				if( input <= high && input >= low ) {
					valid = true;
				} else {
					System.out.println( "Invalid Range." );
				}
			} else {
				myObj.next(); //clear invalid string
				System.out.println( "Invalid Input." );
			}
		}
		return input;
    }
    /**
     * 
     * @return an array with account number and PIN inside
     * 
     * This function simply asks for the users Account Number
     * and PIN Number. Then stores them in an array
     */
    public int[] loginDisplay() {
    	System.out.println("****************************************************************");
        System.out.println("* Please enter your account number and PIN                     *");
        int f[] = new int[2];
        System.out.printf("%-63s*\n","* Account Number:");
        f[0] = (int)this.screen(0, 9999);
        System.out.printf("%-63s*\n","* Enter PIN:");
        f[1]=(int)this.screen(0, 9999);
        System.out.println("*                                                              *");
        System.out.println("****************************************************************\n\n");
        return f;
    }
    /**
     * 
     * @return returns and integer 1 for yes 2 for no
     * 
     * The user is prompted whether to continue their transaction
     * or end it. 
     */
    public int rerun() {
    	System.out.println("****************************************************************");
        System.out.println("*          Would you like to make another transaction?         *");
        System.out.println("* [1] Yes                                                      *");
        System.out.println("* [2] No                                                       *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
        return (int)this.screen(1, 2);
    }
    /**
     * 
     * @return An integer 1 for checking account 2 for savings.
     * 
     * This function prompts the user to choose whether they want to use their 
     * savings or checking account
     */
    public int checkOrSave() {
    	System.out.println("****************************************************************");
    		
    	System.out.println("*                  Welcome to our ATM                          *");		
        System.out.println("*                                                              *"
        		+          "\n* Please choose an account to make your transaction            *");
        System.out.println("*   [1] Checkings Account                                      *");
        System.out.println("*   [2] Savings Account                                        *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
        int f = (int)this.screen(1, 2);

        if(f == 1)
            System.out.println("\nCheckings Account");
        else
            System.out.println("\nSavings Account");

        return f; 
    }
    /**
     * 
     * @return integer that user is prompted to used
     * 
     * This Function displays the main menu of our ATM and asks the user to 
     * choose a banking option.
     */
    public int mainMenu() {
    	System.out.println("****************************************************************");
    	System.out.println("*                      Banking Options                         *");
    	System.out.println("*                                                              *");
        System.out.println("* [1] View Balance                                             *");
        System.out.println("* [2] Withdraw Cash                                            *");
        System.out.println("* [3] Deposit Cash                                             *");
        System.out.println("* [4] Transfer                                                 *");
        System.out.println("* [5] Exit                                                     *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************\n\n");
        return (int)this.screen(1, 5);
    }
    /**
     * 
     * @param accountChoice Integer to figure out which account they are using
     * @param amount Double that is the current amount the user has
     * 
     * This Function displays the balance of the users account that they wish to see. 
     */
    public void checkBalanceDisplay(int accountChoice,double amount) {
    	
        if (accountChoice == 1) {
        	System.out.println("****************************************************************");
        	System.out.println("*                                                              *");
            System.out.printf("%-63s*\n","* Checking Balance: $" + df2.format(amount));
            System.out.println("*                                                              *");
            System.out.println("****************************************************************\n\n");
        }

        if (accountChoice == 2) {
        	System.out.println("****************************************************************");
        	System.out.println("*                                                              *");
            System.out.printf("%-63s*\n","* Savings Balance: $" + df2.format(amount));
            System.out.println("*                                                              *");
            System.out.println("****************************************************************\n\n");
        }
    }
    /**
     * 
     * @return float value of the amount the user wants to deposit to their accounts
     * 
     * This function prompts the user to enter the amount of money they want to add to their account
     * and returns it to the ATM class.
     */
    public double depositDisplay() {
    	System.out.println("****************************************************************");
    	System.out.println("*                     Enter Deposit Amount                     *");
        System.out.println("* Deposit Amount:                                              *");
        double amount = this.screen(1, 9999);
        System.out.println("*                                                              *");
    	
        return amount;
    }
    /**
     * 
     * @return The amount the user wants to withdraw from their account
     * 
     * This function prompts the user to choose between a set amount of money
     * they want to withdraw from their accounts
     */
    public int withdrawDisplay() {

        System.out.println("****************************************************************");
        System.out.println("*                        Withdraw Amount                       *");
        System.out.println("*                                                              *");
        System.out.println("*  |[1] $20      [5] $100|                                     *");
        System.out.println("*  |[2] $40      [6] $120|                                     *");
        System.out.println("*  |[3] $60      [7] $140|                                     *");
        System.out.println("*  |[4] $80      [8] Exit|                                     *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
        int choice = (int)this.screen(1, 8);
        return choice;
    }
    /**
     * 
     * @param choice An integer representing the account type
     * @param me   The BankCustomer that is currently using the ATM
     * @return The amount of money the user wants to transfer between accounts
     * 
     * This function prompts the user to enter the amount the customer wants to transfer 
     * between accounts.  
     */
    public double transferDisplay(int choice, BankCustomer me) 
    {
		
		double amount = 0;
		double balance = 0;
		System.out.println("*                                                              *");
	
		if(choice == 1){
			balance = me.getCheckingsBalance();
			System.out.println("* Transferring from Checkings to Savings                       *");
		}
	
		else{
			balance = me.getSavingsBalance();
			System.out.println("* Transferring from Savings to Checkings                       *");
		}
	
		System.out.println("* Enter the amount you wish to tranfer:                        *");
		amount = this.screen(1, Integer.MAX_VALUE);
		while(!(balance - amount >= 0))
		{
			this.fundsError();
			amount = this.screen(1,Integer.MAX_VALUE);
		}
		System.out.println("*                                                              *");
		return amount;
    }
    /**
     * 
     * @param saveBal double that represents the savings balance
     * @param checkBal double that represents the checkings balance
     * 
     * This function simply displays both account balances
     */
    public void dipalyBalances(double saveBal, double checkBal)//delete?
    {
    	
    	System.out.println("****************************************************************");
    	System.out.println("*                                                              *");
    	System.out.printf("%-63s*\n","* Checking Balance: $" + df2.format(checkBal));
        System.out.printf("%-63s*\n","* Savings Balance: $" + df2.format(saveBal));
        System.out.println("*                                                              *");
        System.out.println("****************************************************************\n\n");
    }
    public void displayNewBalance(int accountChoice,double prevAmount,double currAmount){
        if(accountChoice==1){
            System.out.printf("%-63s*\n","* Old Checkings Balance: $" + df2.format(prevAmount));
            System.out.printf("%-63s*\n","* New Checkings Balance: $" + df2.format(currAmount));
            System.out.println("*                                                              *");
            System.out.println("****************************************************************\n\n");
        }
        if(accountChoice==2){
            System.out.printf("%-63s*\n","* Old Savings Balance: $" + df2.format(prevAmount));
            System.out.printf("%-63s*\n","* New Savings Balance: $" + df2.format(currAmount));
            System.out.println("*                                                              *");    
            System.out.println("****************************************************************\n\n");
        }
    }
    
    
    /**
     * This function diplays a login error
     */
    public void loginError(){
    	System.out.println("\n\n****************************************************************");
        System.out.printf("%-63s*\n","*                   Incorrect Account number or PIN!");
        System.out.println("****************************************************************\n\n");
    }
    /**
     * This function displays an error if the user has insufficient funds in their account
     */
    public void fundsError(){

    	System.out.println("\n\n****************************************************************");
        System.out.printf("%-63s*\n","*                   Insufficient Funds!");
        System.out.println("****************************************************************\n\n");
    }
    /**
     * 
     * @param cBal double representing checkings balance
     * @param sBal double representing savings balance
     * 
     * This is the exit screen that displays the final balances in both accounts of the bank customer.
     */
    public void exit(double cBal, double sBal){
        System.out.println("****************************************************************");
    	System.out.println("*                 Have A Nice Day                              *");
    	System.out.println("*                                                              *");
    	System.out.printf("%-63s*\n","* Checking Balance: $" + df2.format(cBal));
        System.out.printf("%-63s*\n","* Savings Balance: $" + df2.format(sBal));
        System.out.println("*                                                              *");
        System.out.println("****************************************************************\n\n");
    }
}
