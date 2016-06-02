import java.io.File;
import java.io.FileNotFoundException;
// import java.util.ArrayList;
import java.util.Scanner;


public class ReadStuff2 {
	
	public static void main (String[] args){
	
		try {
			Scanner FullText = new Scanner (new File ("zap.txt"));
			while (FullText.hasNext()){
				FullText.toString();
				System.out.println(FullText);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
