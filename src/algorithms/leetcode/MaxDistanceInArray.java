package algorithms.leetcode;

import java.util.List;

public class MaxDistanceInArray {



    /**
     *
     * https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3479/
     *
     * First version _ O( N^2) timed out.
     * This looks almost same but with large time complexity.
     *  public int maxDistance(List<List<Integer>> arrays) {
     *
     *         int maxDistance = Integer.MIN_VALUE;
     *
     *         for(int i=0;i<arrays.size()-1;i++){
     *             int min = arrays.get(i).get(0);
     *             int max =  arrays.get(i).get(arrays.get(i).size()-1);
     *
     *             for(int j=i+1;j<arrays.size();j++){
     *                 int tempMin = arrays.get(j).get(0);
     *                 int tempMax =  arrays.get(j).get(arrays.get(j).size()-1);
     *                 maxDistance = Math.max(maxDistance,Math.abs(min-tempMax));
     *                 maxDistance = Math.max(maxDistance,Math.abs(max-tempMin));
     *                 maxDistance = Math.max(maxDistance,Math.abs(max-tempMax));
     *                 maxDistance = Math.max(maxDistance,Math.abs(min-tempMin));
     *             }
     *         }
     *         return maxDistance;
     *     }
     */

    /*Optimal Solution
        Time _ O(n)
        Space - O(n)
    */
    public int maxDistance(List<List<Integer>> arrays) {

        int maxDistance = Integer.MIN_VALUE;

        int min = arrays.get(0).get(0);
        int max =  arrays.get(0).get(arrays.get(0).size()-1);

        for(int j=1;j<arrays.size();j++){
            int tempMin = arrays.get(j).get(0);
            int tempMax =  arrays.get(j).get(arrays.get(j).size()-1);

            maxDistance = Math.max(maxDistance,Math.abs(min-tempMax));
            maxDistance = Math.max(maxDistance,Math.abs(max-tempMin));
            maxDistance = Math.max(maxDistance,Math.abs(max-tempMax));
            maxDistance = Math.max(maxDistance,Math.abs(min-tempMin));

            min = Math.min(min,tempMin);
            max = Math.max(max,tempMax);
        }
        return maxDistance;
    }
}
