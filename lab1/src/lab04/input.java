package lab04;

import java.util.Scanner;

public class input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("Please enter the size of the array: ");
		int arraySize = scn.nextInt();
		if (arraySize < 1) {
			System.out.print("Please enter a size greater or equals to 1");
		}
		Scanner StrScan = new Scanner(System.in);
		String[] StrArray = new String[arraySize];
		// Scanner intscn = new Scanner(System.in);
		int i = 0;
		for (i = 0; i < arraySize; i++) {
			StrArray[i] = StrScan.next();
			System.out.println(StrArray[i]);
		}

		System.out.println("New input plese...");
		Scanner newScan = new Scanner(System.in);
		String input = newScan.next();

		for (String e : StrArray) {
			// int match = newScan.nextInt();
			if (input.equals(e)) {
				System.out.println("We have a match !! it's: " + e);
				break;
			}
			else System.out.println("NOPE");
		}

	}
	
	
}
