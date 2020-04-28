import java.text.DecimalFormat;

public class ATM {

    Display screen = new Display();
    BankCustomer me = new BankCustomer();
    DecimalFormat df2 = new DecimalFormat("#.##");
    private ATM(BankCustomer me) {
        this.me = me;
        start();
    }
 

    public final void start() {
    	if (!this.verifyLogin()) {
            screen.exit(me.getCheckingsBalance(),me.getSavingsBalance());
            System.exit(0);
        }

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
                    screen.exit(me.getCheckingsBalance(),me.getSavingsBalance());
                    System.exit(0);
            }
            //Do we want to run again ?
            if (screen.rerun() != 1) {
                screen.exit(me.getCheckingsBalance(),me.getSavingsBalance());
                System.exit(0);
            }
        }
    }
    private boolean verifyLogin() {
        boolean clear = false;
        int tries = 0;
        int f[] = new int[2];
        while (tries < 3) {
            f=screen.loginDisplay();
            if (f[0] == me.getCardNumber()) {
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
    
    public void withdraw(int accountChoice) {
    	boolean suf = false;
    	while(!suf) {
	        int amount = 0;
	        int choiceWithdraw = screen.withdrawDisplay();	//prompts for an input for withdraw amount
                switch (choiceWithdraw) {
                    case 1:
                        //choice 1 will withdraw $20
                        amount = 20;
                        break;
                    case 2:
                        //choice 2 will withdraw $40
                        amount = 40;
                        break;
                    case 3:
                        //choice 3 will withdraw $60
                        amount = 60;
                        break;
                    case 4:
                        //choice 4 will withdraw $80
                        amount = 80;
                        break;
                    case 5:
                        //choice 5 will withdraw $100
                        amount = 100;
                        break;
                    case 6:
                        //choice 6 will withdraw $120
                        amount = 120;
                        break;
                    case 7:
                        //choice 7 will withdraw $140
                        amount = 140;
                        break;
                    default:
                        //any other choice will withdraw $0 and ask to go back to menu
                        amount = 0;
                        break;
                }
	
	        if (accountChoice == 1) {
	            if (me.getCheckingsBalance() - amount >= 0) {	//checks for sufficient funds
	                me.checkingsWithdraw(amount);
	                suf = true;
	            } else {
	                screen.fundsError();
	            }
	        }
	        if (accountChoice == 2) {
	            if (me.getSavingsBalance() - amount >= 0) {		//checks for sufficient funds
	                me.savingsWithdraw(amount);
	                suf = true;
	            } else {
	                screen.fundsError();
	            }
	        }
	        screen.dipalyBalances(me.getSavingsBalance(),me.getCheckingsBalance());
    	}
    }

    public void transfer(int accountChoice){        // andre look at this. idk if this makes proper sense.
    	
        double amount;
        System.out.println("****************************************************************");
        System.out.println("*                                                              *"); 
        System.out.printf("%-63s*\n","* Checking Balance: $" + df2.format(me.getCheckingsBalance()));
        System.out.printf("%-63s*\n","* Savings Balance: $" + df2.format(me.getSavingsBalance()));
        if(accountChoice == 1) 
        {
            amount = screen.transferDisplay(accountChoice,me);
            if(me.getCheckingsBalance() - amount >= 0)
            {
                me.getCheckingAccount().minusBalance(amount);
                me.getSavingsAccount().addBalance(amount);
            }
            else
            {
                screen.fundsError();
            }
        }

        else if(accountChoice == 2)
        {
            amount = screen.transferDisplay(accountChoice,me);
            if(me.getSavingsBalance() - amount >= 0)
            {

                me.getCheckingAccount().addBalance(amount);
                me.getSavingsAccount().minusBalance(amount);
            }
            else
            {
                screen.fundsError();
            }
        }
        
        System.out.printf("%-63s*\n","* Transfer Successful!");
        System.out.printf("%-63s*\n","* New Checking Balance: $" + df2.format(me.getCheckingsBalance()));
        System.out.printf("%-63s*\n","* New Savings Balance: $" + df2.format(me.getSavingsBalance()));
        System.out.println("****************************************************************\n\n");
    }

    public void balance(int accountChoice) {
        if (accountChoice == 1) {
            screen.checkBalanceDisplay(accountChoice,me.getCheckingsBalance());
        }

        if (accountChoice == 2) {
            screen.checkBalanceDisplay(accountChoice,me.getSavingsBalance());

        }
    }

    public void deposit(int accountChoice) {
        float amount = screen.depositDisplay(); //Our depositDisplay() returns the user input for deposit amount
        double prevAmount;
        if (accountChoice == 1) {
        	prevAmount = me.getCheckingsBalance();
            me.checkingsDeposit(amount);
            System.out.printf("%-63s*\n","* Old Checkings Balance: $" + df2.format(prevAmount));
            System.out.printf("%-63s*\n","* New Checkings Balance: $" + df2.format(me.getCheckingsBalance()));
            System.out.println("*                                                              *");
        }

        if (accountChoice == 2) {
        	prevAmount = me.getSavingsBalance();
            me.savingsDeposit(amount);
            System.out.printf("%-63s*\n","* Old Savings Balance: $" + df2.format(prevAmount));
            System.out.printf("%-63s*\n","* New Savings Balance: $" + df2.format(me.getSavingsBalance()));
            System.out.println("*                                                              *");             
        }
        
        System.out.println("****************************************************************\n\n");
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


        ATM a = new ATM(me);

    }

}
