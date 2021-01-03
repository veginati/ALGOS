package algorithms.dp.prep;

/**
 *  Time complexity is O(m*n^2)
 *  m = # of subarrays
 *  n = length of the nums
 */
public class SplitArraySum {

    public static int splitArray(int[] nums, int m) {

        int[][] dp = new int[m][nums.length];
        dp[0][0] = nums[0];
        int max=0;
        for(int i=1;i<nums.length;i++){
            dp[0][i] = nums[i]+dp[0][i-1];
            max = Math.max(max,nums[i]);
        }

        if(m ==nums.length){
            return max;
        }

        for(int arr=1;arr<m;arr++){

            for(int i=arr;i<nums.length;i++){
                int localMaxValue = 0;
                dp[arr][i] = Integer.MAX_VALUE;
                for(int j=i;j>=arr;j--){
                    localMaxValue+=nums[j];
                    dp[arr][i] = Math.min(dp[arr][i], Math.max(localMaxValue,dp[arr-1][j-1]));
                }
            }
        }

        return dp[m-1][nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7,2,5,10,8}, 2));
        System.out.println(splitArray(new int[]{1,2,3,4,5}, 2));
    }
}
