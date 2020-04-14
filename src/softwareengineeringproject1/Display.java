/**
 * 
 */

import java.io.IOException;
import java.util.*;

public class Display extends ATM{
// public class Display{
    
    public int screen() {

        System.out.println("PROJECT ATM\n");
        System.out.print("Account number:\n");
        System.out.print("Enter pin:\n");

        while (true) {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object

            mainMenu();

            int choice = myObj.nextInt();

            if (choice < 0 || choice > 4) {
                System.out.println("Exit.");
                break;
            }

            if (choice == 1) {
                checkBalanceDisplay();
            }

            if (choice == 2) {
                withdrawDisplay();
            }

            if (choice == 3) {//This is our keypad, user chose 3, send 3 back to the atm.
                return 3;
            }

            if (choice == 4) {
                transferDisplay();
            }

        }
        return 0;
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

    public void Login() throws IOException{

    }


    public void mainDisplay(){

    }


    public void mainMenu(){
        System.out.println("\n_____________________");
        System.out.println("|     Main Menu        |");
        System.out.println("|[1] View Balance      |");
        System.out.println("|[2] Withdraw Cash     |");
        System.out.println("|[3] Deposit Cash      |");
        System.out.println("|[4] Transfer          |");
        System.out.println("|[5] Exit              |");
        System.out.println("|______________________|");
    }


    public void checkBalanceDisplay() {
        System.out.println("Display balance here");
        //checkings or savings?
    }

    public float depositDisplay() {
        System.out.println("Deposit amount: 50 ");
        float amount=50;//Replace this with user input.
        //checkings or savings?
        return amount;
    }

    public void withdrawDisplay() {
        System.out.println(" _____________________");
        System.out.println("|[1] $20      [5] $100|");
        System.out.println("|[2] $40      [6] $120|");
        System.out.println("|[3] $60      [7] $140|");
        System.out.println("|[4] $80      [8] Exit|");
        System.out.println("|_____________________|");
        //checking or savings?

    }

    public void transferDisplay(BankCustomer me) {
        System.out.println("Which account do you wish to transfer money to:");
        System.out.println("1. Checkings to Savings");
        System.out.println("2. Savings to Checkings");
        
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
