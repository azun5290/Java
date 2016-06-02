package Stuff;
//import ProcessEMRData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	
	public static String trimmer(String text, String trimBy) {
	    int beginIndex = 0;
	    int endIndex = text.length();

	    while (text.substring(beginIndex, endIndex).startsWith(trimBy)) {
	        beginIndex += trimBy.length();
	    } 

	    while (text.substring(beginIndex, endIndex).endsWith(trimBy)) {
	        endIndex -= trimBy.length();
	    }

	    return text.substring(beginIndex, endIndex);
	}
	//Usage:
	String trimmedString = trimmer("stringToTrim", "/");
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub


		String a = "\\joe\\jill\\"; 
		String b = a.replaceAll("\\\\$", "").replaceAll("^\\\\", ""); 
		System.out.println(b); 
		
		//String j = CharMatcher.is('\\').trimFrom("\\joe\\jill\\"); 


		String date_s = " 2011-01-18xxxx";  
		String newdate = null;
		//String newdate = date_s.replaceAll("[^\\p{ASCII}]", ""); // replaceAll("\\\\$", "")


		if (date_s.contains("xxxx")){
			newdate = date_s.replaceAll("^xxxx|xxxx$", "");
		}

		// else if 

		/*		for (int i= 0;i<4;i++){			
			newdate = date_s.replaceAll("^x|x$", "");  // [^\\p{ASCII}]

		}*/

		// String newdate = date_s.replaceAll("y$|^x|x$|^y", ""); 
		// String newdate = date_s.replaceAll("[^a-zA-Z0-9]", ""); 

		//String newdate = null;

		if (!newdate.isEmpty()){
			newdate = newdate.trim();
			System.out.println("contento????");  
		}
		else{
		System.out.println("NOOOOOOOOOOOOOOOOOOOOO"); 
		}
		System.out.println(newdate);

		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
		Date date = dt.parse(newdate);
		//SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd"); SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String s = dt.format(date);


		String oldString = null;
		@SuppressWarnings("null")
		String str = oldString.replaceAll("[^\\p{ASCII}]", "");

		System.out.println(dt.format(date));
		System.out.println(s);
		System.out.println(str);
		System.out.println(newdate);
	}
}