package binf;

public class NextLeaf {

	/**
	 * @param args
	 * @return
	 * @return
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("AAAAAAAAAAAAAAAAAAAARGGGGGGH" + NextLeaf());

	}

	public static int[] NextLeaf() { // a : the array of digits
			int[] a = new int[]{1,2,3,4};
		int k = 4;
		for (int i = 1; i < a.length; i++) {
			// L: length of the array
			if (a[i] < k) {
				// k : max digit value
				a[i] += 1;
				System.out.println(a[i]);
				//return a;
				a[i] = 1;
				}
			System.out.println(a[i]);
		}
		return a;
	}
}
