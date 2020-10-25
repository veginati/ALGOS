package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class Intersection {

    public static List<Integer> findIntersection(int[] a, int[] b){

        List<Integer> output = new ArrayList<>();

        for(int i=0,j=0;i<a.length &&j<b.length;){

            if(a[i] == b[j]){
               output.add(a[i]);
               i++;
               j++;
            }else if(a[i]<b[j]){
                i++;
            }else {
                j++;
            }
        }
        return output;
    }

    public static void main(String[] args) {

        System.out.print(findIntersection(new int[]{1,2,3,6,7,8,9}, new int[]{3,6,8,10,12,15}));
    }
}
