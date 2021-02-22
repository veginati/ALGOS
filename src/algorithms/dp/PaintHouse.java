package algorithms.dp;

public class PaintHouse {
    public static int minCost(int[][] costs) {

        if(costs.length==0)
            return 0;

        int[][] dp = new int[3][costs.length];

        dp[0][0] = costs[0][0];
        dp[1][0] = costs[0][1];
        dp[2][0] = costs[0][2];

        for(int i=1;i<costs.length;i++){
            dp[0][i] = costs[i][0] + Math.min(dp[1][i-1],dp[2][i-1]);
            dp[1][i] = costs[i][1] + Math.min(dp[0][i-1],dp[2][i-1]);
            dp[2][i] = costs[i][2] + Math.min(dp[0][i-1],dp[1][i-1]);
        }

        return  Math.min(Math.min(dp[0][costs.length-1],dp[1][costs.length-1]),dp[2][costs.length-1]);
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }
}
