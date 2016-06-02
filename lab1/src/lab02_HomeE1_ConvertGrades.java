import java.io.IOException;
import java.util.Scanner;

public class lab02_HomeE1_ConvertGrades {
	/**
	 * @param args
	 * @throws IOException 
	 */
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//char tmp = (char) System.in.read(); 
		String s = sc.next();
		char p = s.charAt(0);
		switch (p) 
		{ 
		case 'h': System.out.print("85 - 100"); break; 
		case 'd': System.out.print("75 - 84"); break; 
		case 'c': System.out.print("65 -74"); break; 
		case 'p': System.out.print("50 -64!!"); break; 
		case 'f': System.out.print("0 - 49"); break; 

		default: System.out.print("error"); break; 
		} 
	}
}