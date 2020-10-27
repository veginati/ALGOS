package algorithms.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeArrays {

    /*
     * Complete the mergeArrays function below.
     */
    static int[] mergeArrays(int[][] arr) {
        /*
         * Write your code here.
         */
        int total=0;
        PriorityQueue<int[]> minHeap = null;
        boolean increasingOrderStream =true;

        for(int i=0;i<arr.length;i++) {
            if (arr[i].length > 1) {
                if (arr[i][0] > arr[i][arr[i].length - 1]) {
                    increasingOrderStream = false;
                    break;
                }else if (arr[i][0] < arr[i][arr[i].length - 1]) {
                    break;
                }
            }
        }

        if(increasingOrderStream)
            minHeap =new PriorityQueue<>((a,b)->a[0]-b[0]);
        else
            minHeap =new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int i=0;i<arr.length;i++){
            total+=arr[i].length;
            if(arr[i].length>0)
                minHeap.offer(new int[]{arr[i][0],0,i});

        }

        int[] output = new int[total];

        for(int i=0;i<total;i++){

            int[] leastNumber = minHeap.poll();
            output[i]=  leastNumber[0];
            int tempIndex = leastNumber[1];
            int arrayIndex = leastNumber[2];
            ++tempIndex;
            if(tempIndex<arr[arrayIndex].length){
                minHeap.offer(new int[]{arr[arrayIndex][tempIndex],tempIndex,arrayIndex});
            }

        }

        return output;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(mergeArrays(new int[][]{{34,26,20,13,11,7,4,4},
                {41,34,27,23,19,10,8,0}})));
        System.out.println(Arrays.toString(mergeArrays(new int[][]{{6,10,15},
                {7,9,18}})));
    }

}
