package algorithms.dp.prep;

/**
 *  Give list of houses, should rob from neighbouring houses
 *  Find the max values, optimization problem.
 *  Time complexity and Space complexity is O(n), n is the number of houses.
 * Memory can be optimized.
 */
public class HouseRobbers {

    // Complete the maxStolenValue function below.
    static int maxStolenValue(int[] values) {

        if(values.length==1)
            return values[0];

        int[] cache = new int[values.length];
        cache[0]=values[0];
        cache[1] = Math.max(cache[0],values[1]);

        for(int i=2;i<values.length;i++){
            cache[i] = Math.max(values[i]+cache[i-2],cache[i-1]);
        }

        return cache[values.length-1];
    }


    public static void main(String[] args) {
        // house with gold value
        System.out.println(maxStolenValue(new int[]{7,9,9,6,4,3,8,9,5,3,3,5}));

    }
}
