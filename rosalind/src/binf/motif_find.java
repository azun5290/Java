package binf;

import java.util.ArrayList;
import java.util.Scanner;

public class motif_find {

	public static String mfind(String substring, String TargetString){
    	
    
/*        """
        Knuth-Morris-Pratt algorithm
 
        Returns a list of starting indices of the substring in the string
        """
*/ 
    if (substring == null){
    	System.out.println("String is zero length");
    }
    
/*    if len(substring) == 0:
            raise LengthMismatchError("Substring is empty")
 */
    else if (substring.length() == 1){
    	
		Scanner scn = new Scanner(System.in);
		System.out.print("Please enter a DNA sequence: ");
		String DNAseq = scn.next();
		System.out.print("Storing DNA sequence in Array of characters...");
		char[] DNAseqArray = DNAseq.toCharArray();
		System.out.print("DNA sequence ready");
		
		
    	ArrayList <Integer> indices = new ArrayList<Integer>();
    	String subStr = "";    	
    	
    	String input = scn.nextLine();
    	for (int i=0;i<substring.length();i++){

    		// char item =  
    	}
    	return subStr;
    }
	return TargetString;
    	
    	  
/*        elif len(substring) == 1:
            indices = []
 
    
    A common idiom to change every element of a list looks like this: 



    	for i in range(len(L)):
    	    item = L[i]
    	    # ... compute some result based on item ...
    	    L[i] = result


    	This can be rewritten using enumerate() as: 



    	for i, item in enumerate(L):
    	    # ... compute some result based on item ...
    	    L[i] = result


    
    
    	
/*            for i, base in enumerate(self.string):
                if base == substring:
                    indices.append(i)
 
            return indices*/
    	
    	
    /*	
 
        else:
            def table_build(substring):
                table = [-1] + [0]*(len(substring) - 1)
 
                curr_index = 2
                candidate_index = 0
 
                while curr_index < len(substring):
                    # Substring continues
                    if substring[curr_index - 1] == substring[candidate_index]:
                        candidate_index += 1
                        table[curr_index] = candidate_index
                        curr_index += 1
 
                    # Substring doesn't continue, but can fall back
                    elif candidate_index > 0:
                        candidate_index = table[candidate_index]
 
                    # Run out of candidates, candidate_index = 0
                    else:
                        table[curr_index] = 0
                        curr_index += 1
 
                return table
 
            pm_table = table_build(substring)
            m = i = 0
            indices = []
             
            while m + i < len(self.string):
                if substring[i] == self.string[m+i]:
                    if i == len(substring) - 1:
                        indices.append(m)
                        m += i - pm_table[i]
                        i = pm_table[i]
 
                    else:
                        i += 1
 
                else:
                    if pm_table[i] > -1:
                        m += i - pm_table[i]
                        i = pm_table[i]
 
                    else:
                        i = 0
                        m += 1
 
            return indices;
*/
	}
}
