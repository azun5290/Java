package lab05; //goal get salary - salary = hourly rate * hours in day * days in week * 2

public class staff {

	//instance fields
	private String name;
	private double salary;
	private double rate;
	private double time;

	// Constructors - 
	public staff(String nm, double rt,  double tw){
		setName(nm);
		rate=rt;
		time=tw;
	}

	public double getSalary(){
		if(time >= 40){
			salary = rate*time;
			double otime = time -40;
			salary = salary +((otime*rate*1.5));}
		else{
		salary = rate*time;
		
		}
		return salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String nm) {
		name = nm;
	}
	
	public double getTime(){
		return time;
	}
}

