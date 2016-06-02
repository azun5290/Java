
public class lab02_T1_ClassSize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//reads a number from the command-line input 
		//print the output comments accordingly
		
		int classSize=Integer.parseInt(args[0]);
		System.out.println("the input " + classSize);
		if (classSize >= 150){
			System.out.println("This class is large");
		}
		else {System.out.println("This class is small");}

	}
}
