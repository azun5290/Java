package binf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class iprb2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file = new File("iprb.txt");
		try {
			@SuppressWarnings("resource")
			Scanner intscn = new Scanner(file);
			int arraySize =3;
			int ArrSum =0;
			int mult=0;
			int k =0,m=0,n=0;
			
			int[] IntArray = new int[arraySize];
			for (int i = 0; i < arraySize; i++){
				IntArray[i] = intscn.nextInt();
				System.out.print(IntArray[i] + " ");

				ArrSum = ArrSum+ IntArray[i];
				mult = ArrSum * (ArrSum -1);
			}
			
			k = IntArray[0];
			m = IntArray[1];
			n = IntArray[2];
			
			System.out.println("Sum is " + ArrSum);
			System.out.println("Mult is " + mult);
			
			System.out.println("Sum (2) is " + (k+m+n));
			System.out.println("Mult (2) is " + (k+m+n)*(k+m+n-1));

			System.out.println("AND... "+((k*(k-1))/mult + (2*k*m)/mult + (2*k*n)/mult + (m*(m-1))/mult * 0.75 + (2*m*n)/mult * 0.5 + (n*(n-1))/mult * 0));
/*			
			Scanner scn = new Scanner(file);
			int[] Array = scn.nextInt()[3];
			while (scn.hasNextInt()){*/
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
