package algorithms.m8;

public class LongestIncrSequence {

    public static int findLengthOfLCIS(int[] nums) {

        int startIndex=0;
        int currIndex=1;
        int max=1;

        while(currIndex<nums.length){

            if(nums[currIndex]>nums[currIndex-1]){
                max = Math.max(currIndex-startIndex+1, max);
            }else{
                startIndex=currIndex;
            }
            currIndex++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS( new int[]{1})==1);
        System.out.println(findLengthOfLCIS( new int[]{1,3,5,10,12})==5);
        System.out.println(findLengthOfLCIS( new int[]{1,3,7,2,10,12})==3);

    }
    
}
