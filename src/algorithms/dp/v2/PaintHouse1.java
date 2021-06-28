package algorithms.dp.v2;

public class PaintHouse1 {

    /**
     * Time cost is O(n) where n is the no. of houses.
     * @param costs costs of houses with 3 paint colors.
     * @return min cost to paint all the houses, where no adj houses will have same color.
     */
    public static int minCost(int[][] costs) {

        for(int i=1;i<costs.length;i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
        }

        return Math.min(Math.min(costs[costs.length-1][0], costs[costs.length-1][1]), costs[costs.length-1][2]);
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{{3,4,5},{16,1,2},{1,5,15}}));
        System.out.println(minCost(new int[][]{{16,1,2},{2342,424,1}}));
    }
}
