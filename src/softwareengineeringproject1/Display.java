
/**
 *
 */

import java.util.*;

public class Display {

    Scanner myObj = new Scanner(System.in);  // Create a Scanner object

    public int screen(int low, int high) {//This is sort of now the keypad/ main landing zone.
        int choice = myObj.nextInt();
        boolean valid = false;
        while (!valid) {
            if (choice <= high && choice >= low) {
                valid = true;
            } else {
                System.out.println("Invalid Input.");
                choice = screen(low, high);
            }
        }
        return choice;
    }
    public int[] Login() {
        System.out.println("Please enter your account number and PIN");
        int f[] = new int[2];
        System.out.print("Account Number(1234): ");
        f[0] = this.screen(0, 9999);
        System.out.print("Enter PIN(1111): ");
        f[1] = this.screen(0, 9999);
        return f;
    }

    public int rerun() {
        System.out.println("\nWould you like to make another transaction?");
        System.out.println("[1] Yes\n[2] No");
        return this.screen(1, 2);
    }

    public int checkOrSave() {
        System.out.println("\nPlease choose an account to make your transaction");
        System.out.println("[1] Checkings Account");
        System.out.println("[2] Savings Account");
        int f = this.screen(1, 2);

        if(f == 1)
            System.out.println("\nCheckings Account");
        else
            System.out.println("\nSavings Account");

        return f;
    }

    public int mainMenu() {
        System.out.println("[1] View Balance      ");
        System.out.println("[2] Withdraw Cash     ");
        System.out.println("[3] Deposit Cash      ");
        System.out.println("[4] Transfer          ");
        System.out.println("[5] Exit              ");
        return this.screen(1, 5);
    }

    public void checkBalanceDisplay() {
        System.out.println("\nDisplay Current Balance");          // Could be possible to print current system time format
    }

    public float depositDisplay() {
        System.out.println("\nDeposit Amount:");
        float amount = this.screen(1, 9999);
        return amount;
    }

    public int withdrawDisplay() {
        System.out.println("\nWithdraw Amount");
        System.out.println("|[1] $20      [5] $100|");
        System.out.println("|[2] $40      [6] $120|");
        System.out.println("|[3] $60      [7] $140|");
        System.out.println("|[4] $80      [8] Exit|");
        int choice = this.screen(1, 8);
        return choice;
    }

    public double transferDisplay(int choice) {
		// System.out.println("Which account do you wish to transfer money to:");
		// System.out.println("[1] Checkings to Savings");screen
		// System.out.println("[2] Savings to Checkings");
		
		// int choice = getIntRange(1,2);
		double amount = 0;
		System.out.println();

		if(choice == 1){
			System.out.println("Transferring from Checkings to Savings");
			// System.out.println("Enter the amount you wish to tranfer: ");
		}
		
		else{
			System.out.println("Transferring from Savings to Checkings");
		}

		System.out.println("Enter the amount you wish to tranfer: ");
		amount = this.screen(1, 9999);
		
		return amount;

	}
}
