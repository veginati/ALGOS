package algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Time complexity : (n log k)
 * space complexity : O(k)
 */
public class KthLargestNumber {

    public static int findKthLargest(int[] nums, int k) {

        List<Integer> listObj = new ArrayList<>();
        listObj.add(nums[0]);

        for(int i=1;i<nums.length;i++){

            if(nums[i]>listObj.get(listObj.size()-1)){
                listObj.add(nums[i]);
            }else if(nums[i]< listObj.get(0)){
                listObj.add(0,nums[i]);
            }else{
                int index = findIndex(nums[i],listObj);
                listObj.add(index,nums[i]);
            }

            if(listObj.size()>k)
                listObj.remove(0);

        }
        return listObj.get(0);
    }


    public static int findIndex(int target, List<Integer> listObj){

        int start=0;
        int end = listObj.size()-1;

        while(start<=end){

            int mid = start + (end-start+1)/2;

            if(listObj.get(mid)== target){
                return mid;
            }else if(listObj.get(mid)<target){
                start = mid+1;
            }else{
                end =mid-1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2) ==5);
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4) ==4);
    }
}
