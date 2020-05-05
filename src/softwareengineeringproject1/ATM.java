/**
 * 
 * CECS 343
 * Project_ATM
 * 05/04/2020
 * 
 * @author Andre Cortes, Shaan Shariff, Cesar Gonzalez & Shoraj Manandhar
 * 
 */

import java.text.DecimalFormat;

/**
 * ATM class allows the user to access their account and make necessary transaction.
 * It verifies the user Login and grants access to the user account upon success
 * Takes care of main transaction functionality: Deposit, Withdraw, checkBalance and Transfer
 */
public class ATM {

    Display screen = new Display();                
    BankCustomer me = new BankCustomer();           
    DecimalFormat df2 = new DecimalFormat("#.##"); // Money has 2 decimal place

    /**
     * Constructor with BankCustomer parameter
     * Creates a new BankCustomer object 
     * that represents 'me' as a customer using the ATM
     * 
     * @param me
     */
    private ATM(BankCustomer me) {
        this.me = me;
        start();
    }

    
    /**
     * A method that makes the user choose the type of transaction
     * Passes in an appropriate arguments to show if the transaction
     * is made in Checking or Savings accounts.
     */
    public final void start() {

        //  Terminates the program when invalid Log in
    	if (!this.verifyLogin()) {
            screen.exit(me.getCheckingsBalance(), me.getSavingsBalance());
            System.exit(0);
        }

        while (true) {
            //  checkings or savings?
            int accountChoice = screen.checkOrSave();   

            //  Print the main menu
            int choice = screen.mainMenu();

            switch (choice) {
                case 1:                         //  Balance
                    balance(accountChoice);
                    break;
                case 2:                         //  Withdraw
                    withdraw(accountChoice);
                    break;
                case 3:                         //  Deposit
                    deposit(accountChoice);
                    break;
                case 4:                         //  Transfer
                    transfer(accountChoice);
                    break;
                default:                        //  Exit
                    screen.exit(me.getCheckingsBalance(),me.getSavingsBalance());
                    System.exit(0);
            }

            //  Do we want to run again ?
            if (screen.rerun() != 1) {
                screen.exit(me.getCheckingsBalance(),me.getSavingsBalance());
                System.exit(0);
            }
        }
    }

    /**
     * Function will compare our entered credentials with the
     * credentials that we have saved
     * User will have 3 attempts to enter the correct account number and PIN number
     * 
     * @return boolean clear
     */
    private boolean verifyLogin() {
        
        boolean clear = false;
        int tries = 0;                          //  3 attempts
        int f[] = new int[2];                   //  array holds user input.
        
        while (tries < 3) {
            f=screen.loginDisplay();            //  Prompt to enter account number and PIN
            if (f[0] == me.getCardNumber()) {   //  Compare entered and saved credentials
                if (f[1] == me.getPIN()) {
                    clear = true;
                    break;
                }
            }
            screen.loginError();
            tries++;
        }
        return clear;
    }


    /**
     * Check the balance on the user account
     * if accountChoice is Checking account, then display the current checking balance
     * if accountChoice is Savings account, then display the current savings balance
     * 
     * @param accountChoice
     */
    public void balance(int accountChoice) {
        double balance;
        if (accountChoice == 1) {
            balance=me.getCheckingsBalance();
            screen.checkBalanceDisplay(accountChoice,balance);
        }

        if (accountChoice == 2) {
            balance=me.getSavingsBalance();
            screen.checkBalanceDisplay(accountChoice,balance);

        }
    }

    /**
     * Deposit allows the user to put money into their account.
     * 
     * @param accountChoice
     */
    public void deposit(int accountChoice) {

        double amount = screen.depositDisplay(); //  depositDisplay(): returns the user input for deposit amount
        double prevAmount;

        if (accountChoice == 1) {
            prevAmount = me.getCheckingsBalance();
            me.checkingsDeposit(amount);
            screen.displayNewBalance(accountChoice,prevAmount, me.getCheckingsBalance());
        }

        if (accountChoice == 2) {
            prevAmount = me.getSavingsBalance();
            me.savingsDeposit(amount);
            screen.displayNewBalance(accountChoice,prevAmount, me.getCheckingsBalance());         
        }     
    }

    /**
     * Withdraw allows the user to withdraw selected amount from their account.
     * The method also checks to see if the user has sufficient funds in 
     * their account to make the transaction.
     * 
     * @param accountChoice
     *        accountChoice is checkings or savings. 
     */
    public void withdraw(int accountChoice) {

        boolean suf = false;
        
    	while(!suf) {
	        int amount = 0;
	        int choiceWithdraw = screen.withdrawDisplay();	//  prompts for an input for withdraw amount
                switch (choiceWithdraw) {
                    case 1:
                        amount = 20;                        //  choice 1 will withdraw $20
                        break;
                    case 2:
                        amount = 40;                        //  choice 2 will withdraw $40
                        break;
                    case 3:
                        amount = 60;                        //  choice 3 will withdraw $60
                        break;
                    case 4:
                        amount = 80;                        //  choice 4 will withdraw $80
                        break;
                    case 5:
                        amount = 100;                       //  choice 5 will withdraw $100
                        break;
                    case 6:
                        amount = 120;                       //  choice 6 will withdraw $120
                        break;
                    case 7:
                        amount = 140;                       //  choice 7 will withdraw $140
                        break;
                    default:
                        amount = 0;                         //  any other choice will withdraw $0 and ask to go back to menu
                        break;
                }

                double prevAmount;

	        if (accountChoice == 1) {
	            if (me.getCheckingsBalance() - amount >= 0) {	//  checks for sufficient funds
                        prevAmount = me.getCheckingsBalance();
	                me.checkingsWithdraw(amount);
                        screen.displayNewBalance(accountChoice,prevAmount, me.getCheckingsBalance());
	                suf = true;
	            } else {
	                screen.fundsError();
	            }
            }
            
	        if (accountChoice == 2) {
	            if (me.getSavingsBalance() - amount >= 0) {		//  checks for sufficient funds
                        prevAmount = me.getSavingsBalance();
	                me.savingsWithdraw(amount);
                        screen.displayNewBalance(accountChoice,prevAmount, me.getCheckingsBalance());
	                suf = true;
	            } else {
	                screen.fundsError();
	            }
            }
            
        }
        
    }       // end withdraw

    /**
     * Transfer allows the user to transfer money in between their checking and savings account
     * Also, checks to see if the user has sufficient funds to make transfer
     * 
     * @param accountChoice
     */
    public void transfer(int accountChoice){   
    	
        double amount;

        System.out.println("****************************************************************");
        System.out.println("*                                                              *"); 
        System.out.printf("%-63s*\n","* Checking Balance: $" + df2.format(me.getCheckingsBalance()));
        System.out.printf("%-63s*\n","* Savings Balance: $" + df2.format(me.getSavingsBalance()));

        if(accountChoice == 1) {
            amount = screen.transferDisplay(accountChoice,me);
            if(me.getCheckingsBalance() - amount >= 0){
                me.getCheckingAccount().minusBalance(amount);
                me.getSavingsAccount().addBalance(amount);
            }
            else{
                screen.fundsError();
            }
        }

        else if(accountChoice == 2){
            amount = screen.transferDisplay(accountChoice,me);
            if(me.getSavingsBalance() - amount >= 0){

                me.getCheckingAccount().addBalance(amount);
                me.getSavingsAccount().minusBalance(amount);
            }
            else{
                screen.fundsError();
            }
        }
        
        System.out.printf("%-63s*\n","* Transfer Successful!");
        System.out.printf("%-63s*\n","* New Checking Balance: $" + df2.format(me.getCheckingsBalance()));
        System.out.printf("%-63s*\n","* New Savings Balance: $" + df2.format(me.getSavingsBalance()));
        System.out.println("****************************************************************\n\n");
    }



    public static void main(String[] args) {

        // me: BankCustomer object. A customer using the ATM.
        BankCustomer me = new BankCustomer();

        // Initial Info of 'me' that we store
        me.setName("lil Kanye");
        me.setEmail("dontgiveahoot@hoot.hoo");
        me.setAddress("1919 KayneWest@jtriseltunoob");
        me.setCardNumber(1234);
        me.setPIN(1111);
        me.setCheckingsAccountNumber(4545);
        me.setCheckingsBalance(150);
        me.setSavingsAccountNumber(4546);
        me.setSavingsBalance(100);

        ATM a = new ATM(me);

    }   //  end main

}   //  end ATM class

