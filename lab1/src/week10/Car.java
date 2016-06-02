package week10;

public class Car {
	private double speed;
	private double accelerationPower;
	private double brakePower;
	private boolean acceleratorOn;
	private boolean brakeOn;
	private double position;
	private String name;
	private static double lowerSpeedLimit = 80.0;
	private static double upperSpeedLimit = 110.0;
	private static double friction = 0.3;
	public Car(String n, double p, double a, double b){
		name = n;
		position = p;
		accelerationPower = a;
		brakePower = b;
		speed = 0.0;
		acceleratorOn = true;
		brakeOn = false;
	}
	public double getPosition(){
		return position;
	}
	public double getSpeed(){
		return speed;
	}
	public String getName(){
		return name;
	}
	public double getAccelerationPower() {
		return accelerationPower;
	}
	public void setAccelerationPower(double
			accelerationPower) {
		this.accelerationPower = accelerationPower;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public void setPosition(double position) {
		this.position = position;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString(){
		return name + ": Pos=" + position + ";  Acc=" + 
				accelerationPower + "; Brake=" + brakePower;
	}
	public void move(double time){
		if (speed<getLowerSpeedLimit()){
			acceleratorOn = true;
			brakeOn = false;
		}
		if (speed>getUpperSpeedLimit()){
			brakeOn = true;
			acceleratorOn = false;
		}
		double a = -friction;
		if (acceleratorOn) a += accelerationPower;
		if (brakeOn) a -= brakePower;
		speed = speed + time*a;
		position += time*speed;
	}
	public static double getFriction() {
		return friction;
	}
	public static void setFriction(double friction) {
		Car.friction = friction;
	}


	public double getBrakePower() {
		return brakePower;
	}
	public void setBrakePower(double brakePower){
		this.brakePower = brakePower;
	}
	public boolean isAcceleratorOn() {
		return acceleratorOn;
	}
	public void setAcceleratorOn(boolean
			acceleratorOn) {
		this.acceleratorOn = acceleratorOn;
	}
	public boolean isBrakeOn() {
		return brakeOn;
	}
	public void setBrakeOn(boolean brakeOn) {
		this.brakeOn = brakeOn;
	}
	public static double getLowerSpeedLimit() {
		return lowerSpeedLimit;
	}
	public static void setLowerSpeedLimit(double lowerSpeedLimit) {
		Car.lowerSpeedLimit = lowerSpeedLimit;
	}
	public static double getUpperSpeedLimit() {
		return upperSpeedLimit;
	}
	public static void setUpperSpeedLimit(double
			upperSpeedLimit) {
		Car.upperSpeedLimit = upperSpeedLimit;
	}
}