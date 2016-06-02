package week10;

public class SlowCar extends Car {
	public SlowCar(String n, double p, double a, double b){
		super(n,p,a,b);
	}
	public void move(double time){
		if (getSpeed()<getLowerSpeedLimit()){
			setAcceleratorOn(true);
			setBrakeOn(false);
		}
		else{
			setBrakeOn(true);
			setAcceleratorOn(false);
		}
		double a = -getFriction();
		if (isAcceleratorOn()) a += getAccelerationPower();
		if (isBrakeOn()) a -= getBrakePower();
		setSpeed(getSpeed() + time*a);
		setPosition(getPosition() + time*getSpeed());
	}
}
