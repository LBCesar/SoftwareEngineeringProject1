
import java.util.*;

public class ATM {

    private double amount;
   

    public ATM(){
        
    }


    public void start() {//Calls the display class.
        Display screen = new Display();
        screen.screen();
    }


    public void transfer(double amount){

    }

    public static void main(String[] args) {

        BankCustomer me = new BankCustomer();
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
        customer.get(0).checkBalance();
        System.out.println();

        me.checkingsDeposit(100);
        System.out.println("After Deposit checkings " + 100 + " : $" + customer.get(0).getCheckingsBalance());

        me.checkingsWithdraw(150);
        System.out.println("After Checkings withdraw " + 150 + " : $"  + customer.get(0).getCheckingsBalance());

        me.savingsDeposit(100);
        System.out.println("After Deposit checkings " + 100 + " : $" + customer.get(0).getSavingsBalance());

        me.savingsWithdraw(150);
        System.out.println("After Deposit checkings " + 150 + " : $" + customer.get(0).getSavingsBalance());

        System.out.println();
        customer.get(0).checkBalance();
        System.out.println();

    }

}