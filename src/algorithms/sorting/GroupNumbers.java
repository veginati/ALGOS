package algorithms.sorting;

import java.util.Arrays;

public class GroupNumbers {

    /*
     * Complete the function below.
     */
    static int[] solve(int[] arr) {

        // similar to partition logic

        // use two pointer approach

        int i=-1, j=0;

        while(j<arr.length){
            if(arr[j]%2==0){
                swap(arr,++i,j);
            }
            ++j;
        }

        return arr;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solve(new int[]{8,9,10,11,4,2,1,42,6,42,67,45,99})));
    }
}
