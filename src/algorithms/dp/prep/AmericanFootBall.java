package algorithms.dp.prep;

/**
 *  Possible scores {2,3,6}
 *  Find number of ways to reach 8
 *  Example for score 7 {{2,2,3},{3,2,2},{2,3,2}} -- 3 ways
 */

public class AmericanFootBall {

    public static int findWays(int number){

        if(number<2){
            return 0;
        }

        int[] scores = new int[number+1];

        //base case, not playing is the base case.
        scores[0]=1;
        for(int i=2;i<=number;i++){

            if(i>=2){
                scores[i]+=scores[i-2];
            }

            if(i>=3){
                scores[i]+=scores[i-3];
            }

            if(i>=6){
                scores[i]+=scores[i-6];
            }
        }

        return scores[number];
    }

    public static void main(String[] args) {

        System.out.println(findWays(8));
        System.out.println(findWays(15));
    }
}
