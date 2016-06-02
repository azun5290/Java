package other;

/* 
 * Implementation of base-pair maximising algorithm to predict
 * RNA secondary structure. 
 * 
 * Input: 	Filename and path as a single argument. File contains
 * 			RNA sequence of ONLY a, u, g, c, space, cr and line break
 *			characters.
 * Output:	The sequence in three columns: index, base at index, base 
 *			paired with base at index. -1 denotes unpaired base.
 *			Default prints to System.out. 
 *
 * Author: Sebastian Dunn, 2013.
 */

import java.io.*;
import java.util.ArrayList;
import java.lang.Math;

public class RNAFolder {
	int num_bases;
	ArrayList<Character> char_input = new ArrayList<Character>();
	int[][] optimals;
	int[][][] backtrack;
	int[] pairings;


	/**
	 * Constructor saves the generated array list and initialises the other
	 * arrays based on its size. Arrays are automatically initialised to 0
	 * but pairings is manually initialised to -1. This is because -1 flags 
	 * no pairing at that index; 0 would flag a pairing to base 0. 
	 */
	public RNAFolder(ArrayList<Character> input) {
		System.out.println("Building object...");
		char_input = input;
		num_bases = char_input.size();
		optimals = new int[num_bases][num_bases];
		backtrack = new int[num_bases][num_bases][2];
		pairings = new int[num_bases];
		for (int p = 0; p < num_bases; p++) {
			pairings[p] = -1;
		}
		System.out.println("Object built.");
	}

	/**
	 * Function to fill the optimal values array. Loop has to fill the diagonals
	 * towards the right and top to ensure smaller nested loops are calculated 
	 * before larger structures are calculated. Hence crazy loop conditions.
	 */
	public void fillOptimals() {
		System.out.println("Calculating optimals...");
		for (int diff = 1; diff < num_bases; diff++) {
			//System.out.println(diff);
			for (int n = diff; n < num_bases; n++) {
				//System.out.println(n + " " + (n-diff));
				optimals[n][n-diff] = calculateOptimal(n, (n-diff));
			}
		}
		System.out.println("Optimals calculated.");
	}

	/**
	 * Calculates the optimal value at j,i. Computes the values if i and j don't pair,
	 * then checks to see if they can pair, then checks all the possible bifurcation
	 * values. Returns the max of all of these.
	 */
	private int calculateOptimal(int j, int i) {
		int iUnpaired = optimals[j][i+1];
		int jUnpaired = optimals[j-1][i];
		int ijPaired = -1; //set to -1 so it is never picked unless paired

		//minimum loop size allowed is 3. Also stops side by side pairings
		if (Math.abs(j-i) > 3 && areComplementary(j, i)) {
			ijPaired = optimals[j-1][i+1] + 1; }
		
		int bifurcation = -1;
		int k_tmp = -1;
		for (int k = i+1; k < j; k++) {
			int tmp = optimals[k][i] + optimals[j][k+1];
			if (tmp > bifurcation){
				bifurcation = tmp;
				k_tmp = k;
			}
		}

		int totalMax = Math.max(Math.max(iUnpaired, jUnpaired), Math.max(ijPaired, bifurcation));

		/* Records which value was as optimal, for backtracking. Preferences
		 * are made in this order for identical scores so that simpler
		 * structures are favoured over more constrained/bifurcated ones */
		if (totalMax == iUnpaired) { backtrack[j][i][0] = 1; }
		else if (totalMax == jUnpaired) { backtrack[j][i][0] = 2; }
		else if (totalMax == ijPaired) { backtrack[j][i][0] = 3; }
		else if (totalMax == bifurcation) { backtrack[j][i][0] = 4;
											backtrack[j][i][1] = k_tmp; }

		return totalMax;
	}

	/**
	 * Checks if two positions in the RNA strand correspond to complementary bases.
	 * This implementation does not cover the non-Watson-Crick base pairings now 
	 * accepted to be in some RNA secondary structures.
	 */
	private boolean areComplementary(int j, int i) {
		char base_j = char_input.get(j);
		char base_i = char_input.get(i);
		if ((base_j == 'a' && base_i == 'u') ||
			(base_j == 'u' && base_i == 'a') ||
			(base_j == 'g' && base_i == 'c') ||
			(base_j == 'c' && base_i == 'g')) {
			return true;
		}
		else { return false; }
	}

	/**
	 * Calls recursive method to fill in the pairings array, 
	 * then prints out the results.
	 */
	private void calculatePairings() {
		System.out.println("Calculating pairings...");
		recursiveCalculatePairings(num_bases - 1, 0);
		printResult(pairings);
	}

	/**
	 * Method to track through the backtrack array and work out the optimal
	 * base pairings found. Uses the direction flags saved in backtrack in
	 * the calculatePairings function. The pairings array stores which base
	 * is paired with the base at that position, or -1 if that base was 
	 * unpaired.
	 * Base case: 	direction is 0. This cell was not calculated from any other
	 * 				cells in the array.
	 * Flag = 1:	This corresponds to base [i] being unpaired and the score
	 *				was copied from [j][i+1]. Do that cell next.
	 * Flag = 2:	base [j] unpaired. Do [j-1][i] next.
	 * Flag = 3:	Base [i] was paired with [j]. Set their pairings to each
	 *				other and calculate [j-1][i+1] next.
	 * Flag = 4:	The optimal score for this cell was a bifurcation: both
	 *				i and j were paired but with different bases. This score 
	 *				happened with a bifurcation around point k, stored in the
	 *				third dimension of the array (backtrack[j][i][1]). Therefore
	 *				just calculate pairings from both [k][i] and [j][k+1] now.
	 *				The pairings to both i and j will be calculated as part of
	 *				these two new function calls.
	 */
	private void recursiveCalculatePairings(int j, int i) {
		if (backtrack[j][i][0] == 0) { return; }
		switch (backtrack[j][i][0]) {
			case 1:	pairings[i] = -1;
					recursiveCalculatePairings(j, i+1);
					break;
			case 2:	pairings[j] = -1;
					recursiveCalculatePairings(j-1, i);
					break;
			case 3: pairings[i] = j;
					pairings[j] = i;
					recursiveCalculatePairings(j-1, i+1);
					break;
			case 4:	recursiveCalculatePairings(backtrack[j][i][1], i);
					recursiveCalculatePairings(j, backtrack[j][i][1]+1);
					break;
		}
	}

	/**
	 * Prints the final result of the algorithm as a set of pairings.
	 */
	private void printResult(int[] pairings) {
		System.out.println("#\tBase\tPaired to");
		for (int i = 0; i < num_bases; i++) {
			System.out.println(i + "\t" + char_input.get(i) + "\t" + pairings[i]);
		}
	}


	/**
	 * Method to print the optimals array for debugging purposes.
	 */
	public void printOptimals() {
		for (int y = 0; y < num_bases; y++) {
			for (int x = 0; x < num_bases; x++) {
				System.out.print(optimals[x][y] + " ");
			}
			System.out.println();
		}
		System.out.println(optimals[num_bases-1][0]);
	}

	/**
	 * Method to print the backtrack array for debugging purposes.
	 */
	public void printBacktrack() {
		for (int y = 0; y < num_bases; y++) {
			for (int x = 0; x < num_bases; x++) {
				System.out.print(backtrack[x][y][0] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
			File data_file = new File(args[0]);
			RNAFolder folder = new RNAFolder(readFile(data_file));
			folder.fillOptimals();
			folder.calculatePairings();
			//folder.printBacktrack();
			//folder.printOptimals();
	}

	/**
	 * Take an open file and reads the data input into an array list.
	 * Returns the array list for main to create RNAFolder object.
	 */
	private static ArrayList<Character> readFile(File data_file){
		System.out.println("Reading input...");
		ArrayList<Character> input = new ArrayList<Character>();
		try {
			InputStream in = new FileInputStream(data_file);
			//Using a buffered reader because this could get BIG
			Reader buffered = new BufferedReader(new InputStreamReader(in));
			int next;

			//Reader will return -1 at end of input
			while ((next = buffered.read()) != -1){
				//Skip line breaks and spaces in case they're there
				if (next == 10 || next == 13 || next == 32) { continue; }

				//Check all data is augc
				if (next != 97 && next != 99 && next != 103 && next != 117) {
					buffered.close();
					in.close();
					throw new Exception("This isn't RNA!");
				}
				input.add((char) next);
				//System.out.println(next + " " + (char) next);
			}
			buffered.close();
			in.close();
		} catch (IOException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} catch (Exception e) {
			//If input wasn't RNA we should exit whole program
			System.out.println(e.getMessage());
			System.out.println("Exiting program now.");
			System.exit(0);
		}
		System.out.println("Input read.");
		return input;
	}
}
