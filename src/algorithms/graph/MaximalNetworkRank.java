package algorithms.graph;

import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode.com/problems/maximal-network-rank/
 *  Time complexity best case O(nlogn)
 *  Worst case : O(n^2)
 *
 */
public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {

        if(roads.length==0){
            return 0;
        }

        int max=0;
        HashMap<Integer, Set<Integer>> exists = new HashMap<>();

        Pair<Integer,Integer>[] pair = new Pair[n];
        int[] connectivity = new int[n];
        for(int i=0;i<roads.length;i++){
            connectivity[roads[i][0]]++;
            connectivity[roads[i][1]]++;

            if(exists.containsKey(roads[i][0])){
                exists.get(roads[i][0]).add(roads[i][1]);
            }else{
                int value = roads[i][1];
                exists.put(roads[i][0], new HashSet<Integer>(){{add(value);}});
            }

            if(exists.containsKey(roads[i][1])){
                exists.get(roads[i][1]).add(roads[i][0]);
            }else{
                int value = roads[i][0];
                exists.put(roads[i][1], new HashSet<Integer>(){{add(value);}});
            }

        }

        List<Pair<Integer,Integer>> listobj = new ArrayList<Pair<Integer,Integer>>();

        for(int i=0;i<n;i++){
            pair[i] = new Pair(i,connectivity[i]);
        }
        Arrays.sort(pair, (a,b)->b.getValue()-a.getValue());

        for(int i=0;i<pair.length;i++){
            for(int j=i+1;j<pair.length;j++){
                Set<Integer> setObj = exists.get(pair[i].getKey());
                int total = connectivity[pair[i].getKey()]+ connectivity[pair[j].getKey()];
                if(total<max)
                    break;
                if(null!= setObj && setObj.contains(pair[j].getKey()))
                    total-=1;

                max = Math.max(max,total);
            }
        }

        return max;
    }
}