package lab05;

public class StaffMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		staff newStaff = new staff("John", 100, 30);
		System.out.println("Meet "+newStaff.getName()+" Last fortnight he just made $"+newStaff.getSalary());
		
		staff newStaff2 = new staff("Mei", 100, 60);
		System.out.println("Meet "+newStaff2.getName()+" Last fortnight she worked for " +newStaff2.getTime() + " hours and made $"+newStaff2.getSalary());

	}

}
