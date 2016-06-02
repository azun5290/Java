package week10;

public class CarTester {
	public static void main(String[] args) {
		Car c1 = new Car("Norman", 10, 1, 1);
		Car c2 = new SpeedyCar("Zippy", 10, 1, 1, 1.3);
		Car c3 = new SlowCar("Sleepy", 10, 1,1);
		System.out.println(c3.getName() + "\t" + c2.getName() + "\t" + c1.getName());
		c1.move(1);
		c2.move(1);
		c3.move(1);
		System.out.printf("%-7.1f\t%-7.1f\t%-7.1f\t\n", c3.getSpeed(), c2.getSpeed(), c1.getSpeed());
	}
}
