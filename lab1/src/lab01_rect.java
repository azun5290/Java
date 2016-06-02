

public class lab01_rect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double length = Integer.parseInt(args[0]);
		double width = Integer.parseInt(args[1]);
		System.out.println("Hello, the values currently stored in Run Configs are:" + length + " AND " + width);
		double area = length*width;
		double diag = (double) Math.sqrt ((width*width)+(length*length));
		//System.out.prdoubleln(stuff);
		System.out.println("The area is: "+area);
		System.out.println("The diagonale is: "+diag);

	}

}

