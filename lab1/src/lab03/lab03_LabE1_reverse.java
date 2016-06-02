package lab03;

import java.util.Scanner;

public class lab03_LabE1_reverse {
	/**
	 * @param args
	 * @param index
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] rev = new double[5];
		double sum = 0;
		double ave = 0;
		int N = rev.length;
		int index = 0;
		Scanner scn = new Scanner(System.in); // part of ver 2 - take input
												// interactively
		for (int i = 0; i < rev.length; i++) {
			// rev [i]= Double.parseDouble(args[i]); // ver 1 could have doubles
			// parsed from command line args

			// ver 2 could take input interactively
			rev[i] = scn.nextDouble();

			sum += rev[i];
			ave = sum / rev.length;
		}

		for (int j = 0; j < N / 2; j++) {
			double temp = rev[j];
			rev[j] = rev[N - 1 - j];
			rev[N - 1 - j] = temp;
		}

		System.out.println("Reversed values for this array are:");
		for (int z = 0; z < rev.length; z++) {
			System.out.print(rev[z] + "\t");
			index = z;
		}
		System.out.println();
		System.out.println("AVERAGE is " + ave);
		System.out.println("LENGTH is " + rev.length);
		System.out.print("Current index is " + index);
		System.out.println();
		System.out.print("Below average values are \t");
		for (int i = 0; i < rev.length; i++) {
			if (rev[i] < ave) {
				// belav = index;
				System.out.print("\n" + "Index is " + i + "\tAnd the value is "
						+ rev[i]);
			}
		}
	}
}