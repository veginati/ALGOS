package algorithms.math;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

/**
 * https://leetcode.com/problems/next-permutation/
 * Time complexity : O( n log n)
 * This could be done in O(n) time.
 */
public class NextPermutation {

    static Random r  =new Random();
    public static int[] nextPermutation(int[] nums) {

        if(nums.length ==0)
            return nums;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(nums.length-1);
        for(int i=nums.length-2;i>=0;i--){

            if(!stack.isEmpty() && nums[i]< nums[stack.peekFirst()]){

                int highest = stack.peekFirst();
                while(!stack.isEmpty() && nums[i]<nums[stack.peekFirst()]){
                    highest = stack.pollFirst();
                }
                swap(nums,highest,i);
                quickSort(nums,i+1,nums.length-1);
                return nums;
            }else if(!stack.isEmpty() && nums[i]>nums[stack.peekFirst()]){
                stack.offerFirst(i);
            }
        }
        quickSort(nums,0,nums.length-1);

        return nums;
    }

    public static void quickSort(int[] nums, int start, int end){

        if(start>end)
            return;

        int pivot = start + r.nextInt(end-start+1);
        swap(nums, pivot,end);
        // partition
        int index = partition(nums,start,end);
        quickSort(nums,start,index-1);
        quickSort(nums,index+1,end);
    }

    public static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2]= temp;
    }

    public static int partition(int[] nums, int start, int end){

        int i = start-1;

        for(int j=start;j<=end;j++){

            if(nums[j]<nums[end]){
                i++;
                swap(nums,i,j);
            }
        }

        swap(nums,i+1,end);
        return i+1;
    }

    public static void main(String[] args) {
        System.out.print(Arrays.toString(nextPermutation(new int[]{1,2,3,4,5,3,3,2})));
    }
}