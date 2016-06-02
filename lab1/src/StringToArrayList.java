import java.util.Scanner;

public class StringToArrayList {
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

		// ArrayList<Charset> chlist = new ArrayList<Charset>();

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

		/*
		 * for (int i = 0; i < x.length; i++) { chlist.add(chArray[i]); }
		 * Collections.sort(chlist); System.out.println(chlist);
		 */

		// str2 = new StringBuffer(str).reverse().toString();

		// String revc = "";

		/*
		 * for (int i = 0; i < str.length(); i++) { char ch = str.charAt(i); int
		 * count = 0; // while (count<=1){
		 * 
		 * switch (ch) { case 'G': revc = str.replace('G', 'C'); count++; break;
		 * case 'C': revc = str.replace('C', 'G'); count++; break;
		 * 
		 * case 'A': revc = str.replace('A', 'T'); count++; break; case 'T':
		 * revc = str.replace('T', 'A'); count++; break; }
		 * 
		 * }
		 */
		// System.out.print("Reversed and Complementary DNA seq : " + revc);
	}
}
