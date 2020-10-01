package algorithms.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {

        Deque<int[]> stack = new ArrayDeque<>();
        int max=0;

        for(int i=0;i<heights.length || !stack.isEmpty() ;i++){

            if(stack.isEmpty()){
                stack.offerFirst(new int[]{heights[i],1});
            }else{

                int count =0;

                while(!stack.isEmpty() && ( i>=heights.length  || ( i<heights.length && stack.peekFirst()[0]>heights[i]))){

                    int[] data = stack.pollFirst();
                    max = Math.max(max,data[0]*(data[1]+count));
                    count+=data[1];
                }
                if(i<heights.length)
                    stack.offerFirst(new int[]{heights[i],(1+count)});
            }
        }

        return max;
    }

    public static void main(String[] args) {

        System.out.println(largestRectangleArea(new int[]{1,2147483647,1,2147483647}));
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
