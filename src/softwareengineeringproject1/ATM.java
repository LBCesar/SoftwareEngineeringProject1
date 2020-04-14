
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        //these next two lines are a quick way of dealing with login
        //the Display function Login() will create an array with the first element
        //being the accoutn number and the secon element being the pin
        //this way we get both in one call, if either is wrong we dont allow entry anyways.
        
        int f[]=new int[2];
        f=screen.Login();
        System.out.println("Account:"+f[0]);
        System.out.println("Pin"+f[1]);

            //if(f[0]==our number)
            // if(f[1]==our pin)
            //      continue->

        
        
        //We need to pick either checking or savings, idk what the best approach is, i made this one up.
        int x=screen.checkOrSave();
        //maybe we can have some booleans that we can use to satisfiy conditions later on.
        boolean check=false;
        boolean save=false;   
        if(x==1){
            //checking
            check=true;
        }
        if(x==2){
            //savings
            save=true;
        }
        System.out.println("Checkings:"+check);
        System.out.println("Savings:"+save);
        
        
        
        //for example if we deposit and choose checking(x==1)
        //if(check==true)
            //our deposit will go into the checkings account
        //if(save==true)
            // this condition isnt met as check/save are always false.
        

        
        
        screen.mainMenu();
        int choice=screen.screen();//Our screen is the keypad, we are waiting for input
        //if(choice==1 2 )
        if(choice==3){//Choices return here and we call more displays if needed
            float amount=screen.depositDisplay();//Our depositDisplay() returns the user input for deposit amount
            this.deposit(amount);//Now that we have the amount, call the deposit() function in ATM
        }
        //if(choice == 4 5 6 7 ....)
    }
    //void witdraw()
    //void transfer()
    //void balance()
        public void deposit(float amount) {//Here i handle all the "Logic" that is needed for a deposit. 
            //if(savings)
            me.savingsDeposit(amount);//Call BankCustmoer->savingsDeposit()->Which calls our savingsAccount.java function addBalance();
            //if(checkings)
            me.checkingsDeposit(amount);
            
        }


    public static void main(String[] args) {

        BankCustomer me = new BankCustomer();

        //System.out.println("Customer Details");
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
        /*
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
*/
       // System.out.println("Deposit/Withdraw");
        me.checkingsDeposit(100);
        //System.out.println("After Checkings deposit $" + 100 + " : $" + customer.get(0).getCheckingsBalance());

        me.checkingsWithdraw(150);
        //System.out.println("After Checkings withdraw $" + 150 + " : $"  + customer.get(0).getCheckingsBalance());

        me.savingsDeposit(100);
        //System.out.println("After Savings deposit $" + 100 + " : $" + customer.get(0).getSavingsBalance());

        me.savingsWithdraw(150);
        //System.out.println("After Savings withdraw $" + 150 + " : $" + customer.get(0).getSavingsBalance());
        /*
        System.out.println();
        System.out.println("Check Balance");
        customer.get(0).checkBalance();
        System.out.println();
*/
       // System.out.println("Check Balance before transfer");
        //customer.get(0).checkBalance();
        //me.transferBalance();
       // System.out.println("Check Balance after transfer");
       // customer.get(0).checkBalance();
        
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