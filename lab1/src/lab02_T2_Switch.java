

public class lab02_T2_Switch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int digit=Integer.parseInt(args[0]);
		switch (digit) 
		{ 
		case 1: System.out.print("cola is served"); break; 
		case 2: System.out.print("lemonade is served"); break; 
		case 3: System.out.print("orange is served"); break; 
		case 4: System.out.print("out of drinks!!!"); break; 
		case 5: System.out.print("out of drinks!!!"); break; 
		case 6: System.out.print("cola and lemonade are served"); break; 
		case 7: System.out.print("out of drinks!!!"); break; 
		case 8: System.out.print("out of drinks!!!"); break; 
		case 9: System.out.print("out of drinks!!!"); break; 
		default: System.out.print("error"); break; 
		} 
	}

}
