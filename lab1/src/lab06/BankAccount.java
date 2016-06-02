package lab06;

/** 
A bank account has a balance that can be changed by 
deposits and withdrawals. 
 */ 
public class BankAccount 
{   
	private static int accountNumber; 
	private double balance; 
	String name;

	/** 
   Constructs a bank account with a zero balance 
   @param anAccountNumber the account number for this account 
	 */ 
	public BankAccount(int anAccountNumber) 
	{   
		accountNumber++;
		accountNumber = anAccountNumber; 
		balance = 0; 
		name =null;
	} 
	/** 
   Constructs a bank account with a given balance 
   @param anAccountNumber the account number for this account 
   @param initialBalance the initial balance 
	 */ 
	public BankAccount(int anAccountNumber, String nm, double initialBalance) 
	{    
		accountNumber++;
		accountNumber = anAccountNumber; 
		balance = initialBalance; 
		name=nm;
	} 
	/** 
   Gets the account number of this bank account. 
   @return the account number 
	 */ 
	public int getAccountNumber() 
	{    
		return accountNumber; 
	} 
	/** 
   Deposits money into the bank account. 
   @param amount the amount to deposit 
	 */ 
	public void deposit(double amount) 
	{   
		double newBalance = balance + amount; 
		balance = newBalance; 
	} 
	/** 
   Withdraws money from the bank account. 
   @param amount the amount to withdraw 
	 */ 
	public void withdraw(double amount) 
	{    
		double newBalance = balance - amount; 
		balance = newBalance; 
	} 
	/** 
   Gets the current balance of the bank account. 
   @return the current balance 
	 */ 
	public double getBalance() 
	{    
		return balance; 
	} 
	public String getName(){
		return name;
	}
}