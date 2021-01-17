package algorithms.dp.prep;

public class UniquePathII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid[0][0]==1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1)
            return 0;

        int[][] dp = new int[2][obstacleGrid[0].length+1];
        dp[0][1] =1;

        for(int i=1;i<=obstacleGrid.length;i++){
            for(int j=1;j<=obstacleGrid[0].length;j++){
                if(obstacleGrid[i-1][j-1] ==0)
                    dp[i%2][j] = dp[(i-1)%2][j]+dp[i%2][j-1];
                else
                    dp[i%2][j] =0;
            }
        }

        return dp[obstacleGrid.length%2][obstacleGrid[0].length];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,0,0},{0,0,1}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{1,0,0},{0,0,0},{0,0,0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
    }

}
