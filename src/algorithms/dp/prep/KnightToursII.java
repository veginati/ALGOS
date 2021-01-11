package algorithms.dp.prep;

/**
 * Time complexity is O(n*K)
 * K = constant factor ( 10 numbers and neighbors of each dial)
 *  Space complexity is O(n * T) T =10;
 */
public class KnightToursII {

    static int[][] moves = {{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};

    public static int knightDialer(int n) {
        int mod = 1_000_000_000+7;
        if(n ==1)
            return 10;

        int[][] dp = new int[10][2];

        for(int i=0;i<10;i++)
            dp[i][0] = moves[i].length;

        for(int i=1;i<n-1;i++){

            int tem = (i-1)%2;

            for(int dial=0;dial<10;dial++){
                int count =0;
                for(int nei:moves[dial]){
                    count = (count + dp[nei][tem])%mod;
                }
                dp[dial][i%2] = count;
            }
        }

        int total=0;

        for(int dial=0;dial<10;dial++){
            total = (total+ dp[dial][(n-2)%2])%mod;
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(knightDialer(10));
    }
}
