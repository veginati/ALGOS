package algorithms.dp.prep;

/**
 *  Possible scores {2,3,6}
 *  Find number of ways to reach 8
 *  Example for score 7 {{2,2,3},{3,2,2},{2,3,2}} -- 3 ways
 */

public class AmericanFootBall {

    /**
     * Time is O(n)
     * Space is O(n)
     * @param number
     * @return int
     */
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


    /**
     * Time is O(n)
     * Space is O(1)
     * @param number
     * @return
     */
    public static int findWaysII(int number){

        if(number<2){
            return 0;
        }

        int[] scores = new int[7];

        //base case, not playing is the base case.
        scores[0]=1;
        for(int i=2;i<=number;i++){

            if(i>=2){
                scores[i%7]=scores[(i-2)%7];
            }

            if(i>=3){
                scores[i%7]+=scores[(i-3)%7];
            }

            if(i>=6){
                scores[i%7]+=scores[(i-6)%7];
            }
        }

        return scores[number%7];
    }

    public static void main(String[] args) {

        System.out.println(findWays(8));
        System.out.println(findWays(15));
        System.out.println(findWays(30));
        System.out.println("-------------------------------------------------");
        System.out.println(findWaysII(8));
        System.out.println(findWaysII(15));
        System.out.println(findWays(30));
    }
}
