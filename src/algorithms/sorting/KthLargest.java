package algorithms.sorting;

import java.util.Random;

/**
 * Try 215 & 953 leetcode
 */
public class KthLargest {

    Random r = new Random();
    public int findKthLargest(int[] nums, int  k){
        return quickSelect(nums,0, nums.length-1,nums.length-k);
    }

    public int findKthSmallest(int[] nums, int  k){
        return quickSelect(nums,0, nums.length-1,k-1);
    }

    /**
     *  here index is either largest or smallest
     *  index = nums.length-k is the largest Kth values
     *  index = k-1, is the smallest kth value.
     *  time complexity is O(n)
     * @param nums
     * @param start
     * @param end
     * @param index
     * @return
     */
    public int quickSelect(int[] nums, int start, int end, int index){

        //base case
        if(start == end){
            return nums[start];
        }
        int partitionIndex = partition(nums, start,end);

        if(partitionIndex == index){
            return nums[partitionIndex];
        }

        //recursive case
        return  (index)>partitionIndex?quickSelect(nums,partitionIndex+1,end,index):quickSelect(nums,start,partitionIndex-1,index);
    }

    //lumutos partition
    public int partition(int[] nums, int start, int end){

        int pivotIndex = start + r.nextInt(end-start+1);
        swap(nums,start,pivotIndex);
        int i =start;
        int j=start;
        int pivotValue = nums[i];

        while(j<=end){

            if(nums[j]<pivotValue){
                swap(nums, ++i,j);
                j++;
            }else {
                j++;
            }
        }

        swap(nums,start,i);

        return i;
    }

    public void swap(int[] nums, int start, int pivotIndex){

        int temp = nums[start];
        nums[start]= nums[pivotIndex];
        nums[pivotIndex]= temp;

    }
}
