public class lavagnetta {
	/**
	 * @param args
	 * @return
	 * @return
	 */

	public static void main(String[] args) {
		System.out.println("run config has string: "+ args[0]);
		System.out.println("This string has " + countUpperCase(args[0]) + " uppercase chars " );
		// return;
	}

	// return count;
	public static int countUpperCase(String Str1) {

		int count = 0;
		for (int i = 0; i < Str1.length(); i++) {
			char ch = Str1.charAt(i);
			if (Character.isUpperCase(ch)) {
				count++;
			}
		}
		//System.out.println(count);
		return count;
	}
}
