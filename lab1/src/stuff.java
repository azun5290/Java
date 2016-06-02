import java.io.IOException;


public class stuff {

	/**
	 * @param args 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		char tmp = (char) System.in.read();


		if (tmp == 'h'){
			System.out.println("High distinction is 86-100 score");
		}

		else if (tmp == 'd'){
			System.out.println("distinction is 76-85 score");
		}

		else if (tmp == 'c'){
			System.out.println("credit is 65-75 score");
		}

		else if (tmp == 'p'){
			System.out.println("pass is 50-64 score");
		}

		else if (tmp == 'f'){
			System.out.println("Failure is below 50");
		}


		else System.out.println("Wrong key try again");

	}
}
