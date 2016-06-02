package week11;

public class ShapeTester {
	public static void main(String[] args) {
		Shape s;
		/*s = new Rectangle(100, 100, 100, 200);
System.out.print(s);
System.out.println(" area=" + s.area() + " perimeter=" + s.perimeter());
System.out.println("---------");*/
		s = new Circle(100, 100, 100);
		System.out.print(s);
		System.out.println(" area=" + s.area() + " perimeter=" + s.perimeter()+"radius " +s.getX());
		System.out.println("---------");
		/*s = new Triangle(100, 100, 100, 200, 200, 200);
System.out.print(s);
System.out.println(" area=" + s.area() + " perimeter=" + s.perimeter());*/
	}
}