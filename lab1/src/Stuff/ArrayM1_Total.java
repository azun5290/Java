package Stuff;

public class ArrayM1_Total {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [] a = new double[5];
		for (int i=0;i<a.length;i++){
			a[i]= Double.parseDouble(args[i]);
			//System.out.println(a[i]);
		}
		System.out.println("The inputs are:");
		int Total = 0;
		for (int i=0;i<a.length;i++){
			Total += a[i];
			System.out.println(a[i]);
		}
		System.out.println("\nThe total is:\t"+Total);
		double ave = Total/a.length;
		System.out.println("\nThe average value is:\t"+ave);

		int len = a.length;
		for (int i =0;i<len/2; i++){
			double temp = a[i];
			a[i]= a[len-1-i];
			a[len-1-i]=temp;
			//System.out.println(a[i]);
		}

		System.out.println("The reversed elements are:\n");
		for (int i=0;i<a.length;i++){
		System.out.println(a[i]);
		}
		int max = 0;
		for (int i=0;i<a.length;i++){
			if (a[i]>a[max]){
				max=i;
			}
		}
		System.out.println("The maximum value is:\t"+a[max]);

		int min = 0;
		for (int i=0;i<a.length;i++){
			if (a[i]<a[min]){
				min=i;
			}
		}
		System.out.println("The minimum value is:\t"+a[min]);
	}
}
