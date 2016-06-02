package lab03;

import java.util.Scanner;

public class lab03_LabE2_basicStat {
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
		int sum =0;
		double ave=0.0;

		int[][] numTable = new int[arraySize][arraySize];
		Scanner intscn = new Scanner(System.in);

		//first for loop is to scan in all integers - separate from loop to print

		for (int i = 0; i < arraySize; i++) {
			for (int j = 0; j < arraySize; j++) {
				numTable [i][j] = intscn.nextInt();
				//System.out.print(" "+numTable[i][j]);
				//sum += numTable [i][j] ;
			}
			//System.out.println("");	
		}

		//second for loop is to print matrix and sum 
		for (int i = 0; i < arraySize; i++) {
			for (int j = 0; j < arraySize; j++) {
				//numTable [i][j] = intscn.nextInt();
				System.out.print(" "+numTable[i][j]);
				sum += numTable [i][j] ;
			}
			System.out.println("");	
		}
		System.out.println();
		System.out.println("The array sum is: "+sum);
		ave = (double)sum / (double)arraySize / (double)arraySize;
		System.out.println("The array average is: "+ave);

		//find max
		int max = 0;
		for (int i=0;i<numTable.length;i++){
			for (int j=0;j<numTable.length;j++){
				if (numTable[i][j]>numTable[max][max]){
					max=i;
				}
			}
		}
		
		//find min
		int min = 0;
		for (int i=0;i<numTable.length;i++){
			for (int j=0;j<numTable.length;j++){
				if (numTable[i][j]<numTable[min][min]){
					min=i;
				}
			}
		}
		System.out.println("The maximum value is:\t"+numTable[max][max]);
		System.out.println("The minimum value is:\t"+numTable[min][min]);
		//find diagonal sums
		int k = 0, j = 0;
		int sum1 = 0, sum2 = 0;
		for (j = 0; j < numTable.length; j++) {
			for (k = 0; k < numTable.length; k++)
				System.out.print(numTable[j][k] + " ");
			System.out.println();
		}
		for (j = 0; j < numTable.length; j++) {
			sum1 = sum1 + numTable[j][j];
		}
		k = numTable.length - 1;
		for (j = 0; j < numTable.length; j++) {
			if (k >= 0) {
				sum2 = sum2 + numTable[j][k];
				k--;
			}
		}
		System.out.println("Sum of Digonal elements are: " + sum1 + " and " + sum2);

		// find column sums
		int columnTotal1 = 0; 

		for (int r=0; r < numTable.length; r++) { 
			columnTotal1 += numTable[r][0]; 
		} 
		System.out.println("Sum of Column elements in column 0 is: " + columnTotal1);

		int columnTotal2 = 0; 

		for (int r=0; r < numTable.length; r++) { 
			columnTotal2 += numTable[r][1]; 
		} 
		System.out.println("Sum of Column elements in column 1 is: " + columnTotal2);

		int columnTotal3 = 0; 

		for (int r=0; r < numTable.length; r++) { 
			columnTotal3 += numTable[r][2]; 
		} 
		System.out.println("Sum of Column elements in column 2 is: " + columnTotal3);

		//find rows sums

		int rowTotal1 = 0; 

		for (int c=0; c < numTable.length; c++) { 
			rowTotal1 += numTable[0][c]; 
		} 
		System.out.println("Sum of Row elements in row 0 is: " + rowTotal1);

		int rowTotal2 = 0; 

		for (int c=0; c < numTable.length; c++) { 
			rowTotal2 += numTable[1][c]; 
		} 
		System.out.println("Sum of Row elements in row 1 is: " + rowTotal2);

		int rowTotal3 = 0; 

		for (int c=0; c < numTable.length; c++) { 
			rowTotal3 += numTable[2][c]; 
		} 
		System.out.println("Sum of Row elements in row 2 is: " + rowTotal3);

	}
}

