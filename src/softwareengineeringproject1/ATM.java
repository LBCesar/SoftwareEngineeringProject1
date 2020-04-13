
import java.util.*;

public class ATM {

    Display screen = new Display();


    public void start() {//Calls the display class.
        screen.screen();
    }


    public static void main(String[] args) {

        BankCustomer me = new BankCustomer();

        System.out.println("Customer Details");
        me.setName("lil Kanye");
        me.setEmail("dontgiveahoot@hoot.hoo");
        me.setAddress("1919 KayneWest@jtriseltunoob");
        me.setCardNumber(6325);
        me.setPIN(9111);
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

        System.out.println("Deposit/Withdraw");
        me.checkingsDeposit(100);
        System.out.println("After Checkings deposit $" + 100 + " : $" + customer.get(0).getCheckingsBalance());

        me.checkingsWithdraw(150);
        System.out.println("After Checkings withdraw $" + 150 + " : $"  + customer.get(0).getCheckingsBalance());

        me.savingsDeposit(100);
        System.out.println("After Savings deposit $" + 100 + " : $" + customer.get(0).getSavingsBalance());

        me.savingsWithdraw(150);
        System.out.println("After Savings withdraw $" + 150 + " : $" + customer.get(0).getSavingsBalance());

        System.out.println();
        System.out.println("Check Balance");
        customer.get(0).checkBalance();
        System.out.println();

        System.out.println("Check Balance before transfer");
        customer.get(0).checkBalance();
        me.transferBalance();
        System.out.println("Check Balance after transfer");
        customer.get(0).checkBalance();

    }

}


/**
 * Self Note: 
 * Log in window
 * money should be only two decimal place
 * 
 */