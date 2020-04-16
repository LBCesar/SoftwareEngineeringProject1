
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ATM {

    Display screen;
    BankCustomer me = new BankCustomer();

    public ATM() {

    }

    private ATM(BankCustomer me) {      //Made this constructor to load in a customer, if we can find a more graceful way to load in it would be cool.
        System.out.println("Customer loaded in\n");
        this.screen = new Display();
        this.me = me;
        start();
    }

    public BankCustomer bc() {          //just for testing, delete later.
        return me;
    }

    public boolean login() {
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
            screen.mainMenu();
            //Our screen is the keypad, we are waiting for input
            int choice = screen.screen();

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
        int amount = 0;
        int choiceWithdraw = screen.withdrawDisplay();	//prompts for an input for withdraw amount
        if (choiceWithdraw == 1) {						//choice 1 will withdraw $20
            //this.withdraw(20, accountChoice);
            amount = 20;
        } else if (choiceWithdraw == 2) {				//choice 2 will withdraw $40
            //this.withdraw(40, accountChoice);
            amount = 40;
        } else if (choiceWithdraw == 3) {				//choice 3 will withdraw $60
            //this.withdraw(60, accountChoice);
            amount = 60;
        } else if (choiceWithdraw == 4) {				//choice 4 will withdraw $80
            //this.withdraw(80, accountChoice);
            amount = 80;
        } else if (choiceWithdraw == 5) {				//choice 5 will withdraw $100
            //this.withdraw(100, accountChoice);
            amount = 100;
        } else if (choiceWithdraw == 6) {				//choice 6 will withdraw $120
            //this.withdraw(120, accountChoice);
            amount = 120;
        } else if (choiceWithdraw == 7) {				//choice 7 will withdraw $140;
            //this.withdraw(140, accountChoice);
            amount = 140;
        }

        if (accountChoice == 1) {
            if (me.getCheckingsBalance() - amount >= 0) {	//checks for sufficient funds
                me.checkingsWithdraw(amount);
            } else {
                System.out.println("Insufficient Funds!");
            }
        }
        if (accountChoice == 2) {
            if (me.getSavingsBalance() - amount >= 0) {		//checks for sufficient funds
                me.savingsWithdraw(amount);
            } else {
                System.out.println("Insufficient Funds!");
            }
        }
    }

    public void transfer(float amount) {
        // Andre
        System.out.println("Adding this here so i can make it switch case!");
    }

    public void balance(int accountChoice) {
        screen.checkBalanceDisplay();
        if (accountChoice == 1) {
            System.out.println("Checkings Account Balance: $" + me.getCheckingsBalance());
        }

        if (accountChoice == 2) {
            System.out.println("Savings Account Balance: $" + me.getSavingsBalance());
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
        me.setCheckingsBalance(100);
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
//shaan og work.
//                    int choiceWithdraw = screen.withdrawDisplay();	//prompts for an input for withdraw amount
//                    if(choiceWithdraw == 1) {						//choice 1 will withdraw $20
//                        this.withdraw(20, accountChoice);
//                    } else if(choiceWithdraw == 2) {				//choice 2 will withdraw $40
//                        this.withdraw(40, accountChoice);
//                    } else if(choiceWithdraw == 3) {				//choice 3 will withdraw $60
//                        this.withdraw(60, accountChoice);
//                    } else if(choiceWithdraw == 4) {				//choice 4 will withdraw $80
//                        this.withdraw(80, accountChoice);
//                    } else if(choiceWithdraw == 5) {				//choice 5 will withdraw $100
//                        this.withdraw(100, accountChoice);
//                    } else if(choiceWithdraw == 6) {				//choice 6 will withdraw $120
//                        this.withdraw(120, accountChoice);
//                    } else if(choiceWithdraw == 7) {				//choice 7 will withdraw $140
//                        this.withdraw(140, accountChoice);
//                    }   

//og main
/*
        BankCustomer me = new BankCustomer();

        //System.out.println("Customer Details");
        me.setName("lil Kanye");
        me.setEmail("dontgiveahoot@hoot.hoo");
        me.setAddress("1919 KayneWest@jtriseltunoob");
        me.setCardNumber(1234);
        me.setPIN(1111);
        me.setCheckingsAccountNumber(4545);
        me.setCheckingsBalance(150);
        me.setSavingsAccountNumber(4546);
        me.setSavingsBalance(100);

        // testing using an arraylist that holds objects.
        List<BankCustomer> customer = new ArrayList<BankCustomer>();
        customer.add(me);
        
        System.out.println("Name: " + customer.get(0).getName());
        System.out.println("Email: " + customer.get(0).getEmail());
        System.out.println("Address: " + customer.get(0).getAddress());
        System.out.println("Card Num: " + customer.get(0).getCardNumber());
        System.out.println("PIN: " + customer.get(0).getPIN());
        System.out.println("Checkings Acc: " + customer.get(0).getCheckingsAccountNumber());
        System.out.println("Checkings Balance: " + "$" + customer.get(0).getCheckingsBalance());
        System.out.println("Savings Acc: " + customer.get(0).getSavingsAccountNumber());
        System.out.println("Savings Balance: " + "$" + customer.get(0).getSavingsBalance());

        System.out.println();
        System.out.println("Current Customer Balance");
        customer.get(0).checkBalance();
        System.out.println();

       // System.out.println("Deposit/Withdraw");
        me.checkingsDeposit(100);
        //System.out.println("After Checkings deposit $" + 100 + " : $" + customer.get(0).getCheckingsBalance());

        me.checkingsWithdraw(150);
        //System.out.println("After Checkings withdraw $" + 150 + " : $"  + customer.get(0).getCheckingsBalance());

        me.savingsDeposit(100);
        //System.out.println("After Savings deposit $" + 100 + " : $" + customer.get(0).getSavingsBalance());

        me.savingsWithdraw(150);
        //System.out.println("After Savings withdraw $" + 150 + " : $" + customer.get(0).getSavingsBalance());
        
        System.out.println();
        System.out.println("Check Balance");
        customer.get(0).checkBalance();
        System.out.println();

       // System.out.println("Check Balance before transfer");
        //customer.get(0).checkBalance();
        //me.transferBalance();
       // System.out.println("Check Balance after transfer");
       // customer.get(0).checkBalance();
        
        //================Delete Later. 
        System.out.println("NEW\n\n\nInitial Checkings Balance: $" + customer.get(0).getCheckingsBalance());
        System.out.println("Initial Savings Balance: $" + customer.get(0).getSavingsBalance());  

        ATM a = new ATM(me);
        BankCustomer bc = a.bc();

        System.out.println("After Checkings Balance: $" + bc.getCheckingsBalance());
        System.out.println("After Savings Balance: $" + bc.getSavingsBalance());
*/
