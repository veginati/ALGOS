package algorithms.dp.prep;

import java.util.Arrays;

/**
 * Given a person can climb number of steps at a time as steps.
 * Time complexity is O(n*k) n = # steps, k = # of unique steps taken
 * Space Complexity is O(n)
 */
public class WaysToClimb {


    static long countWaysToClimb(int[] steps, int n) {
        Arrays.sort(steps);
        // to reach last step, all the other steps are being used.
        long[] cache = new long[n+1];
        // one way to reach zero is not taking anystep.
        cache[0]=1;

        for(int i=steps[0];i<=n;i++){
            for(int j:steps){
                if(i>=j)
                    cache[i]+=cache[i-j];
            }
        }

        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(countWaysToClimb(new int[]{1,2,3,4,5}, 5));
    }
}
