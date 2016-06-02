import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadStuff {


	@SuppressWarnings("null")
	public static ArrayList<String> proctext (String fname){
		ArrayList<String> Sentence = new ArrayList<>();
		String snt = "";
		try {
			// read all the lines:
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(new File(fname));
			ArrayList<String> lines = new ArrayList<String>();

			while (scan.hasNextLine() && !(scan.equals(null))) {
				//snt = scan.nextLine().trim();
				//snt = snt.replaceAll("\\s+", " ");
				lines.add(scan.nextLine().trim());
				//snt = snt.split(" "); 
				System.out.println(lines);
			}




			/*
		while(scan.hasNext()) {
			snt = scan.nextLine();
			Scanner line =new Scanner(snt);
			String pretext;
			for (int i = 0; i < lines.size(); i++){
				if(line.hasNext()){
					pretext =line.next().trim();
					if (pretext.charAt(0) == " "){

					}

				}
			}
		}

		/*				for (int i = 0; i < lines.size(); i++) {
					//String sequence = "";
					String taxon = "";
					String line = lines.get(i);
					if (line.charAt(0) == ' ') {
						taxon = line.substring(1).trim();
					}
					++i;
					if (i >= lines.size()) {
						break;
					}
					while (lines.get(i).charAt(0) != ' ') {
						snt += lines.get(i).trim();
						++i;
						if (i >= lines.size()) {
							break;
						}
					}

				}*/

			/*				Scanner line =new Scanner(snt);
				String perline = null;
				if(line.hasNext() && !(lines.equals(null))){
					perline =line.next();
					//perline = perline.replaceAll("\\s+", " ");
					Sentence.add(perline);
					System.out.println("PERLINE");
					System.out.println("**********************************");
					System.out.println(perline);
					System.out.println("==================================");
				}*/

			Sentence.add(snt);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(snt);
		return Sentence;


	}

	public static void readme (String filename){
		ArrayList<String> StrArr = ReadStuff.proctext(filename);

		for (String str : StrArr){

			System.out.println(str);
		}
	}

	public static void main (String[] args){
		readme(args[0]);
		//ArrayList<String> readme = ReadStuff.filetext("ReadMe.txt"); 
	}

}
