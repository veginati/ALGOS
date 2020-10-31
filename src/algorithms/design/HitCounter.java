package algorithms.design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/design-hit-counter/
 *
 */
public class HitCounter {


    Deque<Integer> hits = null;
    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new ArrayDeque<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        hits.offerLast(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {

        while(hits.size()>0 && hits.peekFirst()<=(timestamp-300)){
            hits.pollFirst();
        }
        return hits.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */