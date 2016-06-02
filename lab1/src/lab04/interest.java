package lab04;

import java.util.Scanner;

public class interest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner DblScan = new Scanner(System.in);
		double principle = DblScan.nextDouble();
		double interestRate = DblScan.nextDouble();
		double interest = principle*interestRate;
	
		for (int i=0;i<10;i++){
			System.out.println("Year "+i+" - Start: Principle is "+principle+ ", Interest: "+interest +"\tTotal for the year: "+(principle+interest));
			principle = principle+interest;
			interest = principle*interestRate;
		}
	}
}