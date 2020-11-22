package algorithms.dp.prep;

/**
 *  Given to two product (A,B) and profits on a specific day.
 *  Find the max profit.
 */
public class ProductionMaxProfit {


    public static int maxProfit(int[][] profits){

        if(profits.length==0){
            return 0;
        }

        int[][] cacheMemory = new int[profits.length][profits[0].length];

        //base case.
        cacheMemory[0][0] = profits[0][0];
        cacheMemory[1][0] = profits[1][0];

        for(int i=1;i<profits[0].length;i++){

            cacheMemory[0][i] = profits[0][i]+ Math.max(cacheMemory[0][i-1], (i>=2)?cacheMemory[1][i-2]:0);
            cacheMemory[1][i] = profits[1][i]+ Math.max(cacheMemory[1][i-1], (i>=2)?cacheMemory[0][i-2]:0);
        }

        return Math.max(cacheMemory[0][cacheMemory[0].length-1],cacheMemory[1][cacheMemory[0].length-1]);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[][]{{4,2,1,7},{1,2,5,4}}));
    }
}
