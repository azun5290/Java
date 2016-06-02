package Stuff;
import java.io.*;
import java.util.*;

public class calcAverage {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File myFile = new File (args[0]+".txt");
			Scanner scn = new Scanner (myFile);
			double sum = 0.0;
			int num = 0;
			
			while (scn.hasNextDouble()){
				sum += scn.nextDouble();
				num++;
			}
			scn.close();
			System.out.println(sum/num);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}