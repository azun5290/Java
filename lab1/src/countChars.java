import java.util.Scanner;

public class countChars {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter a string");
		Scanner read = new Scanner (System.in);
		String input = read.next();
				
		int upperCase = 0;
		int lowerCase = 0;

		//String input = "UFFaaa ";
		
		for (int k = 0; k < input.length(); k++) {
			/**
			 * The methods isUpperCase(char ch) and isLowerCase(char ch) of the
			 * Character class are static so we use the Class.method() format;
			 * the charAt(int index) method of the String class is an instance
			 * method, so the instance, which, in this case, is the variable
			 * `input`, needs to be used to call the method.
			 **/
			// Check for uppercase letters.
			if (Character.isUpperCase(input.charAt(k)))
				upperCase++;

			// Check for lowercase letters.
			if (Character.isLowerCase(input.charAt(k)))
				lowerCase++;
		}
		System.out.printf("There are %d uppercase letters and %d lowercase letters in %s",upperCase, lowerCase, input);
	}
}
