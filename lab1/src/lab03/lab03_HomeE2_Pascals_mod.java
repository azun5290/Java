package lab03;

import java.util.Scanner;

public class lab03_HomeE2_Pascals_mod {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the size of the array: ");
		int arraySize = scanner.nextInt();
		if (arraySize < 1) {
			System.out.print("Please enter a size greater or equals to 1");
		}

		
		
		int[][] pascal2Darray = new int[arraySize][arraySize];
		for (int i = 0; i < arraySize; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == j) {
					pascal2Darray[i][j] = 1;
					System.out.print("1 ");
				}
				else {
					//main logic
					pascal2Darray[i][j] = pascal2Darray[i-1][j] + pascal2Darray[i-1][j-1];
					System.out.print(pascal2Darray[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
}
