package lab06;

import java.util.ArrayList;

//import java.util.ArrayList;

public class BankAccountMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankAccount b = new BankAccount(10); 
		b.deposit(5000); 
		b.withdraw(b.getBalance() /2); 
		System.out.println("Answer A: balance of b "+b.getBalance());

		//b.  If b1 and b2 are two objects of the BankAccount class, consider the following instructions: 

		BankAccount b1 = new BankAccount(11); 
		b1.deposit(1000);
		BankAccount b2 = new BankAccount(11); 
		b2.deposit(3000);

		b1.deposit(b2.getBalance()); 
		b2.deposit(b1.getBalance());

		System.out.println("Answer B: b1 and b2 are different: "+b1.getBalance()+" and " + b2.getBalance());


		ArrayList <BankAccount> accounts = new ArrayList <BankAccount> ();
		accounts.add(new BankAccount(1000,"Mary",1000.0));
		accounts.add(new BankAccount(1001,"John",500.0));
		//accounts.add(new BankAccount(2, 2000));
		//accounts.add(new BankAccount(3, 1100));
		System.out.println(accounts.get(0).getName()+"\t"+accounts.get(0).getBalance());
		System.out.println(accounts.get(1).getName()+"\t"+accounts.get(1).getBalance());

		double max = accounts.get(0).getBalance();
		String richestPerson = accounts.get(0).getName();
		for (BankAccount A : accounts ) {
			if (A.getBalance() > max) {
				richestPerson = A.getName();
				max = A.getBalance();
			}
		}
		System.out.println("Richest person is " + richestPerson);


	}

}
