/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineeringproject1;

// import softwareengineeringproject1.SoftwareEngineeringProject1.checkingAccount;
// import softwareengineeringproject1.SoftwareEngineeringProject1.savingsAccount;

/**
 *
 * @author Cesar Gonzalez
 */


import java.lang.*;
import java.util.*;

public class BankCustomer {

    private String name;
    private String email;
    private String address;
    private int cardNumber;
    private int pin;
    
    // SoftwareEngineeringProject1.checkingAccount ca;
    // SoftwareEngineeringProject1.savingsAccount sa;
    checkingAccount cAccount = new checkingAccount();
    savingsAccount sAccount = new savingsAccount();


    public BankCustomer(){

    }


    public void BankCustomer(String n, String e, String a,int c,int p, double b1, int a1, double b2, int a2) {
        name = n;
        email= e;
        address = a;
        cardNumber = c;
        pin = p;
        cAccount.setBalance(b1);
        cAccount.setAccountNumber(a1);
        sAccount.setBalance(b2);
        sAccount.setAccountNumber(a2);
    }


    public double deposit(double amount){
        return 0;
    }


    public double withdraw(double amount) {
        return amount;
    }


    public void balance() {
        System.out.println();
    }


    public void transfer(){
        
    }

}
