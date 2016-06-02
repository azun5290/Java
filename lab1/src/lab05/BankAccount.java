package lab05;
/**
 * A bank account has a balance that can be changed by deposits and withdrawals.
 */
public class BankAccount {
	// instance fields
	private double balance;
	String owner;
	private double interestRate;

	/**
	 * Constructs a bank account with a zero balance.
	 */
	public BankAccount() {
		balance = 0;
		owner = null;
		interestRate = 0;
	}
	/**
	 * Constructs a bank account for the user with a given balance.
	 * @param rate 
	 */
	public BankAccount(String name, double initialBalance, double rate) {
		balance = initialBalance;
		owner = name;
		interestRate = rate;
	}
	/**
	 * Deposits money into the bank account.
	 * 
	 * @param amount
	 *            the amount to deposit
	 */
	public void deposit(double amount) {
		if (amount > 0)
			balance = balance + amount;
	}
	/**
	 * Withdraws money from the bank account.
	 * 
	 * @param amount
	 *            the amount to withdraw
	 */
	public void withdraw(double amount) {
		if (balance >= amount)
			balance = balance - amount;
	}
	/**
	 * Gets the current balance of the bank account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}
	
	public double getinterestRate(){
		return interestRate;
	}
}