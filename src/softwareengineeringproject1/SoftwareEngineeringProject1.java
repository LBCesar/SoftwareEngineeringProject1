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
    public static class ATM {

        private float money;

        public void balance() {
                        
        }

        public float withdraw() {
        System.out.println(" _____________________");
        System.out.println("|[1] $20      [5] $100|");
        System.out.println("|[2] $40      [6] $120|");
        System.out.println("|[3] $60      [7] $140|");
        System.out.println("|[4] $80      [8] Exit|");
        System.out.println("|_____________________|");
        //Update the money in the ATM
            money=money-10;
            //Update the money in the customers account.
            //c.withdraw(money);
            return 10;
        }

        public void deposit(float amount) {
        }

    }

    public static class Hash328<K, V> {

        private double loadFactor = 0.5;
        private int size = 0;
        private int capacity = 20;
        private Entry[] table;

        private class Entry<K, V> {

            Entry<K, V> next = null;
            K key;
            V value;

            Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }

            K getKey() {
                return this.key;
            }

            V getValue() {
                return this.value;
            }

            V updateValue(V value) {
                V temp = this.value;
                this.value = value;
                return temp;
            }
        }
        //Constructor

        Hash328() {
            table = new Entry[capacity];
        }

        void associate(K key, V value) {
            int hash = Math.abs(key.hashCode()) % capacity;
            if (table[hash] != null) {
                Entry<K, V> curr = table[hash];
                Entry<K, V> prev = null;
                while (curr != null && !(curr.getKey().equals(key))) {
                    prev = curr;
                    curr = curr.next;
                }
                if (curr != null) {
                    curr.updateValue(value);
                } else {
                    prev.next = new Entry<>(key, value);
                    size++;
                }
            } else {
                table[hash] = new Entry<>(key, value);
                size++;
            }

        }

        V find(K from) {
            int hash = Math.abs(from.hashCode() % capacity);
            Entry<K, V> curr = table[hash];
            while (curr != null && !(curr.getKey().equals(from))) {
                curr = curr.next;
            }
            return (curr == null) ? null : curr.getValue();
        }

    }

    public static class customer {

        private String name;
        private double balance;

        private customer(String name, int i) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        Hash328<Integer, customer> h = new Hash328<Integer, customer>();
        customer c;
        ATM a=new ATM();
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
   // System.out.println("Enter username");

        //int userName = myObj.nextInt();
        a.withdraw();
        System.out.print("Account number:");
                int userName = myObj.nextInt();

        System.out.print("Enter pin:");
        int pin = myObj.nextInt();

        System.out.println(" ______________________");
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
        //Cancel transaction.
        System.out.println("|[4] Exit              |");
        System.out.println("|______________________|");

        // customer c= new customer("Cesar", 1.12);
        // c.customer("Cesar", 1.12);
        //  int pw=123456;
        /// h.associate(pw, c);
        System.out.println("Done");
        for (int i = 0; i < 10; i++) {
            //c=new customer("Name",i);
            h.associate(i, new customer("Name", i));
        }

        int size = h.table.length;
        for (int i = 0; i < size - 1; i++) {
            
            //   System.out.println(h.table[i].key);

        }

    }

}

/*
menu .. pin number..console window ok

4 option
withdraw cash
view baalnce
deposit funds
exit.

*/
