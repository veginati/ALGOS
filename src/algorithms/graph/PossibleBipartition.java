package algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/possible-bipartition/
 */
public class PossibleBipartition {

    public static boolean possibleBipartition(int N, int[][] dislikes) {

        List<List<Integer>> graph = new ArrayList<>(N+1);

        for(int i=0;i<=N;i++)
            graph.add(new ArrayList<>());

        for(int[] dislike:dislikes)
            graph.get(dislike[0]).add(dislike[1]);

        boolean[] visited = new boolean[N+1];
        int[] level = new int[N+1];
        int[] tree = new int[N+1];
        int count=0;
        for(int i=1;i<=N;i++){
            if(!visited[i] && !isPossibleBiPartition(graph, i,visited,level, count++,tree)){
                return false;
            }
        }

        return true;
    }

    public static boolean isPossibleBiPartition(List<List<Integer>> graph, int node, boolean[] visited, int[] level, int count,int[] tree){

        visited[node] =true;
        level[node]=0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        tree[node] =count;

        while(queue.size()>0){
            Integer data = queue.poll();
            for(Integer nei:graph.get(data)){
                if(!visited[nei]){
                    visited[nei] = true;
                    level[nei] = 1+level[data];
                    tree[nei] = count;
                    queue.offer(nei);
                }else{
                    // if the cross edge is at the same level, it will form a cycle of odd length,
                    // Odd length cycles are not bi-partite
                    if(tree[nei] == tree[data] && Math.abs(level[nei]-level[data])%2 ==0){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Example below forms a cycle of odd length, therefore the graph is not bi-partite graph
        System.out.println(possibleBipartition(5, new int[][]{{1,2}, {2,3},{3,4},{4,5},{1,5}}) == false);
    }
}
