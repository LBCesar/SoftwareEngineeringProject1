
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ATM {

    Display screen = new Display();
    BankCustomer me = new BankCustomer();

    private ATM(BankCustomer me) {
        this.me = me;
        start();
    }

    public BankCustomer bc() {          //just for testing, delete later.
        return me;
    }

    private boolean login() {
        boolean clear = false;
        int tries = 0;
        int f[] = new int[2];
        while (tries < 3) {
            f = screen.Login();
            if (f[0] == me.getCardNumber()) {
                if (f[1] == me.getPIN()) {
                    clear = true;
                    break;
                }
            }
            System.out.println("Incorrect Account number or PIN!");
            tries++;
        }
        return clear;
    }

    public final void start() {
        //Login
        if (!this.login()) {
            System.exit(0);
        }
        //Loop
        while (true) {
            //Do we want checkings or savings?
            int accountChoice = screen.checkOrSave();
            //Print the main menu
            int choice = screen.mainMenu();
            switch (choice) {
                case 1://Balance
                    balance(accountChoice);
                    break;
                case 2://Withdraw
                    withdraw(accountChoice);
                    break;
                case 3://Deposit
                    deposit(accountChoice);
                    break;
                case 4://Transfer
                    transfer(accountChoice);
                    break;
                default://Exit
                    System.out.println("Exit program");
                    System.exit(0);
            }
            //Do we want to run again ?
            if (screen.rerun() != 1) {
                System.out.println("Exit program");
                System.exit(0);
            }
        }
    }

    public void withdraw(int accountChoice) {
    	boolean suf = false;
    	while(!suf) {
	        int amount = 0;
	        int choiceWithdraw = screen.withdrawDisplay();	//prompts for an input for withdraw amount
	        if (choiceWithdraw == 1) {					//choice 1 will withdraw $20
	            amount = 20;
	        } else if (choiceWithdraw == 2) {				//choice 2 will withdraw $40
	            amount = 40;
	        } else if (choiceWithdraw == 3) {				//choice 3 will withdraw $60
	            amount = 60;
	        } else if (choiceWithdraw == 4) {				//choice 4 will withdraw $80
	            amount = 80;
	        } else if (choiceWithdraw == 5) {				//choice 5 will withdraw $100
	            amount = 100;
	        } else if (choiceWithdraw == 6) {				//choice 6 will withdraw $120
	            amount = 120;
	        } else if (choiceWithdraw == 7) {				//choice 7 will withdraw $140
	            amount = 140;
	        } else {										//any other choice will withdraw $0 and ask to go back to menu
	        	amount = 0;
	        }
	
	        if (accountChoice == 1) {
	            if (me.getCheckingsBalance() - amount >= 0) {	//checks for sufficient funds
	                me.checkingsWithdraw(amount);
	                suf = true;
	            } else {
	                System.out.println("Insufficient Funds!");
	            }
	        }
	        if (accountChoice == 2) {
	            if (me.getSavingsBalance() - amount >= 0) {		//checks for sufficient funds
	                me.savingsWithdraw(amount);
	                suf = true;
	            } else {
	                System.out.println("Insufficient Funds!");
	            }
	        }
    	}
    }

    public void transfer(int accountChoice){        // andre look at this. idk if this makes proper sense.

        double amount;

        if(accountChoice == 1) 
        {
            // amount = getIntRange(0, Integer.MAX_VALUE);
            amount = screen.transferDisplay(accountChoice);
            if(me.getCheckingsBalance() - amount >= 0)
            {
                me.getCheckingAccount().minusBalance(amount);
                me.getSavingsAccount().addBalance(amount);
                // me.checkingsWithdraw(amount);
                // me.savingsDeposit(amount);
            }
            else
            {
                System.out.println("Sorry, you dont have sufficent funds for this tranfer.");
            }
        }

        else if(accountChoice == 2)
        {
            // System.out.println("Enter the amount you wish to tranfer: ");
            // amount = getIntRange(0, Integer.MAX_VALUE);
            amount = screen.transferDisplay(accountChoice);
            if(me.getSavingsBalance() - amount >= 0)
            {

                me.getCheckingAccount().addBalance(amount);
                me.getSavingsAccount().minusBalance(amount);
                // me.checkingsDeposit(amount);
                // me.savingsWithdraw(amount);
            }
            else
            {
                System.out.println("Sorry, you dont have sufficent funds for this tranfer.");
            }

        }
        else 
            System.out.println("Sorry, that is not an option");

    }

    public void balance(int accountChoice) {
        screen.checkBalanceDisplay();
        if (accountChoice == 1) {
            System.out.println("Checkings Balance: $" + me.getCheckingsBalance());
        }

        if (accountChoice == 2) {
            System.out.println("Savings Balance: $" + me.getSavingsBalance());
        }
    }

    public void deposit(int accountChoice) {
        float amount = screen.depositDisplay(); //Our depositDisplay() returns the user input for deposit amount
        if (accountChoice == 1) {
            me.checkingsDeposit(amount);
        }

        if (accountChoice == 2) {
            me.savingsDeposit(amount);
        }
    }

    public static void main(String[] args) {

        BankCustomer me = new BankCustomer();

        me.setName("lil Kanye");
        me.setEmail("dontgiveahoot@hoot.hoo");
        me.setAddress("1919 KayneWest@jtriseltunoob");
        me.setCardNumber(1234);
        me.setPIN(1111);
        me.setCheckingsAccountNumber(4545);
        me.setCheckingsBalance(150);
        me.setSavingsAccountNumber(4546);
        me.setSavingsBalance(100);

        //================Delete Later.
        System.out.println("NEW\n\n\nInitial Checkings Balance: $" + me.getCheckingsBalance());
        System.out.println("Initial Savings Balance: $" + me.getSavingsBalance());

        ATM a = new ATM(me);
        BankCustomer bc = a.bc();

        System.out.println("After Checkings Balance: $" + bc.getCheckingsBalance());
        System.out.println("After Savings Balance: $" + bc.getSavingsBalance());

    }

}
