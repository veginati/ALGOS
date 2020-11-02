package algorithms.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem : https://leetcode.com/problems/find-in-mountain-array/
 * Time Complexity : O(logn) for find the max element, finding the index in left half or finding element in right half
 * spce complexity : O(logn) for resusing the cache values.
 */
public class MountainArray {
    int[] values={1,2,3,5,4};
    public int get(int index) {
        return values[index];
    }
    public int length() {
        return values.length;
    }

}
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    Map<Integer,Integer> cache = new HashMap<>();
    int length = 0;

    public int findInMountainArray(int target, MountainArray mountainArr) {

        length = mountainArr.length()-1;
        int largestIndex = findLargestElement(mountainArr);
        if(target>cache.get(largestIndex))
            return -1;
        int targetIndex = findElementBSInc(mountainArr,target,0,largestIndex);

        if(targetIndex!=-1)
            return targetIndex;

        return findElementBSDec(mountainArr,target,largestIndex+1,length);
    }

    public int findLargestElement(MountainArray mountainArr){

        int start=0;
        int end = length;

        while(start<=end){

            int mid = start + (end-start+1)/2;

            int midValue = cache.containsKey(mid)?cache.get(mid):mountainArr.get(mid);
            int leftValue = midValue;
            int rightValue = midValue;
            if(cache.containsKey(mid-1)) {
                leftValue=  cache.get(mid - 1);
            }else if(mid-1>=0){
                leftValue = mountainArr.get(mid-1);
                cache.put(mid-1,leftValue);
            }

            if(cache.containsKey(mid+1)) {
                rightValue=  cache.get(mid + 1);
            }else if(mid+1<=length){
                rightValue = mountainArr.get(mid+1);
                cache.put(mid+1,rightValue);
            }
            cache.put(mid,midValue);

            if(midValue>leftValue && midValue>rightValue){
                return mid;
            }else if(midValue<rightValue){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return start;
    }

    public int findElementBSInc(MountainArray mountainArr, int target, int start, int end){

        int targetIndex =-1;

        while(start<=end){

            int mid = start + (end-start)/2;

            int midValue = cache.containsKey(mid)?cache.get(mid):mountainArr.get(mid);
            cache.put(mid,midValue);

            if(midValue==target){
                targetIndex = mid;
                end =mid-1;
            }else if(midValue<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return targetIndex;
    }

    public int findElementBSDec(MountainArray mountainArr, int target, int start, int end){
        int targetIndex =-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            int midValue = cache.containsKey(mid)?cache.get(mid):mountainArr.get(mid);
            cache.put(mid,midValue);

            if(midValue==target){
                targetIndex = mid;
                end =mid-1;
            }else if(midValue<target){
                end =mid-1;
            }else{
                start = mid+1;
            }
        }

        return targetIndex;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        MountainArray mountainArray = new MountainArray();
        System.out.println(sol.findInMountainArray(4,mountainArray));
    }
}