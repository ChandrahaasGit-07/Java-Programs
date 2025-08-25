/* Write a Java program to create a class known as "BankAccount" with methods called deposit() and withdraw(). 
Create a subclass called SavingsAccount that overrides the withdraw() method to prevent withdrawals if the account balance falls 
below one hundred. */

class BankAccount
{
    int balance;
    int accuntNumber;
    
    BankAccount(int balance, int accuntNumber)
    {
        this.balance = balance;
        this.accuntNumber = accuntNumber;
    }
    void deposit(int ammount)
    {
        balance = balance + ammount;
    }
    
    void withdraw(int ammount)
    {
        if(balance >= ammount)
        {
            balance = balance - ammount;
            System.out.println("Ammount withdrawn successfully....");
        }
        else
        {
            System.out.println("Insufficient Balance");
        }
    }
    
    public int getBalance()
    {
        return balance;
    }
    
}

class SavingsAccount extends BankAccount
{
    SavingsAccount(int balance, int accuntNumber)
    {
        super(balance, accuntNumber);
    }
    
    void withdraw(int ammount)
    {
        if(super.getBalance() - ammount <= 100)
        {
            System.out.println("Minimum balance required INR 100");
        }
        else
        {
            super.withdraw(ammount);
        }
    }
}
public class Main
{
	public static void main(String[] args) {
		SavingsAccount s1 = new SavingsAccount(20000, 123);
		s1.withdraw(5000);
		
		//Check balance
		System.out.println("Balance in our account after withdrawal is :"+s1.getBalance());
		
		//adding (or) deposit 
		s1.deposit(500);
		//Check balance after deposit
		System.out.println("Balance in our account after deposit is :"+s1.getBalance() +"\n\n");
		
		
		SavingsAccount s2 = new SavingsAccount(200, 456);
		s2.withdraw(250);
		//Check balance
		System.out.println("Balance in our account after withdrawal is :"+s2.getBalance());
		s2.deposit(500);
		//Check balance after deposit
		System.out.println("Balance in our account after deposit is :"+s2.getBalance());
		s2.withdraw(250);
		System.out.println("Now balance after withdraw is :"+s2.getBalance());
		
	}
}
