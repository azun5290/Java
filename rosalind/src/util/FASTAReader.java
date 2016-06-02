package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FASTAReader {

	public static ArrayList<Sequence> read(String fname) {
		ArrayList<Sequence> sequences = new ArrayList<Sequence>();
		try {
			// read all the lines:
			Scanner scan = new Scanner(new File(fname));
			ArrayList<String> lines = new ArrayList<String>();
			while (scan.hasNextLine()) {
				lines.add(scan.nextLine().trim());
			}
			// now parse them:
			for (int i = 0; i < lines.size(); ) {
				String sequence = "";
				String taxon = "";
				String line = lines.get(i);
				if (line.charAt(0) == '>') {
					taxon = line.substring(1).trim();
				}
				++i;
				if (i >= lines.size()) {
					break;
				}
				while (lines.get(i).charAt(0) != '>') {
					sequence += lines.get(i).trim();
					++i;
					if (i >= lines.size()) {
						break;
					}
				}
				Sequence seq = new Sequence(taxon, sequence);
				sequences.add(seq);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return sequences;
	}
}