package binf;

import java.io.File;
import java.util.Scanner;

public class DNAtoRNA {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scn = new Scanner(new File(args[0]));

			while (scn.hasNextLine()) {
				String line = scn.nextLine();
				String RNA = "";
				RNA = line.replace('T', 'U');
				System.out.print(RNA);
			}
			scn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
