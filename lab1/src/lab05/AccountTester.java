package lab05;

public class AccountTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount A = new BankAccount ("Leo",500,0.002);
		BankAccount B = new BankAccount ("Amparo",1000,0.002);
		System.out.println(A.owner+"\t"+(A.getBalance()+(A.getinterestRate()*A.getBalance()*30)));
		System.out.println(B.owner+"\t"+(B.getBalance()+(B.getinterestRate()*B.getBalance()*30)));
		A.deposit(1000);
		System.out.println(A.owner+"\t sold his car!");
		B.withdraw(200);
		System.out.println(B.owner+"\t bought a dress!");
		System.out.println("So now...");
		System.out.println(A.owner+"\t has a monthly interest "+A.getinterestRate()*A.getBalance()*30+" and balance " +(A.getBalance()+(A.getinterestRate()*A.getBalance()*30)));
		System.out.println(B.owner+"\t"+(B.getBalance()+(B.getinterestRate()*B.getBalance()*30)));
	}

}
