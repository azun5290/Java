package week11;

public class Circle implements Shape {
	private double x; // the center of
	private double y; // the circle is at (x,y)
	private double r;

	public double getY()
	{
		return y; 
	}
	public double getRadius()
	{
		return r;
	}
	public Circle(double a, double b, double c){
		x=a; y=b; r=c;
		}
			public double area (){
				
				return r*r*Math.PI;
			}
			public double perimeter (){
				return 2*r*Math.PI;
			}
			@Override
			public double getX() {
				// TODO Auto-generated method stub
				return x;
			}
			
			public String toString(){
				return "Circle center (" + x + "," + y + ") with radius " + r;
				}
}