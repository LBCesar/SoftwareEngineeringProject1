
import java.util.*;

public class ATM {
    Display screen;
    BankCustomer me=new BankCustomer();
    

    public ATM(){//Might not need.
        this.me=bc();

    }
    private ATM(BankCustomer me) {//Made this constructor to load in a customer, if we can find a more graceful way to load in it would be cool.
        System.out.println("Customer loaded in");
        this.screen = new Display();
        this.me = me;
        start();
    }

    public BankCustomer bc(){//just for testing, delete later.
        return me;
    }
    public final void start() {//Calls the display class.
        int choice=screen.screen();//Our screen is the keypad, we are waiting for input
        if(choice==3){//Choices return here and we call more displays if needed
            float amount=screen.depositDisplay();//Our depositDisplay() returns the user input for deposit amount
            this.deposit(amount);//Now that we have the amount, call the deposit() function in ATM
        }
    }
        public void deposit(float amount) {//Here i handle all the "Logic" that is needed for a deposit. 
            System.out.println("Were back int ATM with $"+amount);
            //if(savings)
            me.savingsDeposit(amount);//Call BankCustmoer->savingsDeposit()->Which calls our savingsAccount.java function addBalance();
            //if(checkings)
            me.checkingsDeposit(amount);
            
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
        
        //================Delete Later. 
        System.out.println("NEW\n\n\nBefore ATM: $" + customer.get(0).getCheckingsBalance());
        System.out.println("Before ATM: $" + customer.get(0).getSavingsBalance());    
        ATM a= new ATM(me);
        BankCustomer bc=a.bc();
        System.out.println("After ATM: $" + bc.getCheckingsBalance());
        System.out.println("After ATM: $" + bc.getSavingsBalance());

    }

}


/**
 * Self Note: 
 * Log in window
 * money should be only two decimal place
 * 
 */