
public class lab02_LabE1_evenodd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = Integer.parseInt(args[0]);
		System.out.println("Hello, the value currently stored in Run Configs is: "+num);
		if (num % 2 == 0)
			System.out.println("This number is even");
		else	
			System.out.println("This number is odd");

	}
}


