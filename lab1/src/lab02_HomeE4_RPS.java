
public class lab02_HomeE4_RPS {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num  = Integer.parseInt(args[0]);
		System.out.println("0 is for SCISSORS");
		System.out.println("1 is for ROCK");
		System.out.println("2 is for PAPER");
		System.out.println("Please make your selection");
		int rnd = (int)(10.0 * Math.random()); // assigns value to random int, use Math method random then typecasts into int to eliminate decimals

		switch (num){

		// Start of Case 0 - we enter this case if user's argument is 0

		case 0: 

			System.out.println("You threw SCISSORS!"); // this translates case number into explicit choice

			// here we nest choice as rnd cannot be more than 2 - if it is you need to restart
			if  (rnd > 2)
			{

				System.out.println("The computer threw "+ rnd +" Invalid throw, value out of range - start over");
			} 
			else 
			{

				// otherwise run following where choice is made depending on random value

				if (rnd == 0)
				{
					System.out.println("The computer generated " +rnd+ " which equals to SCISSORS");
					System.out.println("You drew - start over");
				}
				else if  (rnd == 1)
				{
					System.out.println("The computer generated " +rnd+ " which equals to ROCK");
					System.out.println("You lose");
				}
				else
				{
					System.out.println("The computer generated " +rnd+ " which equals to PAPER");
					System.out.println("You win!");
				}	// END of nested IF layer 1
			} // END of IF in layer 1
			break;

			// END of Case 0 	
			// Start of Case 1 - we enter this case if user's argument is 1

		case 1: 

			System.out.println("You threw ROCK!"); // translates case number into explicit choice

			// here we nest choice as rnd cannot be more than 2 - if it is you need to restart
			if  (rnd > 2)
			{

				System.out.println("The computer threw "+ rnd +" Invalid throw, value out of range - start over");

			} 

			else 
			{
				// otherwise run following where choice is made depending on rnd value

				if (rnd == 0)
				{
					System.out.println("The computer generated " +rnd+ " which equals to SCISSORS");
					System.out.println("You win!");
				}
				else if  (rnd == 1)
				{
					System.out.println("The computer generated " +rnd+ " which equals to ROCK");
					System.out.println("You drew - start over");
				}
				else 
				{
					System.out.println("The computer generated " +rnd+ " which equals to PAPER");
					System.out.println("You lose");
				}	// END of nested IF layer 1
			} // END of IF in layer 1
			break; 

			// END of Case 1
			// START of Case 2

		case 2: 

			System.out.println("You threw PAPER!"); // translates case number into explicit choice

			// here we nest choice as rnd cannot be more than 2 - if it is you need to restart

			if  (rnd > 2)
			{

				System.out.println("The computer threw "+ rnd +" Invalid throw, value out of range - start over");

			} 
			else 
			{

				// otherwise run following where choice is made depending on rnd value

				if (rnd == 0)
				{
					System.out.println("The computer generated " +rnd+ " which equals to SCISSORS");
					System.out.println("You lose");
				}
				else if  (rnd == 1)
				{
					System.out.println("The computer generated " +rnd+ " which equals to ROCK");
					System.out.println("You win!");
				}
				else 	
				{
					System.out.println("The computer generated " +rnd+ " which equals to PAPER");
					System.out.println("You drew - start over");
				}	// END of nested IF layer 1
			} // END of IF in layer 1

			break;

			// END of Case 2
			// Default case - anything other than choice 0,1,2
		default: System.out.println("Please make your choice");break;

		}
	}

}
