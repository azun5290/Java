package refresh_W4;
import java.util.*;
public class ArrayTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] Integer_Array = new int [10];

		Scanner scn = new Scanner (System.in);
		//String[] StrArray = new String[]{"un","due","tre","quattro","cinque"};
		int digit=Integer.parseInt(args[0]);
		
		String label =scn.next();
		switch (label){

		case label:
		System.out.println("Array is initialized with for loop...");
		for (int i=0;i<10;i++){
			Integer_Array[i] =i+1;
		}
		for (int i=0;i<Integer_Array.length;i++){
			System.out.print(Integer_Array[i]+"\t");
		}
		break;
		
		case due:
		System.out.println("\r"+"Another Array example is for student marks where initialization happens at dec. Then some math is performed:");

		double[] stuMarks = {65,34,73,58,87};
		System.out.println("Students' marks \n"+ Arrays.toString(stuMarks));
		ArrayLib al = new ArrayLib(); // create a new ArrayLib object from its class for use of its methods

		System.out.println("Average is "+ al.getAve(stuMarks)+"\t"+"**  Max value is "+ al.findMax(stuMarks)+ "\t"+"**  Index Of Max value.."+ al.findMax(stuMarks));
		System.out.println("#########################");
		System.out.println("Reverse elements");
		System.out.println(al.reverse(stuMarks)+"\n"+Arrays.toString(stuMarks)+"\n");
		System.out.println("Or printed with my own method al.printer...etc.");
		al.printer(stuMarks);
		System.out.println("\n#########################");
		System.out.println("Find values");
		
		}

		// END SWITCH

		double tobef = 34.0;
		for (int i=0;i<stuMarks.length;i++){
			if (tobef==stuMarks[i]){
				System.out.println("Found value: "+stuMarks[i]);		
				break;
			}
		}
		System.out.println("#########################");
		double[] ArrToPrint =  al.selectionSort(stuMarks, stuMarks.length);
		System.out.println("Insertion Sort"+"\r"+Arrays.toString(ArrToPrint));
	}
}
