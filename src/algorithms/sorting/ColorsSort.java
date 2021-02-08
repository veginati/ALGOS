package algorithms.sorting;

public class ColorsSort {
    public static void sortColors(int[] nums) {

        int p1=0;
        int p3= nums.length-1;
        int curr =0;

        while(curr<=p3){
            int value = nums[curr];
            if(value ==0){
                // replace it first non-zero of p1;
                while(nums[p1]==0 &&p1<curr){
                    ++p1;
                }
                swap(curr,p1,nums);
            }else if(value ==2){
                while(nums[p3]==2 && p3>curr){
                    --p3;
                }
                swap(curr,p3,nums);

            }
            if(!(nums[curr] ==0 && p1<curr || nums[curr]==2 && p3>curr)){
                ++curr;
            }
        }
    }

    public static void swap(int p1, int p2, int[] nums){
        int temp = nums[p1];
        nums[p1]=nums[p2];
        nums[p2]=temp;
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0,2,2,2,1,2,1,2,1,2,0,0});
    }
}
