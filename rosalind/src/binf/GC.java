package binf;

import java.io.File;
import java.util.Scanner;

public class GC {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scn = new Scanner(new File(args[0]));
			int countG = 0;
			int countC = 0;
			int countA = 0;
			int countT = 0;
			while (scn.hasNextLine()) {
				String line = scn.nextLine();

				for (int i = 0; i < line.length(); i++) {
					char ch = line.charAt(i);

					switch (ch) {
					case 'G':
						countG++;
						break;
					case 'C':
						countC++;
						break;
					case 'A':
						countA++;
						break;
					case 'T':
						countT++;
						break;
					}
				}
			}
			System.out.print(countA + " " + countC + " " + countG + " " + countT);
			scn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}