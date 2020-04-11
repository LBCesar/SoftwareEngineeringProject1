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
