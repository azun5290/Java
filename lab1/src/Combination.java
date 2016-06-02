public class Combination {

	
	public static void main(String[] args){
		
		// Object[] elements = new Object[] {'A','B','C','D','E', 'F', 'G', 'H','J'};
		 
		// ozlotto
		// most freq int[] elements = {2,7,13,19,25,28,29,33,35,40};
		// MU int[] elements = {9,10,11,13,30,31,38,42,29,45};
		
		// different reasoning and points 1,2, 3, 6, 15, 25, 27, 29, 40 - then change 25=16=17
		
		int[] elements = {1, 2, 3, 6, 15, 25, 27, 29, 40};		
		
		// saturday lotto
		// most freq int[] elements = {1,5,7,8,11,23,25,40}; with 8 & 23 as *
		// + there are 12, 18, 22, 33, 36

		// 1
//		int[] elements = {1,5,7,8,11,12,18,23,25,40};
		// 2
		// int[] elements = {1,5,7,11,18,22,25,33,36,40};
		
		combination(elements,7);
	}
	
	
	public static void combination(int[]  elements, int K){

		// get the length of the array
		// e.g. for {'A','B','C','D'} => N = 4 
		int N = elements.length;
		
		if(K > N){
			System.out.println("Invalid input, K > N");
			return;
		}
		// calculate the possible combinations
		// e.g. c(4,2)
		c(N,K);
		
		// get the combination by index 
		// e.g. 01 --> AB , 23 --> CD
		int combination[] = new int[K];
		
		// position of current index
		//  if (r = 1)				r*
		//	index ==>		0	|	1	|	2
		//	element ==>		A	|	B	|	C
		int r = 0;		
		int index = 0;
		
		while(r >= 0){
			// possible indexes for 1st position "r=0" are "0,1,2" --> "A,B,C"
			// possible indexes for 2nd position "r=1" are "1,2,3" --> "B,C,D"
			
			// for r = 0 ==> index < (4+ (0 - 2)) = 2
			if(index <= (N + (r - K))){
					combination[r] = index;
					
				// if we are at the last position print and increase the index
				if(r == K-1){

					//do something with the combination e.g. add to list or print
					print(combination, elements);
					index++;				
				}
				else{
					// select index for next position
					index = combination[r]+1;
					r++;										
				}
			}
			else{
				r--;
				if(r > 0)
					index = combination[r]+1;
				else
					index = combination[0]+1;	
			}			
		}
	}
	

	
	public static int c(int n, int r){
		int nf=fact(n);
		int rf=fact(r);
		int nrf=fact(n-r);
		int npr=nf/nrf;
		int ncr=npr/rf; 
		
		System.out.println("C("+n+","+r+") = "+ ncr);

		return ncr;
	}
	
	public static int fact(int n)
	{
		if(n == 0)
			return 1;
		else
			return n * fact(n-1);
	}
	

	public static void print(int[] combination, int[] elements){

		String output = "";
		for(int z = 0 ; z < combination.length;z++){
			output += elements[combination[z]]+" ";
		}
		System.out.println(output);
	}
}