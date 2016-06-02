import java.io.File;
import java.io.IOException;

import javax.print.DocFlavor.STRING;


public class CreateFile {

	private static String DirectoryPath = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DirectoryPath = "C:\\data\\docs\\bioinfo\\comp5214\\labs\\week4";
		File theDir = new File(DirectoryPath); 
		if (!theDir.exists()) theDir.mkdir(); 

		File f = new File;
		if (f != 0) {
			{
		        f = new File("c:\\MyFolder");
		        f.mkdir();

		    }
		}
		else
		{}
	
		try {
		    File file = new File("filename");

		    // Create file if it does not exist
		    boolean success = file.createNewFile();
		    if (success) {
		        // File did not exist and was created
		    } else {
		        // File already exists
		    }
		} catch (IOException e) {
		}


	}

}
