import java.util.*;
class checkArray{
    public static void main(String args[]){
        float [] arr = new float[]{1,2,2,7,9};
        if(checkDuplicates(arr)){
            System.out.println("There are duplicate elements.");
            Float array[] = new Float[arr.length];
            for(int i=0;i<arr.length;i++){
                array[i]=new Float(arr[i]);
            }
            Set<Float> set=new HashSet<Float>(Arrays.asList(array));
            System.out.print(set);
        }
        else{
            System.out.println("No duplicate elements are there!"); 
        }
    }
    private static boolean checkDuplicates(float[] array){
        for (int i = 0; i < array.length; i++) {
            float num = array[i];
            if(num==0)continue; 
            for (int j = 0; j < array.length; j++) {
                    if(i==j)continue; 
                    float compnum = array[j];
                    if (num==compnum){
                            return true;
                    }
            }
        }
        return false;
    }
 }
