package binf;

import java.util.Scanner;

public class fibo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);

		System.out.println("Enter a number and get the Fibonacci series up to that number");
		int num = read.nextInt();

		System.out.println("Your current fibonnacci "+ fibo(num));

	}

	public static long fibo(long num) {
		// TODO Auto-generated method stub
		if (num == 0)
			return 0;
		if (num == 1)
			return 1;
		return fibo(num - 1) + fibo(num - 2);
	}

}
