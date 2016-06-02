package other;

public class GlobalMembersNaiveSequenceAlignment
{

	public static void findGlobalAlignment(String A, String B, String outputFile)
	{

		int[][] M = new int[A.length()];
		for(int i =0;i<=A.length();++i)
		{
			M[i] = new int [B.length()+1];
			M[i][0] = 0;
		}
		for(int i =0;i<=B.length();++i)
		{
			M[0][i] = 0;
		}
		for(int i =1;i<=A.length();++i)
		{
			for(int j =1;j<=B.length();++j)
			{
				int max = (M[i-1][j]>M[i][j-1]) ? M[i-1][j] : M[i][j-1];
				if(A.charAt(i-1)==B.charAt(j-1))
				{
					max = (M[i-1][j-1]+1>max) ? (M[i-1][j-1]+1) : max;
				}
				M[i][j] = max;
			}
		}
		getSolution(A, B, M, outputFile);
		System.out.print("sequence similarity: ");
		System.out.print(M[A.length()][B.length()]/A.length());
		System.out.print("\n");
	}
	public static void getSolution(String A, String B, int[][]states, String outputFile)
	{
		//std::cout<<A<<"\n"<<B<<std::endl;
		int i = A.length();
		int j = B.length();
		boolean upLastTurn = true;
		std.stringstream rssA;
		std.stringstream rssB;
		while(i!=0&&j!=0)
		{
		   if(states[i][j-1] ==states[i-1][j])
		   {
				if(states[i][j-1]<states[i][j])
				{
					i--;
					j--;
					rssA<<A.charAt(i);
					rssB<<B.charAt(j);
				}
				else if(upLastTurn)
				{
					i--;
					rssA<<A.charAt(i);
					rssB<<'_';
				}
				else
				{
					j--;
					rssA<<'_';
					rssB<<B.charAt(j);
				}
			}
			else if(states[i][j-1]<states[i-1][j])
			{
				i--;
				rssA<<A.charAt(i);
				rssB<<'_';
				upLastTurn = true;
			}
			else
			{
				j--;
				rssA<<'_';
				rssB<<B.charAt(j);
				upLastTurn = false;
			}
		}
		for(;i>0;)
		{
			--i;
			rssA<<A.charAt(i);
			rssB<<'_';
		}
		for(;j>0;)
		{
			--j;
			rssB<<B.charAt(j);
			rssA<<'_';
		}

		String rsA = rssA.str();
		String rsB = rssB.str();

		std.stringstream ssA;
		std.stringstream ssB;
		for(int i =rsA.length()-1;i>=0;--i)
		{
			ssA<<rsA.charAt(i);
		}
		for(int i =rsB.length()-1;i>=0;--i)
		{
			ssB<<rsB.charAt(i);
		}
		String sA = ssA.str();
		String sB = ssB.str();

		std.ofstream out = new std.ofstream(outputFile);
		out<<sA<<"\n"<<sB<<std.endl;
	}

	static int Main(int argc, RefObject<String[]> argv)
	{
		String AsequenceFile;
		String BsequenceFile;
		String outputFile;

		//gets the A string
		System.out.print("Enter first sequence file location :");
		System.out.print("\n");
		AsequenceFile = SimulateCin.readToWhiteSpace(true);
		std.ifstream Afilestream = new std.ifstream(AsequenceFile);
		//creates the string using the inputstream char buffer and a matching iterator
		String A = new String((std.<Character>istreambuf_iterator(Afilestream)),(std.<Character>istreambuf_iterator()));
		//erases whitespace as determined by isspace
		A.erase(std.remove_if(A.begin(), A.end(),isspace), A.end());

		//gets the B string
		System.out.print("Enter second sequence file location :");
		System.out.print("\n");
		BsequenceFile = SimulateCin.readToWhiteSpace(true);
		std.ifstream Bfilestream = new std.ifstream(BsequenceFile);
		//creates the string using the inputstream char buffer and a matching iterator
		String B = new String((std.<Character>istreambuf_iterator(Bfilestream)),(std.<Character>istreambuf_iterator()));
		//erases whitespace as determined by isspace
		B.erase(std.remove_if(B.begin(), B.end(),isspace), B.end());

		//gets the lcation to store the solution
		System.out.print("Enter location to store alignment :");
		System.out.print("\n");
		outputFile = SimulateCin.readToWhiteSpace(true);
		findGlobalAlignment(A, B, outputFile);
		return 0;
	}
}

//----------------------------------------------------------------------------------------
//	Copyright © 2006 - 2008 Tangible Software Solutions Inc.
//
//	This class provides the ability to convert basic C++ 'cin' behavior.
//----------------------------------------------------------------------------------------
final class SimulateCin
{
	private static boolean goodlastread = false;
	static boolean lastReadWasGood()
	{
		return goodlastread;
	}

	static String readToWhiteSpace(boolean skipleadingwhitespace)
	{
		String input = "";
		char nextchar;
		if (skipleadingwhitespace)
		{
			while (Character.isWhitespace(nextchar = (char)System.in.read()))
			{
			}
			input += nextchar;
		}
		while ( ! Character.isWhitespace(nextchar = (char)System.in.read()))
		{
			input += nextchar;
		}
		goodlastread = input.length() > 0;
		return input;
	}
}
//----------------------------------------------------------------------------------------
//	Copyright © 2006 - 2008 Tangible Software Solutions Inc.
//
//	This class is used to simulate the ability to pass arguments by reference in Java.
//----------------------------------------------------------------------------------------
final class RefObject<T>
{
	T argvalue;
	RefObject(T refarg)
	{
		argvalue = refarg;
	}
}
