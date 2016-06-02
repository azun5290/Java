import java.util.Scanner;

public class hi {
	public static void main(String[] args) { System.out.println("Some recursive math");
	//int num = Integer.parseInt(args[0]);

	Scanner read = new Scanner (System.in);
	System.out.println("Enter a number to get its factorial");
	int num = read.nextInt();
	System.out.println(factorial(num));
	System.out.println("**********************************************************************");

	System.out.println("Enter a number to get its H function");
	int num2 = read.nextInt();
	System.out.println(H(num2));
	System.out.println("**********************************************************************");
	
	System.out.println("Enter a number to get its H function - MY SYSTEM!!!!!!!!!!");
	//int num2 = read.nextInt();
	System.out.println(SumFrac(num2));
	System.out.println("**********************************************************************");
	
	System.out.println("Modulus of third number");
	int num3 = read.nextInt();
	System.out.println(num3%2);
	System.out.println("**********************************************************************");
	
	System.out.println("Enter two numbers and get their gcd");
	int num4 = read.nextInt();
	int num5 = read.nextInt();
	System.out.println(gcd(num4,num5));
	System.out.println("**********************************************************************");
	
	System.out.println("Enter a number and get the 'sommatoria'");
	int num6 = read.nextInt();
	System.out.println(sum(num6));
	System.out.println("**********************************************************************");
	
	System.out.println("Enter a number and get the Fibonacci series up to that number");
	int num7 = read.nextInt();
	System.out.println(fibo(num7));
	System.out.println("**********************************************************************");
	
	}

	public static int fibo(int num7) {
		// TODO Auto-generated method stub
		if (num7 == 0) return 0;
		if (num7 == 1) return 1;
		return fibo(num7-1)+fibo(num7-2);
	}

	public static long factorial (int N) {
		if (N==1) return 1;
		return N*factorial(N-1);
	}

	public static double H (int N) {
		if (N==1) return 1;
		return H(N-1)+1.0/N;
	}

	public static double SumFrac (int N) {
		if (N==1) return 1;
		else return 1.0/N+SumFrac((N-1));
	}

	public static double gcd (int p, int q){
		if (q==0) return p;
		return gcd(q,p%q);
	}

	public static int sum (int f){
		if (f==1) return 1;
		return (f*(f+1))/2;
		//return f+sum(f-1);
	}

}