
public class lab02_LabE2_grades {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = Integer.parseInt(args[0]);
		System.out.println("The grade value currently stored in Run Configs is: "+num);
		if (num >= 85 && num <100){ 
			System.out.println("HD");}
		else if (num >= 75 && num <=84) {
			System.out.println("D");}
		else if (num >= 65 && num <=74) {
			System.out.println("C");}
		else if (num >= 50 && num <=64) {
			System.out.println("P");}
		else{
			System.out.println("F");
		}

	}
}
