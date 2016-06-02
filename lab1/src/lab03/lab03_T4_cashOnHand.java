package lab03;

public class lab03_T4_cashOnHand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] cashOnHand = new double[10]; 

		for (int i=0;i<cashOnHand.length;i++){
			cashOnHand [i] = Double.parseDouble(args[i]);
			System.out.println("$"+cashOnHand[i]);

		}

	}

}
