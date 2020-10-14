package algorithms.greedy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * At most one transaction.
 * Time complexity : O(n)
 * Space Complexity : O(1)
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        int profit =0;

        if(prices.length<=1){
            return profit;
        }

        int cost =prices[0];

        for(int i=1;i<prices.length;i++){
            profit = Math.max(profit, prices[i]-cost);
            cost =Math.min(cost,prices[i]);
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{}));
    }
}
