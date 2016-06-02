package binf;

import java.util.Scanner;
import java.math.*;

public class fibo_dp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner read = new Scanner(System.in);
		System.out.println("Enter a number and get the Fibonacci series up to that number");
		
		
		long n = read.nextLong();
		System.out.println("Your current fibonnacci " + fibo(n));
	}

	public static long fibo(long n) {
		
		int i = 0;
		if (n <= 2)
			return 1;
		else {
			long[] A = new long[(int) (n + 1)];
			A[1] = 1;
			A[2] = 1;
			for (i = 3; i <= n; i++) {
				A[i] = A[i - 1] + A[i - 2];
			}
			return A[i-1];
		}
	}
}
