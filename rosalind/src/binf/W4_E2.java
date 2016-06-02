package binf;

import java.util.ArrayList;
import java.util.Collections;

public class W4_E2 {

	/**
	 * @param <lenghts>
	 * @param args
	 */

/*	public static class multiset {
		private int max_element;
		private int[] elements;

		public multiset() {
			max_element = 0;
			elements = new int[] {};
		}

		public void setMax_element(int max_element) {
			this.max_element = max_element;

		}

		public int getMax_element(int[] zeroArr) {

			int max = 0;
			for (int i = 0; i < zeroArr.length; i++) {
				if (zeroArr[i] > zeroArr[max]) {
					max = i;
				}
			}
			return max;
		}
	}*/

	public static int getMax_element(int[] zeroArr) {

		int max = 0;
		for (int i = 0; i < zeroArr.length; i++) {
			if (zeroArr[i] > zeroArr[max]) {
				max = i;
			}
		}
		return max;
	}

	public static int[] partial_digest(int[] deltas, int[] positions,
			int max_pos) {

		int[] results = new int[5];
		//deltas = new int[] { 2, 2, 3, 3, 4, 5, 6, 7, 8, 10 };
		// multiset deltoids = new multiset(2, 2, 3, 3, 4, 5, 6, 7, 8, 10);

		/* Find Max */
		/*
		 * int max =0; for (int i=0;i<deltas.length;i++){ if
		 * (deltas[i]>deltas[max]){ max=i; } } //return max;
		 */System.out.println("this is max fragment HHHHHHHHHHHHHHH: "
				+ getMax_element(deltas));

		return results;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// PartialDigest(L):
		// width <- Maximum element in L

		//partial_digest (int[]{2, 2, 3, 3, 4, 5, 6, 7, 8, 10 },int[]{1,10},5);

		int[] L = new int[] { 2, 2, 3, 3, 4, 5, 6, 7, 8, 10 };
		int [] P = new int [] {};
		
		partial_digest (L,P,5);
		
		ArrayList<Integer> data = new ArrayList<Integer>();
		ArrayList<Integer> lenghts = new ArrayList<Integer>();
		/* Find Max */
		int max = 0;
		for (int i = 0; i < L.length; i++) {
			if (L[i] > L[max]) {
				max = i;
			}
		}
		int w = L[max]; // current max value
		int tmp = w;
		System.out.println("this is max fragment: " + w);

		for (int i = 0; i < L.length; i++) {
			data.add(L[i]);
		}

		Collections.sort(data);
		System.out.println("this is my set of cut locations:  " + data);
		data.remove(max);

		int y = w - tmp;
		System.out.println("this is y:  " + y);
		lenghts.add(y, w);
		System.out
				.println("this is my set of cut locations after removing longest element:  "
						+ data);
		System.out.println("this is the array I'm building to store lenghts:  "
				+ lenghts);

		if (data.isEmpty()) {
			System.out.println("maramao");
		} else {
			System.out.println("no-nee");
			System.out.println(w);

			for (int i = 0; i < L.length; i++) {
				if (L[i] > L[max]) {
					max = i;
				}
			}
			// int w = x[max]; // current max value

		}

		/*
		 * place (data,lenghts){
		 * 
		 * }
		 * 
		 * public static ArrayList <lenghts> place(L,X) {
		 */
		/*
		 * 
		 * PLACE(L, X) if L is empty output X return y <- maximum element in L
		 * Delete(y,L) if D(y, X ) L Add y to X and remove lengths D(y, X) from
		 * L PLACE(L,X ) Remove y from X and add lengths D(y, X) to L if
		 * D(width-y, X ) L Add width-y to X and remove lengths D(width-y, X)
		 * from L PLACE(L,X ) Remove width-y from X and add lengths D(width-y, X
		 * ) to L return
		 */

	}

	/*
	 * private static ArrayList<data> place(ArrayList<Integer> data,
	 * ArrayList<Integer> lenghts) {
	 * 
	 * 
	 * // TODO Auto-generated method stub if (data.isEmpty()){
	 * Collections.sort(lenghts); System.out.println(lenghts);
	 */// y <- maximum element in L
		// Delete(y,L)

	/*
	 * if (){ if D(y, X ) L Add y to X and remove lengths D(y, X) from L
	 * PLACE(L,X ) Remove y from X and add lengths D(y, X) to L }
	 */
}
