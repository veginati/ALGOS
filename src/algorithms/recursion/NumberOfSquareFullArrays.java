package algorithms.recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-squareful-arrays/
 * Time complexity in the worst every pair is unique and every pair forms a square
 *  O(n!)
 *  N =3 , {51,70,30}
 */
public class NumberOfSquareFullArrays {

    public static int numSquarefulPerms(int[] A) {

        return findSquare(0,A);
    }

    public static int findSquare(int index, int[] A){

        int total =0;
        if(index == A.length)
            return perfectSquare(A[index-1],A[index-2])?1:0;

        if(index>=2 && !perfectSquare(A[index-1],A[index-2]))
            return 0;

        Set<Integer> values = new HashSet<>();
        for(int i=index;i<A.length;i++){

            if(!values.add(A[i]))
                continue;

            swap(A,index,i);
            total+=findSquare(index+1,A);
            swap(A,index,i);
        }

        return total;
    }



    private static void swap(int[] A, int i, int j){
        int temp =A[i];
        A[i]=A[j];
        A[j]=temp;
    }

    private static boolean perfectSquare(int[] A){
        for(int i=1;i<A.length;i++){
            int value = (int) Math.sqrt(A[i]+A[i-1]);
            if(value*value!=A[i]+A[i-1])
                return false;
        }
        return true;
    }

    private static boolean perfectSquare(int x,int y){
        int value = (int) Math.sqrt(x+y);
        return value*value==(x+y);
    }

    public static void main(String[] args) {
        System.out.println(numSquarefulPerms(new int[]{8,17,8,17}));
        System.out.println(numSquarefulPerms(new int[]{75,91,39,33,39,39,69,20,43,38,48,29}));
    }
}
