/**
 * 
 */

import java.io.IOException;
import java.util.*;

public class Display extends ATM{
// public class Display{
    
    public int screen() {//This is sort of now the keypad/ main landing zone.
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        //mainMenu();Might remove this forever
        int choice = myObj.nextInt();
        //int choice =3;//Uncomment above, and delete this when testing is finished.

        return choice;
    }


    public int[] Login(){
        System.out.println("PROJECT ATM\n");
        int f[]=new int[2];
        System.out.print("Account number:\n");//Need function for verifying.
        f[0]=this.screen();
        System.out.print("Enter pin:\n");//Need function for verifying.
        f[1]=this.screen();
        return f;
    }
    public int checkOrSave(){
        System.out.println("We need to figure out how to choose between checking and savings\nIs here a good spot?");
        System.out.println("1)Checking\n2)Savings");
        int f=this.screen();
        return f;
    }


    public void mainDisplay(){

    }


    public void mainMenu(){
        System.out.println("\n_____________________");
        System.out.println("|     Main Menu        |");
        System.out.println("|[1] View Balance      |");
        System.out.println("|[2] Withdraw Cash     |");
        System.out.println("|[3] Deposit Cash      |");
        System.out.println("|[4] Transfer          |");
        System.out.println("|[5] Exit              |");
        System.out.println("|______________________|");
    }


    public void checkBalanceDisplay() {
        System.out.println("Display balance here");
        //checkings or savings?
    }

    public float depositDisplay() {
        System.out.println("Deposit amount:");
        //float amount=50;//Replace this with user input.
        //checkings or savings?
        float amount=this.screen();
        return amount;
    }

    public void withdrawDisplay() {
        System.out.println(" _____________________");
        System.out.println("|[1] $20      [5] $100|");
        System.out.println("|[2] $40      [6] $120|");
        System.out.println("|[3] $60      [7] $140|");
        System.out.println("|[4] $80      [8] Exit|");
        System.out.println("|_____________________|");
        //checking or savings?

    }

    public void transferDisplay() {
        System.out.println(" We will trasnfer here");
    }

}