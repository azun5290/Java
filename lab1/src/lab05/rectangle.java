package lab05;

public class rectangle {

	//instance fields - two instance variables are sufficient to describe width and length - rest can be calculated in methods
	private double width;
	private double height;

	// Constructors - a rectangle constructor that takes two parameters
	public rectangle(double wd, double he) {
		width = wd;
		height = he;
	}
	// a getter for the height
	public double getHeight(){
		return height;
	}
	// a getter for the width
	public double getWidth(){
		return width;
	}
	// method to get area 
	public double area(){
		return height*width;
	}
	// method to get perimeter
	public double perimeter(){
		return height*2+width*2;

	}
// a method to calculate the diagonal
	public double diagonal(){
		return Math.sqrt(Math.pow(width, 2)+Math.pow(height, 2));
	}

}