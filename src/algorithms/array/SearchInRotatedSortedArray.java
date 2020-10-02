package algorithms.array;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        if(nums[0]<=nums[nums.length-1]){
            return findIndex(target, 0,nums.length-1,nums);
        }

        int index = findRangeIndex(nums[0],0,nums.length-1,nums);

        if(index>=0 && (target>=nums[0] && target<=nums[index])){
            return findIndex(target,0,index,nums);
        }
        return findIndex(target,index+1,nums.length-1,nums);
    }

    private static int findRangeIndex(int target, int start, int end, int[] arr){

        while(start<=end){

            int mid = start + (end-start)/2;

            if(arr[mid]>=target && arr[mid+1]<target){
                return mid;
            }else if(arr[mid]>=target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return -1;
    }

    private static int findIndex(int target, int start, int end, int[] arr){

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println(search(new int[]{8,9,10,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7},8));
        System.out.println(search(new int[]{8,9,10,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7},0));
        System.out.println(search(new int[]{8,9,10,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7},-19));
        System.out.println(search(new int[]{8,9,10,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7},-10));
        System.out.println(search(new int[]{11},11));
        System.out.println(search(new int[]{0,1,2,3,4,5,6,7},6));
    }
}