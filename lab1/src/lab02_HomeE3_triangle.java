
public class lab02_HomeE3_triangle {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int num = Integer.parseInt(args[0]);
		System.out.println("Hello, the value currently stored in Run Configs is: "+num);
		for(int i=1;i<=num;i++)
		{
			for(int j=1;j<=num-j;j++)
				System.out.print(" ");
			for(int j=1;j<=i;j++)
				System.out.print(j);
			System.out.println();
		}
	}
}


