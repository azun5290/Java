import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class perm {

    public static void main(String args[]) {
    	
    	Scanner scn = new Scanner(System.in);
        Permutation<Integer> obj = new Permutation<Integer>();
        Collection<Integer> input = new ArrayList<Integer>();
        input.add(1);
        input.add(2);
        //input.add(3);

        Collection<List<Integer>> output = obj.perm(input);
        int k = 0;
        Set<List<Integer>> pnr = null;
        for (int i = 0; i <= input.size(); i++) {
            pnr = new HashSet<List<Integer>>();
            for(List<Integer> integers : output){
            pnr.add(integers.subList(i, integers.size()));
            }
            k = input.size()- i;
            System.out.println("P("+input.size()+","+k+") :"+ 
            "Count ("+pnr.size()+") :- "+pnr);
        }
    }

public List<List<Integer>> perm(int[] num) {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    res.add(new ArrayList<Integer>()); // Add an empty list
    for(int number = 0; number < num.length; number++)
    {
        List<List<Integer>> curr = new ArrayList<List<Integer>>();
        for(List<Integer> nestedL : res)
        {
            for(int j = 0; j < nestedL.size() + 1 ;j++)
            {
                nestedL.add(j,num[number]);
                List<Integer> temp = new ArrayList(nestedL);
                curr.add(temp);
                nestedL.remove(j);
            }
        }
        res = new ArrayList<List<Integer>>(curr);
    }

   return res;
}
}