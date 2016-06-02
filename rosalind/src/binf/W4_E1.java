package binf;

import java.util.ArrayList;
import java.util.Collections;

public class W4_E1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> list = new ArrayList<Integer>();

		int[] x = new int[] { 0, 5, 6, 10 };
		
		for (int i = 0; i < x.length; i++) {
			for (int j = i + 1; j < x.length; j++) {
				list.add(x[j] - x[i]);
				// System.out.println(x[j]-x[i]);
			}
		}
		Collections.sort(list);
		System.out.println(list);
		
	}

}
