package binf;

import java.util.Collections;

public class prot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] codons = {
				{"UUU","F","CUU","L","AUU","I","GUU","V"},
				{"UUC","F","CUC","L","AUC","I","GUC","V"},
				{"UUA","L","CUA","L","AUA","I","GUA","V"},
				{"UUG","L","CUG","L","AUG","M","GUG","V"},
				{"UCU","S","CCU","P","ACU","T","GCU","A"},
				{"UCC","S","CCC","P","ACC","T","GCC","A"},
				{"UCA","S","CCA","P","ACA","T","GCA","A"},
				{"UCG","S","CCG","P","ACG","T","GCG","A"},
				{"UAU","Y","CAU","H","AAU","N","GAU","D"},
				{"UAC","Y","CAC","H","AAC","N","GAC","D"},
				{"UAA","Stop","CAA","Q","AAA","K","GAA","E"},
				{"UAG","Stop","CAG","Q","AAG","K","GAG","E"},
				{"UGU","C","CGU","R","AGU","S","GGU","G"},
				{"UGC","C","CGC","R","AGC","S","GGC","G"},
				{"UGA","Stop","CGA","R","AGA","R","GGA","G"},
				{"UGG","W","CGG","R","AGG","R","GGG","G"}
				};
	
		StringBuffer result = new StringBuffer();
		String separator = " ";
				
		for (int i = 0; i < codons.length; ++i)
		{
		  //result.append('[');
		  for (int j = 0; j < codons[i].length; ++j)
		  {
		    if (j > 0)
		      result.append(codons[i][j]);
		    else
		      result.append(codons[i][j]).append(separator);
		  result.append(' ');
		  //System.out.println(codons[i][j]);
		  
		}
		  }
		
		
		System.out.print(result.toString());
		
/*	for (int i=0;i<8;i++){
		for (int j=0;j<16;j++){
		System.out.println((codons));
		}
		}*/
	
	}

}
