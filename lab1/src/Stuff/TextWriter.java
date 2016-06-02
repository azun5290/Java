package Stuff;

import java.io.*;
import java.util.*;

public class TextWriter {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner (System.in);
		try {
			
			File FileOut = new File (args[0]+".txt");
			@SuppressWarnings("resource")
			PrintWriter output = new PrintWriter(FileOut);

			while (scn.hasNextInt()){
				output.printf("%d",scn.nextInt());
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
