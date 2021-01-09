package algorithms.dp;

/**
 * Time complexity is O(KN)
 * Space Complexity is O(N)
 */
public class EggDrop {

    public static int superEggDrop(int K, int N) {

        //Base Case
        if(K==1)
            return N;
        if(N<=1)
            return N;

        int[][] dp = new int[2][N+1];

        for(int i=1;i<=N;i++){
            dp[0][i] =i;
        }

        for(int egg=1;egg<K;egg++){
            int j=1;
            int prevEgg = (egg-1)%2;
            int currentEgg = egg%2;
            for(int i=1;i<=N;i++){
                while(j<i && Math.max(dp[prevEgg][j-1], dp[currentEgg][i-j]) > Math.max(dp[prevEgg][j], dp[currentEgg][i-j-1])){
                    ++j;
                }
                dp[currentEgg][i]= 1+Math.max(dp[prevEgg][j-1], dp[currentEgg][i-j]);
            }

        }

        return dp[(K-1)%2][N];
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(3,20));
        System.out.println(superEggDrop(1,100000));
        System.out.println(superEggDrop(100000,1));

    }
}
