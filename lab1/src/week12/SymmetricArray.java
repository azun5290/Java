package week12;

import java.io.DataInputStream;   // to load DataInputStream class      

public class SymmetricArray {

	@SuppressWarnings("deprecation")
	public static void main(String args[ ])
	{
		int i, j, flag = 0;
		int matrix[][]= new int[3][3];
		DataInputStream in = new DataInputStream(System.in); 

		try
		{
			System.out.println(" Input 3 * 3 matrix  elements : ");
			for (i=0;i<3;i++)
				for(j=0;j<3;j++)
					matrix[i][j]= Integer.parseInt(in.readLine());
		}
		catch(Exception e) {  System.out.println("I/O Error");   }

		System.out.println(" Matrix is : ");
		for (i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
				System.out.print(" "+matrix[i][j]+" ");
			System.out.println();
		}

		for (i=0;i<3;i++)
			for(j=0;j<3;j++)
				if (matrix[i][j] != matrix[j][i])
					flag = 1;

		if (flag == 1)
			System.out.println(" Matrix is not symmetric");
		else
			System.out.println(" Matrix is symmetric");
	}
}
