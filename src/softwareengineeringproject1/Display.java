/**
 * 
 */

import java.io.IOException;
import java.util.*;

public class Display extends ATM{
    
    public int screen() {//This is sort of now the keypad/ main landing zone.
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int choice = myObj.nextInt();
        return choice;
    }

    //takes in a value between low and high from the user 
	//to make sure nothing breaks
	public int getIntRange( int low, int high ) {
		Scanner in = new Scanner( System.in );
		int input = 0;
		boolean valid = false;
		while( !valid ) {
			if( in.hasNextInt() ) {
				input = in.nextInt();
				if( input <= high && input >= low ) {
					valid = true;
				} else {
					System.out.println( "Invalid Range." );
				}
			} else {
				in.next(); //clear invalid string
				System.out.println( "Invalid Input." );
			}
		}
		return input;
	}

    public int[] Login(){
        System.out.println("Please enter your account number and PIN");
        int f[]=new int[2];
        System.out.print("Account Number(1234): ");
        f[0]=this.screen();
        System.out.print("Enter PIN(1111): ");
        f[1]=this.screen();
        return f;
    }

    public int checkOrSave(){
        System.out.println("\nPlease choose an account to make your transaction");
        System.out.println("[1] Checkings Account");
        System.out.println("[2] Savings Account");
        int f = this.screen();
        return f;
    }


    public void mainMenu(){
        System.out.println("[1] View Balance      ");
        System.out.println("[2] Withdraw Cash     ");
        System.out.println("[3] Deposit Cash      ");
        System.out.println("[4] Transfer          ");
        System.out.println("[5] Exit              ");
    }


    public void checkBalanceDisplay() {
        System.out.println("Display Current Balance");          // Could be possible to print current system time format
    }

    public float depositDisplay() {
        System.out.println("Deposit amount:");
        float amount = this.screen();
        return amount;
    }

    public void withdrawDisplay() {
        System.out.println("|[1] $20      [5] $100|");
        System.out.println("|[2] $40      [6] $120|");
        System.out.println("|[3] $60      [7] $140|");
        System.out.println("|[4] $80      [8] Exit|");
    }

    public void transferDisplay(BankCustomer me) {
        System.out.println("Which account do you wish to transfer money to:");
        System.out.println("[1] Checkings to Savings");
        System.out.println("[2] Savings to Checkings");
        
        int choice = getIntRange(1,2);
        int amount = 0;
        double oldbalance = 0.0;
        if(choice == 1) 
        {
        	System.out.println("Enter the amount you wish to tranfer: ");
        	amount = getIntRange(0, Integer.MAX_VALUE);
        	oldbalance = me.getCheckingsBalance();
        	if(me.getCheckingsBalance() - amount >= 0)
        	{
        		me.getCheckingAccount().minusBalance(amount);
        		me.getSavingsAccount().addBalance(amount);
        		System.out.println("Old Balance: " + oldbalance);
        		System.out.println("New Balance:" + me.getSavingsBalance());
        	}
        	else
        	{
        		System.out.println("Sorry, you dont have sufficent funds for this tranfer.");
        	}
        }
        
        else if(choice == 2)
        {
        	System.out.println("Enter the amount you wish to tranfer: ");
        	amount = getIntRange(0, Integer.MAX_VALUE);
        	oldbalance = me.getCheckingsBalance();
        	if(me.getCheckingsBalance() - amount >= 0)
        	{
        		
        		me.getCheckingAccount().addBalance(amount);
        		me.getSavingsAccount().minusBalance(amount);
        		System.out.println("Old Balance: " + oldbalance);
        		System.out.println("New Balance:" + me.getCheckingsBalance());
        	}
        	else
        	{
        		System.out.println("Sorry, you dont have sufficent funds for this tranfer.");
        	}
        	
        }
        else 
        	System.out.println("Sorry, that is not an option");
        	
    }

}
