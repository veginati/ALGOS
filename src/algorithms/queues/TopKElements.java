package algorithms.queues;

import javafx.util.Pair;

import java.util.*;

/** https://leetcode.com/problems/top-k-frequent-elements/
 *  Time complexity : O(N log K)
 *  if k = n, time complexity is O(1), because all elements are unqiue.
 *  Space depends on number of unique elements in the numbers.
 */

public class TopKElements {

    public static int[] topKFrequent(int[] nums, int k) {

        if(k == nums.length){
            return nums;
        }else if(nums.length ==0){
            return new int[]{};
        }

        //Map - unique number & count ------   O(n) time for iterating numbers
        // space depends on O(Unique numbers)

        // Create Pairs (count, integer) // add pairs to heap

        Map<Integer,Integer> countUniqueNumbers = new HashMap<>();

        for (int num : nums) {
            countUniqueNumbers.put(num, 1 + countUniqueNumbers.getOrDefault(num, 0));
        }

        Set<Integer> uniqueIntegers = countUniqueNumbers.keySet();
        Iterator<Integer> iteratorObj = uniqueIntegers.iterator();
        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));

        while(iteratorObj.hasNext()){

            int key = iteratorObj.next();
            int value = countUniqueNumbers.get(key);
            queue.add(new Pair<>(value,key));

            if(queue.size()>k)
                queue.poll();
        }

        int[] output = new int[k];

        for(int i=0;i<k;i++)
            output[i] = Objects.requireNonNull(queue.poll()).getValue();

        return output;
    }

    public static void main(String[] args) {

        topKFrequent(new int[]{1,1,1,2,2,3,4,4,4,4,6,1,1,3,4,2,2},2); // output : [1,4]
    }
}
