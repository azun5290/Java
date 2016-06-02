package other;

public class GlobalMembersFinalSA
{
	//#include "T4Blocks.h"

	static int Main(int argc, RefObject<String[]> argv)
	{
		//start creating the blocks
		std.thread blockCreationThread = new std.thread(createTBlocks4);

		//prints the number of cores detected, useful?
		int cores =std.thread.hardware_concurrency();
		System.out.print("Cores detected: ");
		System.out.print(cores);
		System.out.print("\n");
		if(cores ==0)
			cores = 1;


		String AsequenceFile;
		String BsequenceFile;
		String alignmentFile;

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
		alignmentFile = SimulateCin.readToWhiteSpace(true);

		//join the blockCreation thread before it is needed
		blockCreationThread.join();

		//create the alignment array
		int[][] alignment;
		alignment = new int[A.length()+1];
		for(int i = 0; i < A.length()+1; i++)
			alignment[i] = new int[2];
		//the path passes through 0 0  in the DP table
		alignment[0][0] =0;
		//and A.size B.size
		alignment[A.length()][1] =B.length();

		//solve in linear space using four russians and multiple threads
		linearSpaceAlignment(A, 0, A.length(), B, 0, B.length(), alignment, cores);

		//print the alignment to the given file
		RefObject<String> TempRefObject = new RefObject<String>(A);
		RefObject<String> TempRefObject2 = new RefObject<String>(B);
		printAlignment(TempRefObject, TempRefObject2, alignment, alignmentFile);
		A = TempRefObject.argvalue;
		B = TempRefObject2.argvalue;

		//free the alignment from the heap
		for(int i = 0; i < A.length()+1; i++)
			alignment[i] = null;
		alignment = null;
		return 0;
	}

	public static int findGlobalAlignmentGivenUpper(String A, String B, RefObject<Integer> upper)
	{
		//create the array to score the bottom scores
		int lower = new int[B.length()+1];
		assert lower!=null;

		//loops through each character the in the A string working out the scores for that row of the DP table
		for(int i =0;i<A.length();++i)
		{
			//the left value is zero
			lower[0] = 0;
			//loops through each character in the B string
			for(int j =1;j<B.length()+1;++j)
			{
				//the minimum score is the max of the score above and the score to the left
				int max = (upper.argvalue[j]>lower[j-1]) ? upper.argvalue[j] : lower[j-1];
				if(A.charAt(i)==B.charAt(j-1))
				{
					//if the character in the B string and the A string are the same and the diagonal score is equal to the
					//max then the score for this square is the diagonal + 1 (this represents a matching)
					max = (upper.argvalue[j-1]+1>max) ? (upper.argvalue[j-1]+1) : max;
				}

				lower[j] = max;
			}
			//for linear memory
			//we no longer need the scores in the top row so we set the bottom row to be the new top row and we set the old top row to be the new bottom row
			int tmp = lower;
			lower = upper.argvalue;
			upper.argvalue = tmp;
		}
		lower = null;
		return upper.argvalue;
	}


	public static void findGlobalAlignment4RT4LS(String A, String B, int[][] returned)
	{
		if(A.length()<4)
		{
			//if the length of A is less then 4 then theres no point using four russian blocks of 4
			int upper = new int[B.length()+1];
			assert upper!=null;
			//the upper scores are all 0
			for(int j =0;j<B.length()+1;++j)
				upper[j] = 0;
			RefObject<Integer> TempRefObject = new RefObject<Integer>(upper);
			(*returned) = &findGlobalAlignmentGivenUpper(A, B, TempRefObject)[0];
			upper = TempRefObject.argvalue;
			return;
		}
		//the number of rows of blocks
		int aSize = (int)(0.25 A.length()+0.01);

		//the number of columns of blocks
		int bSize = (int)(0.25 B.length()+0.8);

		//convert sequence A and B into the binary representation used by blocks
		byte a = convertString4(A);
		byte b = convertString4(B);

		//create arrays for the block values
		int top = new int[bSize];
		assert top!=null;
		int bottom = new int[bSize];
		assert bottom!=null;
		//the top left block input offsets are all zero
		top[0] = blockFunctionT4(a[0],b[0],0,0);

		//the top blocks inputs are the block to the lefts right output and zero
		for(int j =1;j<bSize;++j)
		{
			top[j] = blockFunctionT4(a[0],b[j],T4[top[j-1]]>>4,0);
		}
		//calculates the body of the table
		for(int i =1;i!=aSize;++i)
		{
			//the leftmost blocks left input offset is zero
			bottom[0] = blockFunctionT4(a[i], b[0], 0, T4[top[0]]&15);

			//calculate each bloack based on the offset outputs of its left and top neighbours
			for(int j =1;j!=bSize;++j)
			{
				bottom[j] = blockFunctionT4(a[i], b[j], T4[bottom[j-1]]>>4, T4[top[j]]&15);
			}

			//for linear memory we switch the arrays because we no longer need the values in the old top array
			int tmp = bottom;
			bottom = top;
			top = tmp;
		}
		//this array holds the bottom values that were calculated using the blocks
		int upper = new int[B.length()+1];
		assert upper!=null;
		upper[0] = 0;

		//loops through the bottom row
		for(int j =0;j!=B.length();++j)
		{
			//calculates which value in which block corrosponds to this particular square
			int block = 0.25 *j+0.1;
			int val = j-block *4;

			//calculates the score using the input of the last block and adding it to the value of the square to the left
			//because the blocks only hold offset values
			upper[j+1] = (((T4[top[block]]&15)>>(3-val))&1) + upper[j];
		}

		//free the memory that has been alocated on the heap
		top = null;
		bottom = null;
		(a) = null;
		(b) = null;
		//the string that corrosponds to the last part of the sequence
		String endString = A.substring(aSize *4);
		//calculates the bottom score
		RefObject<Integer> TempRefObject2 = new RefObject<Integer>(upper);
		(*returned) = &findGlobalAlignmentGivenUpper(endString, B, TempRefObject2)[0];
		upper = TempRefObject2.argvalue;
		return;
	}

	public static int bottomGivenLeftAndUpper(String A, String B, int left, int top)
	{
		//create an array to hold the upper scores and populate it with the scores from top
		int upper = new int[B.length()+1];
		for(int i =0;i<B.length()+1;++i)
		{
			upper[i] = top[i];
		}
		//create an array to hold the lower scores
		int lower = new int[B.length()+1];
		assert lower!=null;

		//loops through row finding the score using the row above
		for(int i =0;i<A.length();++i)
		{
			//the first value is the corrosponding left value
			lower[0] = left[i+1];

			//calculates the score for this value of A and B
			for(int j =1;j<B.length()+1;++j)
			{
				//the minimum max value is the max of the score to the left and the score above
				int max = (upper[j]>lower[j-1]) ? upper[j] : lower[j-1];

				//if the A and B character are the same then if the upper left score is larger than max it is the new max
				if(A.charAt(i)==B.charAt(j-1))
				{
					max = (upper[j-1]+1>max) ? (upper[j-1]+1) : max;
				}

				//the score of the square is equal to max
				lower[j] = max;
			}

			//switch the arrays
			int tmp = lower;
			lower = upper;
			upper = tmp;
		}
		//delete the array we aren't returning
		lower = null;
		return upper;
	}

	public static byte convertBlockFriendly(int input, int length)
	{
		//creates an array to store the block input scores, because the blocksize is 4 this is 4th as long
		//the additional space is present as padding
		byte blockFriendly = new byte[(length>>2)+1];

		//runs through the input array adding the offset values to the block input array 
		int i =1;
		for(;i+3<length;i+=4)
		{
			//the input is stored as 4 bits, one for if each offset has increased
			blockFriendly[(i>>2)] = ((input[i]-input[i-1])<<3)+((input[i+1]-input[i])<<2)+((input[i+2]-input[i+1])<<1)+(input[i+3]-input[i+2]);
		}

		//filling out the final block we can't be sure we have enough inputs to fill this one so each bit is done seperatly with a check
		blockFriendly[i>>2] = 0;
		if(i<length)
		{
			blockFriendly[i>>2] += (input[i]-input[i-1])<<3;
		}
		if(i+1<length)
		{
			blockFriendly[i>>2] += (input[i+1]-input[i])<<2;
		}
		if(i+2<length)
		{
			blockFriendly[i>>2] += (input[i+2]-input[i+1])<<1;
		}
		return blockFriendly;
	}


	public static void threadedSubProblem(String A, String B, RefObject<Integer> leftInput, RefObject<Integer> topInput, int[][] bottomReturn, int[][] rightReturn)
	{

		if(A.length()<4)
		{
			(*bottomReturn) = &bottomGivenLeftAndUpper(A, B, leftInput.argvalue, topInput.argvalue)[0];
			//this works because the problem is symetric around the diagonal
			(*rightReturn) = &bottomGivenLeftAndUpper(B, A, topInput.argvalue, leftInput.argvalue)[0];
			leftInput.argvalue = null;
			topInput.argvalue = null;
			return;
		}

		byte leftB = convertBlockFriendly(leftInput.argvalue, A.length()+1);
		byte topB = convertBlockFriendly(topInput.argvalue, B.length()+1);
		//not arbritrary, the size is such that there are always enough blocks to entirely contain the strings
		int aSize = (int)(0.25 A.length()+0.8);
		int bSize = (int)(0.25 B.length()+0.8);

		//the array of blocks on the right, used to calculate the right output of this subProblem
		int rightBlocks = new int[aSize];

		//convert the strings to block friendly input
		byte a = convertString4(A);
		byte b = convertString4(B);

		//arrays to hold the top and bottom scores, they are just the two adjascent arrays used for linear space
		int top = new int[bSize];
		assert top!=null;
		int bottom = new int[bSize];
		assert bottom!=null;
		//the top left corner is calculated from the left and top inputs
		top[0] = blockFunctionT4(a[0],b[0],leftB[0],topB[0]);

		//loop through the top row using the inputs from the left and the top input
		for(int j =1;j<bSize;++j)
		{
			top[j] = blockFunctionT4(a[0],b[j],T4[top[j-1]]>>4,topB[j]);
		}
		//set the right block for this row to be the block at the end of the array
		rightBlocks[0] = top[bSize-1];

		//loop through the array calculating the blocks used as normal
		for(int i =1;i!=aSize;++i)
		{
			bottom[0] = blockFunctionT4(a[i], b[0], leftB[i], T4[top[0]]&15);

			for(int j =1;j!=bSize;++j)
			{
				bottom[j] = blockFunctionT4(a[i], b[j], T4[bottom[j-1]]>>4, T4[top[j]]&15);
			}
			//set the right block as the last block on the array
			rightBlocks[i] = bottom[bSize-1];

			//switch the arrays
			int tmp = bottom;
			bottom = top;
			top = tmp;
		}

		//calculate the right output scores
		//an array to store the output scores
		int rightScores = new int[A.length()+1];
		assert rightScores!=null;

		//the first score is the one corrosponding to the last block
		rightScores[0] = topInput.argvalue[4*(bSize-1)];
		for(int i =0;i!=A.length();++i)
		{
			//calculate the block and where the value is stored
			int block = i>>2;
			int val = i-(block<<2);
			//store that value in the right scores array, the anding and bitshifting is just to isolate
			//the bit that corrosponds to this offset and give it the right magnitude
			rightScores[i+1] = ((rightBlocks[block]>>(7-val))&1) + rightScores[i];
		}
		//the string that corrosponds to the last part of the sequence, the part that wasn't dealt with be the blocks
		String endBstring = B.substring((bSize-1)*4);

		//find the right return values and set the array pointed to by rightReturn to this array
		//top input and right scores are unaffected by this function
		(*rightReturn) = &bottomGivenLeftAndUpper(endBstring, A, topInput.argvalue[(bSize-1)*4], rightScores)[0];

		//calculate the bottom output scores
		int upper = new int[B.length()+1];
		assert upper!=null;

		//the first value is the one corrosponding to the last row dealt with by the blocks
		upper[0] = leftInput.argvalue[4*(aSize-1)];
		for(int j =0;j!=B.length();++j)
		{
			//calculate vals as usual
			int block = 0.25 *j+0.1;
			int val = j-block *4;
			//bitshifted by 4 less because these offsets are stored in the least significant 4 bits of the Byte
			upper[j+1] = ((top[block]>>(3-val))&1) + upper[j];
		}
		//the part of the A string that wasn't dealt with by the blocks
		String endString = A.substring((aSize-1)*4);

		//the bottom returned array is saved to the pointer to the array
		(*bottomReturn) = &bottomGivenLeftAndUpper(endString, B, leftInput.argvalue[(aSize-1)*4], upper)[0];

		//free everything from the heap that won't be used	
		top = null;
		bottom = null;
		(a) = null;
		(b) = null;
		leftB = null;
		topB = null;
		rightBlocks = null;
		leftInput.argvalue = null;
		topInput.argvalue = null;
		rightScores = null;
		upper = null;

		return;
	}

	public static void findGlobalAlignmentThreaded(String A, String B, int[][] returned, int useableThreads)
	{
		//if the block size is less than 4096 per thread limit the number of threads used
		if(useableThreads<<12>B.length())
		{
			useableThreads = (B.length()>>12) > 1 ? (B.length()>>12) : 1;
		}
		//creates the threads that will be used to run the subproblems
		std.thread threads = new std.thread[useableThreads];

		//the number of B sequence characters in each subproblem
		int width = B.length()/useableThreads;

		//the number of layers
		int layers = useableThreads *20;

		//the number of A sequence characters in each subproblem
		int height = A.length()/layers;

		//an array of the topScores for each subproblem
		int[][] topScores = new int[useableThreads];
		for(int i =0;i<useableThreads;++i)
		{
			//each array of topScores has enough space for the largest possible problem
			topScores[i] = new int[width+useableThreads];

			//initiate them to zero, because the top scores are all zero
			for(int j =0;j<width+useableThreads;++j)
				topScores[i][j] = 0;
		}

		//an array of the left scores for each subproblem
		int[][] leftScores = new int[layers];
		for(int i =0;i<layers;++i)
		{
			//each array of leftScores has enough space for the largest possible problem
			leftScores[i] = new int[height+layers];
			//all the left scores are zero
			for(int j =0;j<height+layers;++j)
				leftScores[i][j] = 0;
		}
		//vectors for the strings that corrospond to each sub problem
		std.vector<String> topStrings;
		std.vector<String> leftStrings;

		//the top string and the left string are split up and stored as seperate strings
		//to be used in the sub problems
		for(int i =0;i<useableThreads-1;++i)
		{
			topStrings.push_back(B.substring(width *i,width));
		}
		topStrings.push_back(B.substring(width*(useableThreads-1)));

		for(int i =0;i<layers-1;++i)
		{
			leftStrings.push_back(A.substring(height *i,height));
		}
		leftStrings.push_back(A.substring(height*(layers-1)));

		//calculate the top levels, because these are a special case because not all threads have something
		//to work on, some have to wait for the thread to the left to finish
		for(int level =0;level<useableThreads-1;++level)
		{
			for(int i = 0;i<=level;++i)
			{
				int j =level-i;
				//the inputs to each sub problem
				threads[j] = std.thread(threadedSubProblem, leftStrings.charAt(i), topStrings.charAt(j), leftScores[i], topScores[j], topScores[j], leftScores[i]);
			}
			//join all the threads created this level
			for(int j =0;j<=level;++j)
				threads[j].join();
		}

		//calculate the middle levels, each thread solves its subproblem using the 
		//top input it calculated the previous iteration and the left input its left neighbour
		//calculated the previous iteration
		for(int level =0;level<=layers-useableThreads;++level)
		{
			//creating the threads for this iteration, in a future edition change these to barriers
			//instead of new threads, it will make multiple cores work faster with small sequences
			for(int j =0;j<useableThreads;++j)
			{
				int i = level+useableThreads-1-j;
				threads[j] = std.thread(threadedSubProblem, leftStrings.charAt(i), topStrings.charAt(j), leftScores[i], topScores[j], topScores[j], leftScores[i]);
			}
			//join the threads
			for(int j =0;j<useableThreads;++j)
			{
				threads[j].join();
			}
		}
		//finsh off the last iterations, not all threads can work because some havn't got
		//anything to work on
		for(int level =1;level<useableThreads;++level)
		{
			for(int j =level;j<useableThreads;++j)
			{
				int i = layers-j+level-1;
				threads[j] = std.thread(threadedSubProblem, leftStrings.charAt(i), topStrings.charAt(j), leftScores[i], topScores[j], topScores[j], leftScores[i]);
			}
			for(int j =level;j<useableThreads;++j)
			{
				threads[j].join();
			}
		}

		//the bottomReturn array is created and populated with the bottom scores from the subproblems
		//(called top scores because they were used as top inuts for the problem below them
		int bottomReturn = new int [B.length()+1];
		for(int i =0;i<useableThreads;++i)
		{
			for(int j =0;j<width;++j)
			{
				bottomReturn[i *width+j] = topScores[i][j];
			}
		}
		//the leftover in the final problem because the sequence doesn't neatly divide into the nuumber of threads
		for(int i =0;i+width *useableThreads<B.length()+1;++i)
		{
			bottomReturn[i+width *useableThreads] =topScores[useableThreads-1][width+i];
		}

		//free everything from the heap
		threads = null;
		for(int i =0;i<useableThreads;++i)
		{
			topScores[i] = null;
		}
		topScores = null;

		for(int i =0;i<layers;++i)
		{
			leftScores[i] = null;
		}
		leftScores = null;
		(*returned) = &bottomReturn[0];
	}


	public static void linearSpaceAlignment(String A, int Abegin, int Aend, String B, int Bbegin, int Bend, int[][] alignment, int useableThreads)
	{
		//if Abegin is Aend then there is nothing left, this is the basecase return;
		if(Abegin ==Aend)
			return;
		//if Bbegin==Bend then the only possible path is straight up and down passing through Bbegin 
		if(Bbegin ==Bend)
		{
			alignment[Abegin+(Aend-Abegin)/2][1] = Bbegin;
			alignment[Abegin+1+(Aend-Abegin)/2][0] = Bbegin;
			//recurse on the each side of the path
			linearSpaceAlignment(A, Abegin, Abegin+(Aend-Abegin)/2, B, Bbegin, Bbegin, alignment, 1);
			linearSpaceAlignment(A, Abegin+(Aend-Abegin)/2+1, Aend, B, Bbegin, Bbegin, alignment, 1);
			return;
		}
		//create different substrings for each part of the problem
		String A1 = A.substring(Abegin,(Aend-Abegin)/2);
		String A2 = A.substring(Abegin+A1.length(),(Aend-Abegin-A1.length()));
		String B1 = B.substring(Bbegin,Bend-Bbegin);

		//reverse the strings for the second half of the problem because this half is to start at the end meet up with the first
		//half in the middle
		reverse(A2.begin(),A2.end());
		String B2 = B1;
		reverse(B2.begin(),B2.end());

		//the top and bottom arrays where the upper and lower half respectively store their results
		int top;
		int bottom;

		//if the program is in threaded mode,there are enough threads and the subproblem is of sufficient size then solve it with multiple threads
		if(true&&useableThreads>1&&A1.length()>1024)
		{
			//if there are just 2 threads available call one thread on each problem then join them
			if(useableThreads ==2)
			{
				std.thread topThread = new std.thread(findGlobalAlignment4RT4LS, A1, B1, top);
				std.thread bottomThread = new std.thread(findGlobalAlignment4RT4LS, A2, B2, bottom);
				topThread.join();
				bottomThread.join();
			}
			//if more threads are available then use multithreaded function to allow more use of spare cores
			else
			{
				std.thread topThread = new std.thread(findGlobalAlignmentThreaded, A1, B1, top, useableThreads/2);
				std.thread bottomThread = new std.thread(findGlobalAlignmentThreaded, A2, B2, bottom, useableThreads - useableThreads/2);
				topThread.join();
				bottomThread.join();
			}
		}
		//run on a single thread
		else
		{
			findGlobalAlignment4RT4LS(A1, B1, top);
			findGlobalAlignment4RT4LS(A2, B2, bottom);
		}

		//find the midpoint where the sum of the two scores is a maximum
		int max = bottom[B1.length()];
		int midpoint = 0;
		for(int i =1;i<B1.length()+1;++i)
		{
			if(top[i]+bottom[B1.length()-i]>=max)
			{
				max = top[i]+bottom[B1.length()-i];
				midpoint = i;
			}
		}

		//free the arrays from the heap we don't need them anymore
		top = null;
		bottom = null;

		//the global row midpoint is at midpoint + the offset
		alignment[Abegin+A1.length()][1] = midpoint+Bbegin;

		//if the midpoint is at the end of the sequence or if the characters don't match then
		//the allignment is straight through the row and it exits exactly where it came in
		if(midpoint ==B1.length() || B1.charAt(midpoint)!=A2.charAt(A2.length()-1))
			alignment[Abegin+A1.length()+1][0] = midpoint + Bbegin;
		else // otherwise there is a match in this row and it exits one along from where it came in
			alignment[Abegin+A1.length()+1][0] = midpoint + Bbegin+1;

		//if its worth the effort and there are enough spare threads then run this method on the smaller subproblems above and
		//to the left of the midpoint and below and to the right of the midpoint
		if(true&&useableThreads>1&&A1.length()>1024)
		{
			std.thread[][] topThread = new std.thread[Abegin+A1.length()][1](linearSpaceAlignment,A,Abegin,Abegin+A1.length(),B,Bbegin,alignment,alignment,useableThreads/2);
			std.thread[][] bottomThread = new std.thread[Abegin+A1.length()+1][0](linearSpaceAlignment,A,Abegin+A1.length()+1,Aend,B,alignment,Bend,alignment,useableThreads-useableThreads/2);
			topThread.join();
			bottomThread.join();
		}
		else //otherwise just call them with a single thread
		{
			linearSpaceAlignment(A, Abegin, Abegin+A1.length(), B, Bbegin, alignment[Abegin+A1.length()][1], alignment, 1);
			linearSpaceAlignment(A, Abegin+A1.length()+1, Aend, B, alignment[Abegin+A1.length()+1][0], Bend, alignment, 1);
		}
		return;
	}

	public static void createTBlocks4()
	{
		//create an array to hold the threads
		std.thread threads = new std.thread[16];
		for(int threadID =0;threadID<16;++threadID)
		{
			//create all the blocks using the 16 threads
			threads[threadID] = std.thread(createSomeTBlocks4,threadID);
		}
		//join all the threads
		for(int i =0;i<16;++i)
		{
			threads[i].join();
		}
		//free heap allocated memory
		threads = null;
	}

	public static void createSomeTBlocks4(int threadID)
	{
		//the starting index for each thread, each thread calculates about 1million blocks
		int index = threadID *64 *64 *64 *4;

		//the minnie matrix that holds the DP table for each block while its offsets are being calculated
		int[][] mm = new int[5][5];

		//the arrays that represent each input string
		byte[] sequenceA = new byte[4];
		byte[] sequenceB = new byte[4];

		//the first two characters of string A are determined by the threadID
		sequenceA[0] = threadID>>2;
		sequenceA[1] = threadID &3;

		//loops through all values of the index until it reaches where another thread begins
		for(int index = threadID *64 *64 *64 *4;index<(1+threadID)*64 *64 *64 *4;++index)
		{

			//calculate the inputs based on the index
			sequenceA[2] = (index>>18)&3;
			sequenceA[3] = (index>>16)&3;
			sequenceB[0] = (index>>14)&3;
			sequenceB[1] = (index>>12)&3;
			sequenceB[2] = (index>>10)&3;
			sequenceB[3] = (index>>8)&3;
			//fill out the minnie matrix
			mm[0][0] = 0;

			//filling out the input scores for the top and left determined from the index
			for(int i =1;i<5;++i)
			{
				//the left input scores
				mm[i][0] = mm[i-1][0]+((index>>(8-i))&1);
				//the top input scores
				mm[0][i] = mm[0][i-1]+((index>>(4-i))&1);
			}

			//calculates the outputs exactly s is done in the naive solution
			//since this is a relatively small static loop it will be unrolled by any reasonable compiler
			short max = 0;
			for(int i = 1;i!=5;++i)
			{
				for(int j =1;j!=5;++j)
				{
					max = (mm[i-1][j]>mm[i][j-1])?mm[i-1][j]:mm[i][j-1];
					if(sequenceA[i-1] ==sequenceB[j-1])
						max = (max>mm[i-1][j-1]+1)?max:mm[i-1][j-1]+1;
					mm[i][j] = max;
				}
			}

			//encoding the block by offset,read the description of this method in sequenceAlignment.hfor more information
			T4[index] = (((mm[1][4] - mm[0][4])<<3) + ((mm[2][4] - mm[1][4])<<2) + ((mm[3][4] - mm[2][4])<<1) + (mm[4][4] - mm[3][4]))<<4;
			T4[index] += ((mm[4][1] - mm[4][0])<<3) + ((mm[4][2] - mm[4][1])<<2) + ((mm[4][3] - mm[4][2])<<1) + (mm[4][4] - mm[4][3]);
		 }
	}


	public static String makeDNAString(RefObject<std.default_random_engine> generator, int length)
	{
		//just made for easy testing
		std.stringstream ss;
		//creates a random distribution of integers from 0 to 3 incusive
		std.uniform_int_distribution<Integer> distribution = new std.uniform_int_distribution(0,3);
		for(int i =0;i<length;++i)
		{
			int base = distribution( generator.argvalue);
			if(base ==0)
				ss<<'A';
			else if(base ==1)
				ss<<'T';
			else if(base ==2)
				ss<<'C';
			else
				ss<<'G';
		}
		return ss.str();
	}

	public static byte convertString4(String s)
	{

		//stores the value of the set of these four characters
		byte setOfFour =0;

		//the size is equal length four blocks required to encompass the string
		int size = (int)(0.25 s.length()+0.8);
		byte vals = new byte[size];

		//loop through the string adding in the sbit representation of each letter
		for(int i =0;i<s.length();i+=4)
		{
			if(s.charAt(i)=='A')
				setOfFour = 0;
			else if(s.charAt(i)=='T')
			{
				setOfFour = 64;
			}
			else if(s.charAt(i)=='C')
			{
				setOfFour = 128;
			}
			else
			{
				setOfFour = 192;
			}
			//checks to make sure it isn't at the end of the input string
			//if it is then pad with A's
			if(i+1>=s.length()||s.charAt(i+1)=='A')
				setOfFour += 0;
			else if(s.charAt(i+1)=='T')
			{
				setOfFour += 16;
			}
			else if(s.charAt(i+1)=='C')
			{
				setOfFour += 32;
			}
			//anything that isn't an A a T or a C is treated as a G
			else
			{
				setOfFour += 48;
			}

			if(i+2>=s.length()||s.charAt(i+2)=='A')
				setOfFour += 0;
			else if(s.charAt(i+2)=='T')
			{
				setOfFour += 4;
			}
			else if(s.charAt(i+2)=='C')
			{
				setOfFour += 8;
			}
			else
			{
				setOfFour += 12;
			}

			if(i+3>=s.length()||s.charAt(i+3)=='A')
				setOfFour += 0;
			else if(s.charAt(i+3)=='T')
			{
				setOfFour += 1;
			}
			else if(s.charAt(i+3)=='C')
			{
				setOfFour += 2;
			}
			else
			{
				setOfFour += 3;
			}
			//save the bit representation of these 4 characters to vals
			vals[(int)(0.25 *i)] = setOfFour;
		}
		return vals;
	}

	public static void printAlignment(RefObject<String> A, RefObject<String> B, int[][] alignment, String alignmentFile)
	{

		//string stream objects to hold the sequence of characters that represent the alignment
		std.stringstream Aseq;
		std.stringstream Bseq;
		std.stringstream matches;

		//the number of indels in the A sequence before the A sequence begins
		for(int i =0; i<alignment[0][1];++i)
		{
			Aseq<<"-";
			Bseq<<B.argvalue.charAt(i);
			matches<<" ";
		}
		//stores the total matches for this alignment
		int matchScore = 0;

		//loops for each row in the DP table
		for(int i =1;i<A.argvalue.length()+1;++i)
		{
			//each row corrosponds to a charcter in the A sequence
			Aseq<<A.argvalue.charAt(i-1);

			//if the alignment starts in the same column as the previous one ended then there was and indel in the B sequence
			if(alignment[i][0] ==alignment[i-1][1])
			{
				Bseq<<"-";
				matches<<" ";
			}
			//otherwise it was a match so we add in the letter corrosponding to that column and add a line showing that there was a match here
			else
			{
				Bseq<<B.argvalue.charAt(alignment[i][0]-1);
				matches<<"|";
				++matchScore;
			}
			//this is how far the path travels in this row, it is how many indels there are in the A sequence
			for(int j =alignment[i][0];j<alignment[i][1];++j)
			{
				Bseq<<B.argvalue.charAt(j);
				Aseq<<"-";
				matches<<" ";
			}
		}

		//store the strings from each string stream
		String Astring = Aseq.str();
		String Mstring = matches.str();
		String Bstring = Bseq.str();

		std.ofstream out = new std.ofstream(alignmentFile);
		//prints out the alignment in lines of length 80 so that it looks correct even when line wrapped (at more than 80 characters)
		int i = 0;
		for(;i+80<Astring.length();i+=80)
		{
			out<<Astring.substring(i,80)<<std.endl<<Mstring.substring(i,80)<<std.endl<<Bstring.substring(i,80)<<std.endl<<std.endl<<std.endl;
		}

		//prints the similarity of the sequence < 65% is less than that of random chance
		out<<Astring.substring(i)<<std.endl<<Mstring.substring(i)<<std.endl<<Bstring.substring(i)<<std.endl;
		out<<"sequences have a similarity of: "<<(float)matchScore/(float)A.argvalue.length()<<std.endl;
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
