package week10;

public class SpeedyCar extends Car {
	private double speediness;
	public SpeedyCar(String n, double p, double a, double b, double s){
		super(n,p,a,b);
		speediness = s;
	}
	public void move(double time){
		if (getSpeed()>speediness*getUpperSpeedLimit()){
			setBrakeOn(true);
			setAcceleratorOn(false);
		}
		else {
			setBrakeOn(false);
			setAcceleratorOn(true);
		}
		double a = -getFriction();
		if (isAcceleratorOn()) a += getAccelerationPower();
		if (isBrakeOn()) a -= getBrakePower();
		setSpeed(getSpeed() + time*a);
		setPosition(getPosition() + time*getSpeed());
	}
}