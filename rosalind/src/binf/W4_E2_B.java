package binf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class W4_E2_B {

	/**
	 * @param args
	 * 
	 * 
	 *            PartialDigest (L) 
	 *            1 width �? Maximum element in L 
	 *            2 DELETE
	 *            (width, L) 
	 *            3 X �? {0, width} 
	 *            4 PLACE (L, X)
	 * 
	 *            PLACE (L, X) 
	 *            1 if L is empty 
	 *            2 output X 
	 *            3 return 
	 *            4 y �? Maximum element in L 
	 *            5 if ∆(y, X) ⊆L 
	 *            6 Add y to X and remove lengths ∆(y , X ) from L 
	 *            7 PLACE (L, X) 
	 *            8 Remove y from X and add lengths ∆(y, X) to L 
	 *            9 if ∆(width −y, X) ⊆L 
	 *            10 Add width −y to X and remove lengths ∆(width−y, X) from L 
	 *            11 PLACE (L, X) 
	 *            12 Remove width −y from X and add lengths ∆(width−y, X) to L 
	 *            13 return
	 * 
	 * 
	 */

	public static void PartialDigest(int[] L) {

		int max = 0;
		int width = max;

		// function delete width from L
		//L = L - width;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> L_list = new ArrayList<Integer>();
		ArrayList<Integer> X_list = new ArrayList<Integer>();
		
		int[] L = new int[] { 2, 2, 3, 3, 4, 5, 6, 7, 8, 10 };
		int max = 0;
		int width = 0;
		int r= 2;
		int n = L.length/2;
		System.out.println(L.length);
/*		int factN = fact(n);
		int factR = fact(r);
		int sub = n-r;
		int facSub = fact(sub);*/
		//int LenToFind = factN/(factR*facSub);
		
		int LenToFind = fact(n)/(((fact(r))*(fact(n-r))))/2;
		System.out.println(LenToFind);
		int[] X = new int[LenToFind];
		// fill in L_list
		for (int i = 0; i < L.length; i++) {
			L_list.add(L[i]);
		}

		// fill in X_list
		/*
		 * for (int i = 0; i < L.length; i++) { X_list.add(X[i]);
		 * 
		 * }
		 */

		if (L.length == 0) {
			Collections.sort(X_list);
			System.out.println(X_list);
			return;
		}

		// ArrayList<Integer> data = new ArrayList<Integer>();
		// ArrayList<Integer> lenghts = new ArrayList<Integer>();

		// pdigest(L)

		for (int i = 0; i < L.length; i++) {
			if (L[i] > L[max]) {
				max = i;
			}
		}

		width = L[max];
		System.out.println("NOW L has:");

		Collections.sort(L_list);
		System.out.println(L_list);

		L = (int[]) ArrayUtils.removeElement(L, width);
		//L_list.remove(L_list.get(width));
		
		System.out.println("And NOW L has:");
		for (int i = 0; i < L.length; i++){
			System.out.println(L[i]);
			}
/*		Collections.sort(L_list);
		System.out.println(L_list.remove(L_list.get(width)));*/

		X[0] = 0;
		X[4] = width;

		System.out.println("NOW X has:");
		// fill in X_list
		
		  for (int i = 0; i < X.length; i++) { X_list.add(X[i]);
		  
		  }
		 
		Collections.sort(X_list);
		System.out.println(X_list);
		//System.out.println(X[0]);
		//System.out.println(X[4]);

		// place(L,X)

	}

	private static int fact(int x) {
		// TODO Auto-generated method stub
		if (x<=1)return 1;
		else return x*fact(x-1);	
	
	}
}
