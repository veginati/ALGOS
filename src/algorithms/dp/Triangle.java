package algorithms.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {

        int min= Integer.MAX_VALUE;

        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        dp[0]=triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){ // i =1, 2

            for(int j=triangle.get(i).size()-1;j>=0;j--){ // j=0 , =1

                int value = triangle.get(i).get(j); // 6

                if(j==0){
                    dp[j]+=value;
                }else if(j == triangle.get(i).size()-1){
                    dp[j] = dp[j-1]+value;
                }else{
                    dp[j]=value+Math.min(dp[j],dp[j-1]);
                }
            }
        }

        for(int i=0;i<dp.length;i++){
            min = Math.min(min,dp[i]);
        }

        //System.out.println(Arrays.toString(dp));
        return min;
    }

    public static void main(String[] args) {

        List<List<Integer>> input = new LinkedList<>();

        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3,4));
        input.add(Arrays.asList(6,5,7));
        input.add(Arrays.asList(4,1,8,3));

        System.out.println(minimumTotal(input));
    }
}
