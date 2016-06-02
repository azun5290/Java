
public class lab02_LabE3_BMI {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double BMI = Double.parseDouble(args[0]);
		System.out.println("Hello, the value currently stored in Run Configs is: "+BMI);

		if (BMI < 18.5)
		{
			System.out.println("Underweight");
		}
		else if  (BMI >= 18.5 && BMI <= 25){

			System.out.println("Normal weight");
		}

		else if  (BMI > 25 && BMI < 30){

			System.out.println("Over weight");
		}

		else {System.out.println("Obese");}
	}

}

