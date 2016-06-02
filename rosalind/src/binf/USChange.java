package binf;

import java.util.Scanner;

public class USChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner read = new Scanner(System.in);
		System.out.println("Enter amount");
		int M = read.nextInt();
		int r = M;
		int q = 0, d = 0, n = 0, p = 0;
		q = r / 25;
		r = r - 25 * q;
		d = r / 10;
		r = r - 10 * d;
		n = r / 5;
		r = r - 5 * n;
		p = r;
		// return USChange(q,d,n,p);
		System.out.println("The change is "+ q + " quarters, " + d + " dimes, " + n + " nickels and " + p +" pennies");
	}

}
