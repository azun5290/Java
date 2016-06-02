package lab03;

import java.lang.reflect.Array;

public class lec03_BasicArray {

	/**
	 * @param args
	 */
	
	public static int countInt(int a, int[] list){

		int count =0;
		for (int i =0; i<list.length;i++){
			if (a == list[i]) count ++;
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int LENGTH=6, MUL=10;
		int[] list = new int[LENGTH];
		for (int i=0;i<LENGTH; i++){
			list[i]=i*MUL;
		}
		list[4]=90;
		for(int i=0;i<LENGTH;i++){
			System.out.print(list[i] + "\t");
		}
		System.out.println();
		System.out.println("Number of times number 10 appears in the array: "+countInt(10,list));
	}
}
