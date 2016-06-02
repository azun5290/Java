package Stuff;

import java.util.Scanner;

public class twoDimension{
	public static void main(String[] args) {
		int[][] a2 = new int[2][2];
		Scanner intscn = new Scanner(System.in);
		for (int i=0; i<a2.length; i++) {
			for (int j=0; j<a2[i].length; j++) {
				//a2[i][j] = i;
				a2 [i][j] = intscn.nextInt();
				//System.out.print(" " + a2[i][j]);
			}
			//System.out.println("");
		}

		for (int i=0; i<a2.length; i++) {
			for (int j=0; j<a2[i].length; j++) {
				//a2[i][j] = i;
				//a2 [i][j] = intscn.nextInt();
				System.out.print(" " + a2[i][j]);
			}
			System.out.println("");
		}
	}
}
