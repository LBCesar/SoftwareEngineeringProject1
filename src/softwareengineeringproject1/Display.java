import java.text.DecimalFormat;
import java.util.*;

public class Display {

    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    DecimalFormat df2 = new DecimalFormat("#.##");

    public int screen(int low, int high) {//This is sort of now the keypad/ main landing zone.
    	int input = 0;
		boolean valid = false;
		while( !valid ) {
			if( myObj.hasNextInt() ) {
				input = myObj.nextInt();
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
    public int[] loginDisplay() {
    	System.out.println("****************************************************************");
        System.out.println("* Please enter your account number and PIN                     *");
        int f[] = new int[2];
        System.out.printf("%-63s*\n","* Account Number(1234):");
        f[0] = this.screen(0, 9999);
        System.out.printf("%-63s*\n","* Enter PIN(1111):");
        f[1]=this.screen(0, 9999);
        System.out.println("*                                                              *");
        System.out.println("****************************************************************\n\n");
        return f;
    }

    public int rerun() {
    	System.out.println("****************************************************************");
        System.out.println("*          Would you like to make another transaction?         *");
        System.out.println("* [1] Yes                                                      *");
        System.out.println("* [2] No                                                       *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
        return this.screen(1, 2);
    }

    public int checkOrSave() {
    	System.out.println("****************************************************************");
    		
    	System.out.println("*                  Welcome to our ATM                          *");		
        System.out.println("*                                                              *"
        		+          "\n* Please choose an account to make your transaction            *");
        System.out.println("*   [1] Checkings Account                                      *");
        System.out.println("*   [2] Savings Account                                        *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
        int f = this.screen(1, 2);

        if(f == 1)
            System.out.println("\nCheckings Account");
        else
            System.out.println("\nSavings Account");

        return f; 
    }

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
        return this.screen(1, 5);
    }

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

    public float depositDisplay() {
    	System.out.println("****************************************************************");
    	System.out.println("*                     Enter Deposit Amount                     *");
        System.out.println("* Deposit Amount:                                              *");
        float amount = this.screen(1, 9999);
        System.out.println("*                                                              *");
    	
        return amount;
    }

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
        int choice = this.screen(1, 8);
        return choice;
    }

    public double transferDisplay(int choice, BankCustomer me) 
    {
		
		int amount = 0;
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
			System.out.printf("%-63s*\n","* You do not have sufficient funds, enter a different amount: ");
			amount = this.screen(1,Integer.MAX_VALUE);
		}
		System.out.println("*                                                              *");
		return amount;
    }
    public void dipalyBalances(double saveBal, double checkBal)
    {
    	
    	System.out.println("****************************************************************");
    	System.out.println("*                                                              *");
    	System.out.printf("%-63s*\n","* Checking Balance: $" + df2.format(checkBal));
        System.out.printf("%-63s*\n","* Savings Balance: $" + df2.format(saveBal));
        System.out.println("*                                                              *");
        System.out.println("****************************************************************\n\n");
    }
    public void loginError(){
    	System.out.println("\n\n****************************************************************");
        System.out.printf("%-63s*\n","*                   Incorrect Account number or PIN!");
        System.out.println("****************************************************************\n\n");
    }
    public void fundsError(){

    	System.out.println("\n\n****************************************************************");
        System.out.printf("%-63s*\n","*                   Insufficient Funds!");
        System.out.println("****************************************************************\n\n");
    }
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
