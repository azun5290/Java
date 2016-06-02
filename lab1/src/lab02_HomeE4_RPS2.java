import java.util.Scanner;

public class lab02_HomeE4_RPS2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choiceNum = 0;
		//Boolean choice = true;
		int rnd = (int)(10.0 * Math.random());
		while (rnd <= 2)
		{
			System.out.println("Please enter a choice between rock, paper or scissors");
			System.out.println("The computer randomly generates a number (0, 1, or 2) to represent scissor, rock, or paper");
			System.out.println("The matrix is \n0 scissors \n1 rock \n2 paper"); 

			Scanner scn = new Scanner(System.in);
			String message;
			message = scn.nextLine();

			if (message.equalsIgnoreCase("rock"))
			{
				System.out.println("You chose "+message);
				choiceNum = 1;

				System.out.println("Computer drew "+ rnd);

				if (choiceNum == rnd)
				{
					System.out.println("even");
					break;
				}
				else if (rnd == 0){
					System.out.println("You win");
					break;
				}
				else {
					System.out.println("You lose");
					break;
				}
			}
			else if (message.equalsIgnoreCase("paper")){
				System.out.println("You chose "+message);
				choiceNum = 2;

				System.out.println("Computer drew "+ rnd);

				if (choiceNum == rnd)
				{
					System.out.println("even");
					break;
				}
				else if (rnd == 0){
					System.out.println("You lose");
					break;
				}
				else {
					System.out.println("You win");
					break;
				}
			}
			
			else if (message.equalsIgnoreCase("scissors")){
				System.out.println("You chose "+message);
				choiceNum = 0;
				System.out.println("Computer drew "+ rnd);

				if (choiceNum == rnd)
				{
					System.out.println("even");
					break;
				}
				else if (rnd == 1){
					System.out.println("You lose");
					break;
				}
				else {
					System.out.println("You win");
					break;
				}
			}
			else {System.out.println("Please make your selection");}
		}
	}
}
