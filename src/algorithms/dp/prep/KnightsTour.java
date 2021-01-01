package algorithms.dp.prep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given 1 2 3
 *       4 5 6
 *       7 8 9
 *       - 0 -
 *       keypad
 *       Given a starting digit, and phone number length count, find the number of ways a user can type a board.
 *       Repetitions allowed
 *       Only L shaped moves are allowed (similar to Knights moves).
 *        n = phone number length
 *        c = constant phone digits, and moves
 *        Counting path of a phone number length given start digit,
 *        counting problem.
 *       Time complexity is O(n *c) = O(n)
 *       Space compleixty is O(n)
 */
public class KnightsTour {

    /*
     * Complete the numPhoneNumbers function below.
     */
    static long numPhoneNumbers(int startdigit, int phonenumberlength) {
        /*
         * Write your code here.
         */
        //base case
        if(phonenumberlength<=1)
            return phonenumberlength+0L;

        // dictonary
        Map<Integer, List<Integer>> dict = new HashMap<>();
        dict.put(0, Arrays.asList(4,6));
        dict.put(1,Arrays.asList(6,8));
        dict.put(2,Arrays.asList(7,9));
        dict.put(3,Arrays.asList(4,8));
        dict.put(4,Arrays.asList(3,9,0));
        dict.put(5,Arrays.asList());
        dict.put(6,Arrays.asList(1,7,0));
        dict.put(7,Arrays.asList(2,6));
        dict.put(8,Arrays.asList(1,3));
        dict.put(9,Arrays.asList(2,4));

        if(phonenumberlength==2)
            return dict.get(startdigit).size()+0L;

        long[][] cache = new long[10][phonenumberlength+1];

        for(int i=0;i<10;i++)
            cache[i][2] = dict.get(i).size();

        for(int i=3;i<=phonenumberlength;i++){
            for(int j=0;j<10;j++){
                long total=0L;
                for(Integer num:dict.get(j))
                    total+=cache[num][i-1];
                cache[j][i]=total;
            }
        }

        return cache[startdigit][phonenumberlength];
    }

    public static void main(String[] args) {
        /**
         *                      1
         *               6           8
         *         1    7    0     1    3
         *        6 8  2 6  4 6   6 8  4 8
         *        Total path = 10
         */
        System.out.println(numPhoneNumbers(1,4));
        System.out.println(numPhoneNumbers(6,30));
    }
}
