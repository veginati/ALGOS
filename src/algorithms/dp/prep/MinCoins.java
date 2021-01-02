package algorithms.dp.prep;

import java.util.Arrays;
import java.util.List;

public class MinCoins {

    /*
     * Complete the 'minimum_coins' function below.
     *
     * The function accepts INTEGER ARRAY and INTEGER as parameter.
     * Return INTEGER.
     */
    public static int minimum_coins(List<Integer> coins, int value) {
        // Write your code here
        Integer dp[] = new Integer[value+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1;i<=coins.size();i++){
            for(int j=coins.get(i-1);j<=value;j++){
                if(dp[j-coins.get(i-1)]!=Integer.MAX_VALUE){
                    int tempValue = 1+dp[j-coins.get(i-1)];
                    dp[j] = Math.min(tempValue,dp[j]);
                }
            }
        }
        return dp[value];
    }

    public static void main(String[] args) {
        System.out.println(minimum_coins(Arrays.asList(10,3,5,8,1),29));
    }

}
