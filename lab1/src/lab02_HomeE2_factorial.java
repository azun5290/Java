import java.util.Scanner;


public class lab02_HomeE2_factorial {

	/**
	 * @param args
	 * 
	 */
	public static long calc( int num )
	{
		if( num <= 1 )     // base case
			return 1;
		else
			return num * calc( num - 1 );
	}
	public static void main( String [ ] args )
	{
		Scanner scn = new Scanner (System.in);
		int num = scn.nextInt();
		//int num = Integer.parseInt(args[0]);
		System.out.println("The factorial of "+num+" is "+(calc(num)));
	}
}

