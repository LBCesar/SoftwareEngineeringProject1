package softwareengineeringproject1;

import java.util.*;

/**
 * You are being asked to design and build a software system for an ATM machine.
 * The software must be a desktop application and written using either Eclipse
 * with Java or Visual Studio with C++. I must be able to build and run your
 * deliverables using a CECS lab load. I.e., the software that is installed in
 * our computer labs or your own laptop.
 *
 * A local bank intends to install a new automated teller machine to allow the
 * bank customers to perform basic financial transactions. Each customer can
 * have only one account at the bank. ATM customers should be able to view their
 * account balance, withdraw cash, and deposit funds.
 *
 * This is the initial proposed system. I will be filling out more details and
 * adding more functionality in class as part of your requirements analysis.
 */
public class SoftwareEngineeringProject1 {

    public static class display extends ATM {

        public void screen() {
            System.out.println("ATM");
            System.out.print("Account number:");
            System.out.print("Enter pin:");
            while (true) {
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                // int x = myObj.nextInt();

                System.out.println("\n ______________________");
                System.out.println("|[1] View Balance      |");
                System.out.println("|[2] Withdraw Cash     |");
                System.out.println("|[3] Deposit Cash      |");
                System.out.println("|[4] Transfer          |");
                System.out.println("|[5] Exit              |");
                System.out.println("|______________________|");
                int choice = myObj.nextInt();
                if (choice < 0 || choice > 4) {
                    System.out.println("Bye");
                    break;
                }
                if (choice == 1) {
                    checkBalanceDisplay();
                }
                if (choice == 2) {
                    withdrawDisplay();
                }
                if (choice == 3) {
                    depositDisplay();
                }
                if (choice == 4) {
                    transferDisplay();
                }

            }
        }

        void checkBalanceDisplay() {
            System.out.println("Display balance here");
            //checkings or savings?
        }

        void depositDisplay() {
            System.out.print("Deposit amount: ");
            //checkings or savings?
        }

        void withdrawDisplay() {
            System.out.println(" _____________________");
            System.out.println("|[1] $20      [5] $100|");
            System.out.println("|[2] $40      [6] $120|");
            System.out.println("|[3] $60      [7] $140|");
            System.out.println("|[4] $80      [8] Exit|");
            System.out.println("|_____________________|");
            //checking or savings?

        }

        void transferDisplay() {
            System.out.println(" We will trasnfer here");
        }
    }

    public static class ATM {

        private float money = 50000;

        public void start() {//Calls the display class.
            display screen = new display();
            screen.screen();
        }

        public void balance() {
        }
        public float withdraw(float amount) {
            return 10;
        }

        public void deposit(float amount) {
        }

        public void transfer(float amount) {
        }

    }


    public static class checkingAccount {
        private float balance;
        private int accountNumber;
        public void getBalance(){
        }
        public void setBalance(float amount){
        }
        public int getAccountNumber(){
        return accountNumber;
        }
        public void setAccountNumber(int number){
        }
    }
    
    public static class savingsAccount {
        private float balance;
        private int accountNumber;
        public void getBalance(){
        }
        public void setBalance(float amount){
        }
        public int getAccountNumber(){
        return accountNumber;
        }
        public void setAccountNumber(int number){
        }
    }

    public static class customer{

        private String name;
        private String email;
        private String address;
        private int cardNumber;
        private int pin;
        
        checkingAccount ca;
        savingsAccount sa;

        public void customer(String n,String e,String a,int c,int p,float b1,int a1,float b2,int a2) {
            name = n;
            email=e;
            address=a;
            cardNumber=c;
            pin=p;
            ca.setBalance(b1);
            ca.setAccountNumber(a1);
            sa.setBalance(b2);
            sa.setAccountNumber(a2);
        }

        public void deposit(float amount) {
        }

        public float withdraw(float amount) {
            return amount;
        }

        public void balance() {
            System.out.println();
        }
        public void transfer(){
            
        }
    }
    public static void main(String[] args) {
        ATM a = new ATM();
        a.start();
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

/*og getIntRange.
//    public int getIntRange( int low, int high ) {
//		Scanner in = new Scanner( System.in );
//		int input = 0;
//		boolean valid = false;
//		while( !valid ) {
//			if( in.hasNextInt() ) {
//				input = in.nextInt();
//				if( input <= high && input >= low ) {
//					valid = true;
//				} else {
//					System.out.println( "Invalid Range." );
//				}
//			} else {
//				in.next(); //clear invalid string
//				System.out.println( "Invalid Input." );
//			}
//		}
//		return input;
//	}



*/
