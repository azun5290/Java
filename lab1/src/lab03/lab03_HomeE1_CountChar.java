package lab03;
/*
 * This class takes 2 parameters, 1 char and 1 string
 * It looks for and counts occurrences of this character within 
 * the string
 * 
 */

public class lab03_HomeE1_CountChar {
	/**
	 * @param args 
	 * @param args
	 */ 
	
	static int countChar(char ch, String s){

		int count =0;
		for (int i =0; i<s.length();i++){
			if (s.charAt(i) == ch) count ++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char ch1 = args[0].charAt(0);
		String s1 = args[1];
		System.out.println(countChar(ch1,s1));
	}
}
