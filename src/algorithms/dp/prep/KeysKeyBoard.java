package algorithms.dp.prep;

/**
 * Time complexity is O(n^2)
 * Space complexity is O(n)
 */
public class KeysKeyBoard {

    public static int maxA(int N) {

        int[] dp = new int[N+1];

        for(int i=1;i<=N;i++)
            dp[i]=i;

        int x=1;
        for(int i=5;i<=N;i++){

            int value = Integer.MIN_VALUE;

            for(int j=i-3,k=2;j>0;j--,k++){
                if(dp[j]*k>value){
                    value = dp[j]*k;
                }
            }
            dp[i] = Math.max(dp[i], value);
        }

        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(maxA(11));
        System.out.println(maxA(10));
        System.out.println(maxA(7));
    }
}
