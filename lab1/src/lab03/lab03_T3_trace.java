package lab03;

public class lab03_T3_trace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myInts = new int[6]; 
		for (int i = 0; i < myInts.length; i++) { 
		  myInts[i] = 2 * i + 1; 
		  System.out.println(myInts[i]);
		} 
		for (int i = 0; i < myInts.length; i++) { 
		  if (i % 2 == 1) { 
		    myInts[i] = 2 * myInts[i - 1];
		    System.out.println(myInts[i]);
		  } 
		}
		
	}

}
