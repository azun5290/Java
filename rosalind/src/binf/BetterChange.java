package binf;

import java.util.Scanner;

public class BetterChange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner read = new Scanner(System.in);
		System.out.println("Enter amount");
		int M = read.nextInt();
		int r = M;

		int[] denom = new int[] { 25, 10, 5, 1 };
		int[] change = new int[4];

		for (int k = 0; k < denom.length; k++) {
			int count =0;
			change[k] = r / denom[k];
			r = r - (change[k] * denom[k]);
			//System.out.println("R is "+r);
			System.out.println("The n"+count+ "th denom has these many coins "+change[k]);
			count++;
		}
	}
}
