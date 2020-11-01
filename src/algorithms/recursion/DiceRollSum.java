package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class DiceRollSum {


    static void findCombination(int roll, int n, int sum, int target, List<String> coll, char[] soFar){

        if(roll == n && sum == target){
            coll.add(String.valueOf(soFar));
        }
        /**
         * sum+(n-roll)*6<target : with the remaining the rolls, even with max sum won't be able to reach target
         * sum+(n-roll)>target: reached max sume , e
         */
        if(sum>target || roll>=n || sum+(n-roll)*6<target || sum+(n-roll)>target)
            return;

        for(int i=1;i<=6;i++) {
            soFar[roll] = Character.forDigit(i, 10);
            findCombination(roll + 1, n, sum + i, target, coll, soFar);
        }
    }

    static List<String> driver(int n, int target){
        List<String> coll =new ArrayList<>();
        findCombination(0,n,0,target,coll,new char[n]);
        return coll;
    }

    public static void main(String[] args) {
        System.out.println(driver(2,7));
        System.out.println(driver(3,7));
    }
}
