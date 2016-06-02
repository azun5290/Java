package week7;

public class Customer {
	private double creditCardBalance;
	private double chequeAccountBalance;
	private String name;


	public Customer(String nm) {
		name =nm;
		chequeAccountBalance =0.0;
		creditCardBalance = 0.0;
	}
	public Customer(String nm, double ccb, double cab){
		name =nm;
		chequeAccountBalance =ccb;
		creditCardBalance = cab;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public String getName(){
		return name;		
	}
	public void setName(String nm){
		name = nm;
	}
	public double getCreditCardBalance(){
		return creditCardBalance;
	}

	public void setCreditCardBalance(int ccb){
		creditCardBalance = ccb;
	}
	public double getChequeAccountBalance(){
		return chequeAccountBalance;
	}

	public void setchequeAccountBalance(int cab){
		chequeAccountBalance = cab;
	}
	public void writeCheque(double amount) {

	}
	public void payWithCreditCard(double amount)  
	{

	}
	public void depositChequeAccount(double amount)  
	{
// ....
	}
	
	public double getWealth(){
		return creditCardBalance + chequeAccountBalance;
	}
	public String toString(){
		return name + "\t"+ chequeAccountBalance + "\t"+ creditCardBalance;
	}

}
