/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    /**
     * @param args the command line arguments
     */
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
                    checkBalanceD();
                }
                if (choice == 2) {
                    withdrawD();
                }
                if (choice == 3) {
                    depositD();
                }
                if (choice == 4) {
                    transferD();
                }

            }
        }

        void checkBalanceD() {
            System.out.println("Display balance here");
            //ATM.cashOut -> withdraw.work(customer)

            cashOut();
        }

        void depositD() {
            System.out.print("Deposit amount: ");
            //Increment the customers balance and the ATM balance.
        }

        void withdrawD() {
            System.out.println(" _____________________");
            System.out.println("|[1] $20      [5] $100|");
            System.out.println("|[2] $40      [6] $120|");
            System.out.println("|[3] $60      [7] $140|");
            System.out.println("|[4] $80      [8] Exit|");
            System.out.println("|_____________________|");
            //Check to see whther the customer has money.

        }

        void transferD() {
            System.out.println(" We will trasnfer here");
        }

        //return;
    }
//Removed 3/13
//    public static class input extends ATM {//All this class does is create a scanner object and returns ints.
//
//        public int keypad2() {
//            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//            int x = myObj.nextInt();
//            return x;
//        }
//    }
//Removed on 3/2
//    public static class withdraw extends ATM {//Called from the ATM object
//        //Money out
//        public void work(customer c) {// Passed in a customer object, u can now check all of thier attributes.
//            System.out.println(c.balance);
//            System.out.println();
//        }
//    }
//Removed on 3/2
//    public static class deposit extends ATM {//Will be called from the ATM object.
//        //Money in
//            public void work(customer c) {// Passed in a customer object, u can now check all of thier attributes.
//            System.out.println(c.balance);
//            System.out.println();
//        }
//    }

    public static class ATM {

        private float money = 50000;

        public void start() {//Calls the display class.
            display screen = new display();
            screen.screen();
        }



        public void cashOut() {//Calls the withdraw class
            //money = money - out;


        }

        public void cashIn(int in) {//Calls the deposit class.
            money = money + in;
        }

        public void balance() {

        }

        public float withdraw() {//Might delete
            //Update the money in the ATM
            money = money - 10;
            //Update the money in the customers account.
            //c.withdraw(money);
            return 10;
        }

        public void deposit(float amount) {//Might delete
        }

    }
//Removed 2/13
//    public static class bank {
//
//        static ArrayList<customer> accounts = new ArrayList<customer>();
//
//        public void add(customer e) {
//            accounts.add(e);
//        }
//
//        public int size() {
//            return accounts.size();
//        }
//
//        public void print() {
//            for (int i = 0; i < accounts.size(); i++) {
//                System.out.println(accounts.get(i).name);
//                System.out.println(accounts.get(i).balance);
//            }
//        }
//
//    }

    public static class checkingAccount {

    }

    public static class savingAccount {

    }

    public static class customer{

        private String name;
        private double balance;
        checkingAccount ca;
        savingAccount sa;

        private customer(String name, int i) {
            this.name = name;
            balance = i;
        }

        public void customer(String n, double b) {
            name = n;
            balance = b;
        }

        public void deposit(float m) {
            balance = m;
        }

        public float withdraw(float m) {
            balance = balance - m;
            return m;
        }

        public void balance() {
            System.out.println(balance);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ATM a = new ATM();
        a.start();

    }

}
