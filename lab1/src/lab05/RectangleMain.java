package lab05;

public class RectangleMain {

	public static void main(String[] args) {

		rectangle myR = new rectangle(10,10);
		System.out.println("Area is \t"+myR.area());
		System.out.println("Perimeter is \t"+myR.perimeter());
		System.out.println("Diagonale is \t"+myR.diagonal());
		System.out.println("Rectangle Centre coords are \t"+myR.getWidth()/2+" and " + myR.getHeight()/2);
	}

}
