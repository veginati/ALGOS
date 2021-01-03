package algorithms.dp.prep;

/**
 * Time complexity is O(n^2d)
 * Space Complexity is O(nd)
 *  leetcode 1335
 */
public class MinDiffJobSchedule {

    public static int minDifficulty(int[] jobDifficulty, int d) {

        if(d>jobDifficulty.length){
            return -1;
        }else if(d == jobDifficulty.length){
            int total=0;
            for(int i:jobDifficulty){
                total+=i;
            }
            return total;
        }

        int[][] dp = new int[d][jobDifficulty.length];
        dp[0][0] = jobDifficulty[0];

        for(int i=1;i<jobDifficulty.length;i++)
        {
            dp[0][i]= Math.max(dp[0][i-1],jobDifficulty[i]);
        }

        for(int days=1;days<d;days++){

            for(int i=days;i<jobDifficulty.length;i++){
                int localMax = jobDifficulty[i];
                dp[days][i] = Integer.MAX_VALUE;

                for(int j=i;j>=days;j--){
                    localMax = Math.max(localMax,jobDifficulty[j]);
                    dp[days][i] = Math.min(dp[days][i], localMax+ dp[days-1][j-1]);
                }
            }
        }
        return  dp[d-1][jobDifficulty.length-1];
    }

    public static void main(String[] args) {
        System.out.println(minDifficulty(new int[]{186,398,479,206,885,423,805,112,925,656,16,932,740,292,671,360}, 4));
        System.out.println(minDifficulty(new int[]{1,9,7,2,8,4,2,8,6}, 4));
    }
}
