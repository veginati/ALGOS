package algorithms.dp.prep;

/**
 * Time & space complexity is O(mn)
 *  m is # of rows
 *  n is # of cols
 *  leetcode 221
 */
public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
    int[][] dp = new int[matrix.length][matrix[0].length];
    int maxSquare=0;
        for(int i=0;i<matrix.length;i++){
        if('1'== matrix[i][0]){
            dp[i][0]=1;
            maxSquare=1;
        }
    }

        for(int i=0;i<matrix[0].length;i++){
        if('1'== matrix[0][i]){
            dp[0][i]=1;
            maxSquare=1;
        }
    }

        for(int i=1;i<matrix.length;i++){
        for(int j=1;j<matrix[i].length;j++){

            if(matrix[i][j]=='1'){
                dp[i][j] = 1+Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]);
                maxSquare= Math.max(maxSquare,dp[i][j]);
            }

        }
    }

        return maxSquare*maxSquare;
}

    public static void main(String[] args) {

        char[][] input = {{'1','0','1','1','1','1'},{'1','1','1','1','1','1'},{'1','1','1','1','1','1'},{'1','1','1','1','1','1'},{'1','1','1','1','1','1'}};
        System.out.println(maximalSquare(input));
    }
}
