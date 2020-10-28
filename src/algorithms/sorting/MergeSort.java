package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static List<Integer> merge_sort(List<Integer> arr) {
        // Write your code here

        mergeSortHelper(0,arr.size()-1,arr);
        return arr;
    }

    public static void mergeSortHelper(int start, int end, List<Integer> arr){

        if(start>=end){
            return;
        }

        int mid = start + (end-start)/2;
        mergeSortHelper(start,mid,arr);
        mergeSortHelper(mid+1,end,arr);
        merge(start,mid,mid+1,end,arr);
    }

    public static void merge(int start, int end, int start1, int end1, List<Integer> arr){

        List<Integer> tempList = new ArrayList<>(end1-start+1);
        int tempStart =start;

        while(start<=end && start1<=end1){

            if(arr.get(start)<=arr.get(start1)){
                tempList.add(arr.get(start++));
            }else{
                tempList.add(arr.get(start1++));
            }
        }

        while(start<=end){
            tempList.add(arr.get(start++));
        }

        while(start1<=end1){
            tempList.add(arr.get(start1++));
        }

        //copy tempArray to arr
        for(int i = tempStart, j = 0; i<= end1; i++)
            arr.set(i,tempList.get(j++));
    }

    public static void main(String[] args) {
        System.out.println(merge_sort(new ArrayList<>(Arrays.asList(-3,5,1,11,33,5,6,0))));
    }
}
