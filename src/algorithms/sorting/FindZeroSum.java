package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindZeroSum {

    /*
     * Complete the function below.
     */
    static String[] findZeroSum(int[] arr) {
        // Write your code here.

        Arrays.sort(arr);
        List<String> output = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i] == arr[i-1])
                continue;

            int j=i+1;
            int k= arr.length-1;

            while(j<k){

                if(arr[i]+arr[j]+arr[k] ==0){
                    output.add(arr[i]+","+arr[j]+","+arr[k]);
                    j++;
                    k--;
                    while(j<k){
                        if(arr[j]!=arr[j-1]){
                            break;
                        }
                        j++;
                    }
                }else if(arr[i]+arr[j]+arr[k]<0){
                    j++;
                }else{
                    --k;
                }
            }
        }

        String[] outputArray =new String[output.size()];
        output.toArray(outputArray);

        return outputArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findZeroSum(new int[]{10, 3, -4, 1, -6, 9})));
        System.out.println(Arrays.toString(findZeroSum(new int[]{12,34,-46})));
    }
}
