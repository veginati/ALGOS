package algorithms.dp.optimization;

public class MinCostClimb {

    public static int minCostClimbingStairs(int[] cost) {

        if(cost.length ==2){
            return Math.min(cost[0],cost[1]);
        }

        int[] dp  = new int[cost.length+1];
        for(int i=2;i<=cost.length;i++){
            int value = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
            dp[i] = value;
        }

        return dp[cost.length];
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
