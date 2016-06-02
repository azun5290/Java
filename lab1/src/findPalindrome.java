import java.util.Scanner;


public class findPalindrome {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String str = "ciao";
		System.out.println("Enter a string");
		Scanner input = new Scanner (System.in);
		String astring = input.next();
		//String str = args[0];
		if (isPalindrome(astring)){
			System.out.println("YES! This is a palindrome");
		}
		else
			System.out.println("NO: the word you entered is not palindromic");
	}

	public static boolean isPalindrome(String word) {
		int left  = 0;                 // index of leftmost unchecked char
		int right = word.length() -1;  // index of the rightmost

		while (left < right) {         // continue until they reach centre
			if (word.charAt(left) != word.charAt(right)) {
				return false;          // if chars are different, finished
			}
			left++;                    // move left index toward the centre
			right--;                   // move right index toward the centre
		}
		return true;                   // if finished, all chars were same
	}
}
