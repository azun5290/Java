package binf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class iprb {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			File file = new File("iprb.txt");
			Scanner scn = new Scanner(file);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			String str =buffer.readLine().trim();
			
			int[] ciao = new int[3];
			String s =scn.next();
			System.out.println(s);
			System.out.println(str);
			
			for (int i = 0; i < ciao.length; i++) {
				
				ciao[i] = Integer.parseInt(str); 
				//ciao[i] = Integer.parseInt(args[0]); 
				//ciao[i] = (int) Double.parseDouble(s);
				//ciao[i] = scn.useDelimiter(" ").toString().valueOf();
				System.out.println(ciao[i]);
				
			}
			scn.close();
			buffer.close();
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// infile = open("rosalind_iprb.txt")

		/*
		 * while (scn.hasNextInt()){
		 * 
		 * s =scn.nextLine(); Scanner line =new Scanner(s); //String cmd;
		 * 
		 * if(line.hasNext()){ }
		 */

		/*
		 * k, m, n = map(int, infile.readline().split(" ")) denom =
		 * (k+m+n)*(k+m+n-1)
		 * 
		 * print((k*(k-1))/denom + (2*k*m)/denom + (2*k*n)/denom +
		 * (m*(m-1))/denom * 0.75 + (2*m*n)/denom * 0.5 + (n*(n-1))/denom * 0)
		 * 
		 * infile.close()
		 */
	
	}
}

