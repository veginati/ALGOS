package algorithms.greedy;

import java.util.PriorityQueue;

public class MaxSumDivideByThree {
    public static int maxSumDivThree(int[] nums) {

        int total=0;
        PriorityQueue<Integer> oneBag = new PriorityQueue<Integer>((a, b)->b-a);
        PriorityQueue<Integer> twoBag = new PriorityQueue<Integer>((a,b)->b-a);
        int tempTotal=0;

        for(int number:nums){

            if(number%3==0){
                total+=number;
            }else if(number%3==1){
                oneBag.offer(number);
                tempTotal+=number;
            }else{
                twoBag.offer(number);
                tempTotal+=number;
            }

            if(oneBag.size()>2)
                oneBag.poll();
            if(twoBag.size()>2)
                twoBag.poll();
        }

        if(tempTotal%3 ==1){
            if(oneBag.size()==2)
                oneBag.poll();
            int tempOne = (oneBag.size()<1)?Integer.MAX_VALUE:oneBag.poll();
            int tempTwo = (twoBag.size()<2)?Integer.MAX_VALUE:twoBag.poll()+twoBag.poll();
            tempTotal-=Math.min(tempOne,tempTwo);
        }else if(tempTotal%3 ==2){
            if(twoBag.size()==2)
                twoBag.poll();
            int tempOne = (oneBag.size()<2)?Integer.MAX_VALUE:oneBag.poll()+oneBag.poll();
            int tempTwo = (twoBag.size()<1)?Integer.MAX_VALUE:twoBag.poll();
            tempTotal-=Math.min(tempOne,tempTwo);
        }
        total+=tempTotal;
        return total;
    }

    public static void main(String[] args) {
        System.out.println(maxSumDivThree(new int[]{1,2,3,4,4}));
    }
}
