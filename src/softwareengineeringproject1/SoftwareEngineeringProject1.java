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
            while (true) {
                System.out.println("ATM");
                System.out.print("Account number:");
                //int userName = keypad();
                System.out.print("Enter pin:");
                //int pin = keypad();
                //Validate account/pin here
                System.out.println("\n ______________________");
                System.out.println("|[1] View Balance      |");
                //another screen to show balance;
                System.out.println("|[2] Withdraw Cash     |");
                //most important use case
                //Show different options of money 
                // multiples of 20
                //Cancel the transaction
                //if balance < withdraw.
                // Re calculate.

                System.out.println("|[3] Deposit Cash      |");
                System.out.println("|[4] Exit              |");
                System.out.println("|______________________|");
                int choice = keypad();
                if (choice < 0 || choice > 3) {
                    System.out.println("Bye");
                    break;
                }
                if (choice == 1) {
                    System.out.println("Display balance here");
                    //ATM.cashOut -> withdraw.work(customer)
                    
                    cashOut();

                }
                if (choice == 2) {
                    System.out.println(" _____________________");
                    System.out.println("|[1] $20      [5] $100|");
                    System.out.println("|[2] $40      [6] $120|");
                    System.out.println("|[3] $60      [7] $140|");
                    System.out.println("|[4] $80      [8] Exit|");
                    System.out.println("|_____________________|");
                    //Check to see whther the customer has money.
                    

                }
                if (choice == 3) {
                    System.out.print("Deposit amount: ");
                    int amount = keypad();
                    //Increment the customers balance and the ATM balance.
                }

            }
        }

        //return;
    }

    public static class input extends ATM {//All this class does is create a scanner object and returns ints.

        public int keypad2() {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            int x = myObj.nextInt();
            return x;
        }
    }

    public static class withdraw extends ATM {//Called from the ATM object
        //Money out
        public void work(customer c) {// Passed in a customer object, u can now check all of thier attributes.
            System.out.println(c.balance);
            System.out.println();
        }
    }

    public static class deposit extends ATM {//Will be called from the ATM object.
        //Money in
            public void work(customer c) {// Passed in a customer object, u can now check all of thier attributes.
            System.out.println(c.balance);
            System.out.println();
        }
    }

    public static class ATM extends bank {

        private float money = 50000;

        public void start() {//Calls the display class.
            display screen = new display();
            screen.screen();
        }

        public int keypad() {//Calls the input class.
            input key = new input();
            int x = key.keypad2();
            return x;
        }

        public void cashOut() {//Calls the withdraw class
            //money = money - out;
            withdraw w = new withdraw();

            w.work(accounts.get(2));

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

    public static class bank {

        static ArrayList<customer> accounts = new ArrayList<customer>();

        public void add(customer e) {
            accounts.add(e);
        }

        public int size() {
            return accounts.size();
        }

        public void print() {
            for (int i = 0; i < accounts.size(); i++) {
                System.out.println(accounts.get(i).name);
                System.out.println(accounts.get(i).balance);
            }
        }

    }

    public static class customer extends bank {

        private String name;
        private double balance;

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

        bank b = new bank();
        ATM a = new ATM();

        customer c;
        for (int i = 0; i < 10; i++) {
            c = new customer("Name", i);
            b.add(c);

        }
        System.out.println("This bank has " + b.size() + " accounts.");
        b.print();

        a.start();
        System.out.println("This bank has " + b.size() + " accounts.");

    }

}
