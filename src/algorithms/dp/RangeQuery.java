package algorithms.dp;

/**
 * Prefix sum approach
 */
public class RangeQuery {

    int[] nums;
    public RangeQuery(int[] nums) {
        int i=0;
        while(++i<nums.length){
            nums[i]+=nums[i-1];
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {

        int jValue = nums[j];
        int iValue = (i-1)>=0?nums[i-1]:0;

        return jValue-iValue;
    }

    public static void main(String[] args) {
        RangeQuery rangeQuery = new RangeQuery(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(rangeQuery.sumRange(0,2));
        System.out.println(rangeQuery.sumRange(0,4));
        System.out.println(rangeQuery.sumRange(2,5));
        System.out.println(rangeQuery.sumRange(1,3));
    }
}
