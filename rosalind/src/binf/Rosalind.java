package binf;

import java.net.FileNameMap;
import java.util.ArrayList;

import util.FASTAReader;
import util.Sequence;

public class Rosalind {

	public static void getHammingDistance(String seqOne, String seqTwo) {
		int distance = 0;
		for (int i = 0; i < seqOne.length(); ++i) {
			if (seqOne.charAt(i) != seqTwo.charAt(i)) {
				distance++;
			}
		}
		System.out.println(distance);
	}

	public static void findMaxGCContent(String filename) {
		/*
		 * Process:
		 * Read the file as a set of sequences
		 * For each sequence get its GC content
		 * Print out the name of the sequence with the maximum GC content, and
		 * 	the GC content
		 */
		ArrayList<Sequence> sequences = FASTAReader.read(filename);
		double maxGCContent = 0.0;
		String selectedSequence = "no selection";
		for (Sequence seq : sequences) {
//			System.out.println(seq);
			double gcContent = seq.getGCContent();
//			System.out.println("GCContent = " + gcContent);
			if (gcContent > maxGCContent) {
				maxGCContent = gcContent;
				selectedSequence = seq.getID();
			}
		}
		System.out.println(selectedSequence + "\n" + (maxGCContent *100.0));
	}
	


	public static void main(String[] args) {
		// This class will do all the work by calling other methods as we develop
		// them.
		if (args.length < 2) {
			System.out.println("Invoke this program with the problem name, "
					+ "e.g., \"GC\", followed by the name of the file to be read "
					+ "in, e.g., \"rosalind_gc.txt\" \n"
					+ "or a list of arguments as per the problem definition");
			return;
		}
		String problemID = args[0].toUpperCase();
		switch (problemID) {
			case "GC":		findMaxGCContent(args[1]);	break;
			case "HAMM":	getHammingDistance(args[1], args[2]);	break;
			case "KMPMatch":		KMPMatch(args[1],args[2]); break;
			case "W7_L1": 	unAliSeq(args[1]);break;
			default:
				System.out.println("I don't know that problem yet.");
				break;
		}
	}

	private static void unAliSeq(String filename) {
		// TODO Auto-generated method stub
		ArrayList<Sequence> sequences = FASTAReader.read(filename);
		//double maxGCContent = 0.0;
		String selectedSequence = "no selection";
		for (Sequence seq : sequences) {
			System.out.println(seq);
//			double gcContent = seq.getGCContent();
//			System.out.println("GCContent = " + gcContent);
			
/*			public static void findkmers(FileNameMap, k){
				ArrayList<Sequence> sequences = FASTAReader.read(filename);
				for (Sequence seq : sequences) {*/
			//		Kmers = 
				//}
				
			}
		}


	private static void KMPMatch(String string1, String string2) {
		// TODO Auto-generated method stub
	KMPMatch(string1, string2);
	}

	public static String translateRNA(String rna) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String exactMatches(String s, String t) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String findConsensus(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}