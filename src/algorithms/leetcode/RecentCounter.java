package algorithms.leetcode;

import java.util.LinkedList;
import java.util.List;

public class RecentCounter {

    List<Integer> listObj = null;
    public RecentCounter() {
        listObj = new LinkedList<>();
    }

    public int ping(int t) {
        listObj.add(t);
        while(listObj.get(0)<t-3000){
            listObj.remove(0);
        }

        return listObj.size();
    }

    public static void main(String[] args) {

        RecentCounter recentCounter = new RecentCounter();

        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(2));
        System.out.println(recentCounter.ping(3));
        System.out.println(recentCounter.ping(1000));
        System.out.println(recentCounter.ping(2000));
        System.out.println(recentCounter.ping(3000));

        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
        System.out.println(recentCounter.ping(3003));
        System.out.println(recentCounter.ping(10000));
    }
}
