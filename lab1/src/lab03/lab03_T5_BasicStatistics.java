package lab03;

public class lab03_T5_BasicStatistics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] basicstat = new double[7];
		double sum = 0, ave = 0;
		int min = 0, max = 0;
		for (int i=0;i<basicstat.length;i++){
			basicstat [i]= Double.parseDouble(args[i]);
			sum += basicstat[i];
		}
		for (int j =1 ; j<basicstat.length;j++){
			if (basicstat[j] > basicstat[max]){
				max = j;
			}
			if (basicstat[j] < basicstat[min]){
				min = j;
			}
		}
		ave = sum/basicstat.length;
		System.out.println("SUM "+sum);
		System.out.println("AVERAGE "+ave);
		System.out.println("MIN "+basicstat[min]);
		System.out.println("MAX "+basicstat[max]);
	}
}




