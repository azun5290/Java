package refresh_W4;

public class ArrayLib {

	//public static String getAve;
	private int TotalMarks = 0;

	// METHODS

	// GET TOTAL
	public  double getTotal(double[] arr){
		for (int i=0;i<arr.length; i++){
			TotalMarks += arr[i];
		}
		return TotalMarks;
	}

	// AVERAGE

	public  double getAve(double[] arr)
	{
		for (int i=0;i<arr.length; i++){
			TotalMarks += arr[i];
		}
		double aveMark = TotalMarks /arr.length;
		return aveMark;
	}

	// FIND MAX

	public double findMax(double[] arr){
		int max = 0;
		for (int i=1;i<arr.length;i++){
			if (arr[i] > arr[max]){
				max=i;
			}

		}
		return max;
	}

	// REVERSE

	public double[] reverse(double[] arr) {	
		int N = arr.length;
		for (int i=0;i<N/2;i++){
			double temp = arr[i];
			arr[i] = arr[N-1-i];
			arr[N-1-i] = temp;
		}
		return arr;
	}

	// PRINT STUFF

	public void printer(double[] arr){
		for (int i=0;i<arr.length;i++){
			double boh = arr[i];
			System.out.print(boh+"\t");
		}
	}

	// SELECTION SORT

	public int IndexOfMin(int[] arr, int first, int last){
		int index = first;
		for (int k=first+1;k<arr.length;k++){
			if (arr[k] <arr[index]){
				index = k;
			}
		}
		return index;
	}

	public int[] selectionSort(int[] arr, int n){
		for (int i=1;i<arr.length;i++){
			int j = IndexOfMin(arr,i,n);
			int t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
		}
		return arr;
	}

	public double[] selectionSort(double[] arr, int n) {
		// TODO Auto-generated method stub
		for (int i=0;i<arr.length;i++){
			int j = IndexOfMinD(arr,i,n);
			double t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
		}
		return arr;
	}

	private int IndexOfMinD(double[] arr, int first, int last) {
		// TODO Auto-generated method stub
		int index = first;
		for (int k=first+1;k<arr.length;k++){
			if (arr[k] <arr[index]){
				index = k;
			}
		}
		return index;
	}

	public String selectionSort(String string, int length) {
		// TODO Auto-generated method stub
		return null;
	}

}
