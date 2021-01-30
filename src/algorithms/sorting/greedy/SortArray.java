package algorithms.sorting.greedy;

import java.util.Arrays;

/**
 * leetcode : 360
 */
public class SortArray {
    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {

        int[] output = new int[nums.length];
        int i=0,j=nums.length-1,k=a>0?nums.length-1:0;

        while(i<=j){

            int iVal = a*nums[i]*nums[i]+ b*nums[i]+c;
            int jVal = a*nums[j]*nums[j]+ b*nums[j]+c;
            if(a>0){
                if(iVal>jVal){
                    output[k]=iVal;
                    i++;
                }else{
                    output[k]=jVal;
                    j--;
                }
                k--;
            }else{
                if(iVal<jVal){
                    output[k]=iVal;
                    i++;
                }else{
                    output[k]=jVal;
                    j--;
                }
                k++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortTransformedArray(new int[]{-6,-4,-3,-1,1,2,3,4,5,6}, 1,3,5)));
        System.out.println(Arrays.toString(sortTransformedArray(new int[]{-6,-4,-3,-1,1,2,3,4,5,6}, -5,3,5)));
    }
}
