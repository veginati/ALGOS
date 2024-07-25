package algorithms.m8;

import java.util.ArrayDeque;
import java.util.Deque;

public class Longestones {
      public static int longestOnes(int[] nums, int k) {

        int startIdx=0;
        int maxLen=0;
        int currIdx=0; 
        //int tempK=k;
        Deque<Integer> queueObj = new ArrayDeque<>();

        while(currIdx<nums.length){

            if(nums[currIdx] == 0 ){
                if(queueObj.size()==k){
                    int traverseIdx = queueObj.size()>0? queueObj.pollFirst() : currIdx;
                    while(startIdx<=traverseIdx){
                       ++startIdx;
                    }
                }
                if(k>0){
                    queueObj.offerLast(currIdx);
                }
            }
            maxLen = Math.max(maxLen, currIdx-startIdx+1);
            currIdx++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 0) ==4);
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3) ==10);
    }
}
