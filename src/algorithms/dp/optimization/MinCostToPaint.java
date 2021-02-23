package algorithms.dp.optimization;

import java.util.PriorityQueue;

public class MinCostToPaint {

    public static int minCostII(int[][] costs) {

        if(null == costs || costs.length == 0 ){
            return 0;
        }

        PriorityQueue<int[]> smallestKeys = new PriorityQueue<int[]>((a, b)->b[0]-a[0]);

        for(int i=0;i<costs[0].length;i++){
            if(smallestKeys.size()<2){
                smallestKeys.offer(new int[]{costs[0][i],i});
            }else if(smallestKeys.peek()[0]>costs[0][i]){
                smallestKeys.poll();
                smallestKeys.offer(new int[]{costs[0][i],i});
            }
        }

        for(int i=1;i<costs.length;i++){
            int[] secondLargest = smallestKeys.poll();
            int[] smallestValue = smallestKeys.poll();

            for(int j=0;j<costs[i].length;j++){

                int value = costs[i][j];

                if(j!=smallestValue[1]){
                    value+=smallestValue[0];
                }else{
                    value+=secondLargest[0];
                }

                if(smallestKeys.size()<2){
                    smallestKeys.offer(new int[]{value,j});
                }else if(smallestKeys.peek()[0]>value){
                    smallestKeys.poll();
                    smallestKeys.offer(new int[]{value,j});
                }
            }
        }
        if(smallestKeys.size()==2)
            smallestKeys.poll();
        return smallestKeys.poll()[0];
    }

    public static void main(String[] args) {
        System.out.println(minCostII(new int[][]{{17,9,6,2,6,18,8,12,3,5,9,11,20,8,13,16}}));
        System.out.println(minCostII(new int[][]{{1,5,3},{2,9,4},{3,4,5},{1,6,7},{9,6,5}}));
    }
}
