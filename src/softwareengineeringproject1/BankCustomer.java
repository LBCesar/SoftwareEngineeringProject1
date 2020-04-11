/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineeringproject1;

/**
 *
 * @author Cesar Gonzalez
 */
public class BankCustomer {
   // public static class customer{

        private String name;
        private String email;
        private String address;
        private int cardNumber;
        private int pin;
        
        SoftwareEngineeringProject1.checkingAccount ca;
        SoftwareEngineeringProject1.savingsAccount sa;

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
   // }
}
