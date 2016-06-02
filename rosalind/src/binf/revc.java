package binf;

import java.util.Scanner;

public class revc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String str = sc.nextLine();
		str = new StringBuffer(str).reverse().toString();

		System.out.println("Reversed Seq : " + str);

		int StrLen = str.length();
		System.out.println("String's length is  " + StrLen);

		char[] chArray = new char[StrLen]; // create a char array and populate
											// it with chars from String
		for (int i = 0; i < StrLen; i++) {
			chArray[i] = str.charAt(i);
			// System.out.println(" ----------------------- " + chArray[i]);

			switch (chArray[i]) {
			case 'G':
				chArray[i] = 'C';
				break;
			case 'C':
				chArray[i] = 'G';
				break;

			case 'A':
				chArray[i] = 'T';
				break;
			case 'T':
				chArray[i] = 'A';
				break;
			}

		}

		String revc = String.valueOf(chArray);
		System.out.println(" *************************** ");
		System.out.println("Reversed and Complementary DNA seq : " + revc);
		sc.close();
	}

}
