package algorithms.trees.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinTimeCollect {
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        List<List<Integer>> graph = new ArrayList<>(n);

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];

        int count = getTime(0,hasApple,graph,visited);
        return count>0?count-2:0;
    }

    public static int getTime(int node, List<Boolean> hasApple, List<List<Integer>> graph,boolean[] visited){

        visited[node]=true;
        if(graph.get(node).size()==0){
            return hasApple.get(node)?2:0;
        }

        int count =0;

        for(Integer nei:graph.get(node)){
            if(!visited[nei])
                count+=getTime(nei,hasApple,graph,visited);
        }

        return count>0?(count+2):hasApple.get(node)?2:0;
    }

    public static void main(String[] args) {
        System.out.println(minTime(4, new int[][]{{0,2},{0,3},{1,2}}, Arrays.asList(false,true,false,false)));
    }
}
