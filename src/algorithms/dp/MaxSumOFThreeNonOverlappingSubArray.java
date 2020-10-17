package algorithms.dp;

import java.util.Arrays;

/**
 * Time complexity is O(n)
 * Space Compelxity is O(n)
 */
public class MaxSumOFThreeNonOverlappingSubArray {

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        //prefix sum from left to right

        //suffix sum from right to left

        // sum of k elements window sum

        int[] prefixSum = new int[nums.length-k +1];
        int[] suffixSum = new int[nums.length-k +1];
        int[] sum = new int[nums.length-k +1];
        int[] suffix = new int[nums.length-k +1];

        int total=0;
        for(int i=0;i<nums.length;i++){

            total+=nums[i];

            if(i+1-k>=0){
                sum[i+1-k] = total;

                if(i+1-k>0)
                    prefixSum[i+1-k] = total>sum[prefixSum[i-k]] ? i+1-k: prefixSum[i-k];
                total-=nums[i+1-k];
            }
        }

        suffixSum[suffixSum.length-1] = suffixSum.length-1;
        total=0;

        for(int i=nums.length-1,j=nums.length-1;i>=0;i--){
            total+=nums[i];
            if(i+k-1<=j){
                suffix[i] = total;
                if(i+k-1<j)
                    suffixSum[i] = total>suffix[suffixSum[i+1]] ? i:suffixSum[i+1];
                total-=nums[i+k-1];
            }
        }

        int maxTotal =0;
        int[] output = new int[3];

        for(int i=k;i+k<sum.length;i++){
            if(i>prefixSum[i-k] && i<suffixSum[i+k]){
                int tempTotal = sum[i]+ sum[prefixSum[i-k]] + suffix[suffixSum[i+k]];
                if(tempTotal>maxTotal){
                    output = new int[]{prefixSum[i-k],i,suffixSum[i+k]};
                    maxTotal =tempTotal;
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1},2)));
    }
}
