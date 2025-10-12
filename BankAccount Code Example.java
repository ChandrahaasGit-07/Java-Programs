/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
abstract class BankAccount
{
    private String AccountNo;
    private double Balance;
    
    BankAccount(String AccountNo, double Balance)
    {
        this.AccountNo = AccountNo;
        this.Balance = Balance;
    }
    
    String get_AccountNo()
    {
        return AccountNo;
    }
    
    double get_Balance()
    {
        return Balance;
    }
    
    void set_Balance(double Balance)
    {
        this.Balance = Balance;
    }
    abstract void deposit(double ammount);
    abstract void withdraw(double ammount);
}


class SavingsAccount extends BankAccount
{
    // private final double MINIMUM_BALANCE = 1000.00;
    private final double OVERDRAFT_LIMIT = 1000.00; 
    SavingsAccount(String AccountNo, double Balance)
    {
        super(AccountNo, Balance);
    }
    
    void deposit(double ammount)
    {
        set_Balance(get_Balance() + ammount);
        System.out.println("The ammount " + ammount + "is succesfully deposited");
        System.out.println("Thank You ....");
    }
    
    void withdraw(double ammount)
    {
        if(get_Balance() - ammount >= -OVERDRAFT_LIMIT)
        {
            set_Balance(get_Balance() - ammount);
            System.out.println("The ammount "+ ammount + "is succesfully withdrawn");
            System.out.println("Please collect the cash.      Thank You.....");
        }
        else {
            // Print a message indicating insufficient funds
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}

class CurrentAccount extends BankAccount
{
    CurrentAccount(String AccountNo, double Balance)
    {
        super(AccountNo, Balance);
    }
    
    void deposit(double ammount)
    {
        set_Balance(get_Balance() + ammount);
        System.out.println("The ammount " + ammount + "is succesfully deposited");
        System.out.println("Thank You ....");
    }
    
    void withdraw(double ammount)
    {
        if(get_Balance() >= ammount)
        {
            set_Balance(get_Balance() - ammount);
            System.out.println("The ammount "+ ammount + "is succesfully withdrawn");
            System.out.println("Please collect the cash.      Thank You.....");
        }
        else {
            // Print a message indicating insufficient funds
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}
public class Main
{
	public static void main(String[] args) {
		double initial_balance, deposit_amt, withdraw_amt;
		initial_balance = 2000.00;
		
		SavingsAccount saving = new SavingsAccount("12345", initial_balance);
		System.out.println("Initial balance in Saving account is :"+ initial_balance);
		
		deposit_amt = 500.00;
		saving.deposit(deposit_amt);
		
		System.out.println("The current balance of Saving Account is :"+saving.get_Balance());
		
		withdraw_amt = 1000.00;
		saving.withdraw(withdraw_amt);
		
		System.out.println("The current balance of Saving Account is :"+saving.get_Balance());
		
		//..........................................................................//
		
		System.out.println("\n\n\n");
		
		initial_balance = 5000.00;
		CurrentAccount current = new CurrentAccount("23145", initial_balance);
		System.out.println("Initial balance in Current account is :"+ initial_balance);
		
		deposit_amt = 1000.00;
		current.deposit(deposit_amt);
		
		System.out.println("The current balance of Current Account is :"+current.get_Balance());
		
		withdraw_amt = 2200.00;
		current.withdraw(withdraw_amt);
		
		System.out.println("The current balance of Saving Account is :"+current.get_Balance());
		
	}
}