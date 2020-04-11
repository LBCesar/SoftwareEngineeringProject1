
/**
 * 
 */

public class Display {
    
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


    public void mainDisplay(){

    }


    public void mainMenu(){

    }


    public void checkBalanceDisplay() {
        System.out.println("Display balance here");
        //checkings or savings?
    }

    public void depositDisplay() {
        System.out.print("Deposit amount: ");
        //checkings or savings?
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


    public static void main(String[] args) {
        

    }


}