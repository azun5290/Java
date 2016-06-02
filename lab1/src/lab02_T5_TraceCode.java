
public class lab02_T5_TraceCode {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("EXAMPLE1");
		for (int i = 0; i < 5; i++) { 
			int x = 3;
			int j = x  - i; 
			if (j % 3 == 0) {
				System.out.println("i: " + i + ", j: "  + j); } 
			else {
				i++;
				} 
		}
		
		System.out.println("EXAMPLE2");
		for (int i = 0; i < 5; i++) { 
			int x = 7;
			int j = x  - i; 
			if (j % 3 == 0) {
				System.out.println("i: " + i + ", j: "  + j); } 
			else {
				i++;
				} 
		}
	}
}
