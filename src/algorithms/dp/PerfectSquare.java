package algorithms.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/perfect-squares/
 */
public class PerfectSquare {

    public static int numSquares(int n) {

        List<Integer> perfectSquare = new ArrayList<>();
        Integer[] cache = new Integer[n+1];

        int num=1;
        while(num*num<=n){
            perfectSquare.add(num*num);
            cache[num*num]=1;
            ++num;
        }

        return getMinimum(n,perfectSquare,perfectSquare.size()-1,cache);
    }

    public static int getMinimum(int number,List<Integer> ps, int index,Integer[] cache){

        if(number ==0 )
            return 0;

        if(index<=1)
            return number;

        if(null!=cache[number]){
            return cache[number];
        }

         int minNumber = Integer.MAX_VALUE;
         if(ps.get(index)<=number)
             minNumber = Math.min(Integer.MAX_VALUE, 1+getMinimum(number-ps.get(index),ps,index,cache));
         minNumber = Math.min(minNumber, getMinimum(number,ps,index-1,cache));
         cache[number] =minNumber;

        return cache[number];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(7168));
    }
}