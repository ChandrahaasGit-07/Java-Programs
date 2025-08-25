/* 
Questions :
Write a Java program to create a class known as "BankAccount" with methods called deposit() and withdraw(). 
Create a subclass called SavingsAccount that overrides the withdraw() method to prevent withdrawals if the account balance falls below one hundred.

2.1: Write a Java program where the "SavingsAccount" subclass automatically transfers excess funds to a fixed deposit.
*/

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
    int fixedDeposite = 0;
    static final int MIN_BALANCE = 100;
    static final int MAX_BALANCE = 10000;
    
    
    SavingsAccount(int balance, int accuntNumber)
    {
        super(balance, accuntNumber);
        transformExcessAmmount();
    }
    
    void withdraw(int ammount)
    {
        if(super.getBalance() - ammount <= MIN_BALANCE)
        {
            System.out.println("Minimum balance required INR 100");
        }
        else
        {
            super.withdraw(ammount);
        }
    }

  //fuc to check if the balance is exceeding the "MAX_BALANCE limit" in saivings account. If not it is transfored to "fixedDeposit".
    void transformExcessAmmount()
    {
        if(balance > MAX_BALANCE)
        {
            int excess = balance - MAX_BALANCE;
            balance = MAX_BALANCE;
            fixedDeposite = fixedDeposite + excess;
            System.out.println("₹" + excess + " has been auto-transferred to Fixed Deposit.");
        }
    }
    
    int getFixedDepositBalance()
    {
        return fixedDeposite;
    }
}
public class Main
{
	public static void main(String[] args) {
		SavingsAccount s1 = new SavingsAccount(20000, 123);
        System.out.println("Savings balance: ₹" + s1.getBalance());
        System.out.println("Fixed Deposit balance: ₹" + s1.getFixedDepositBalance());
        System.out.println();

        s1.withdraw(5000);
        System.out.println("Savings balance after withdrawal: ₹" + s1.getBalance());
        System.out.println("Fixed Deposit balance: ₹" + s1.getFixedDepositBalance());
        System.out.println();

        s1.deposit(6000); // Causes another FD transfer
        System.out.println("Savings balance after deposit: ₹" + s1.getBalance());
        System.out.println("Fixed Deposit balance: ₹" + s1.getFixedDepositBalance());
        System.out.println();

        // Another account with low balance
        SavingsAccount s2 = new SavingsAccount(200, 456);
        s2.withdraw(250);
        System.out.println("Balance after withdrawal: ₹" + s2.getBalance());

        s2.deposit(9500);
        System.out.println("Savings: ₹" + s2.getBalance());
        System.out.println("FD: ₹" + s2.getFixedDepositBalance());

        s2.deposit(1000); // Should trigger FD transfer
        System.out.println("After another deposit:");
        System.out.println("Savings: ₹" + s2.getBalance());
        System.out.println("FD: ₹" + s2.getFixedDepositBalance());
	}
}
