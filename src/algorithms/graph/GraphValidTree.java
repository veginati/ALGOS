package algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  Either follow BFS or DFS approach
 *  Two approaches are mentioned in this class.
 *
 */
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {

        // Graph with no cycles and a single connected component is a tree.

        //dfs approach there shouldn't be a backedge

        // build a graph using adj list

        List<List<Integer>> graph = new ArrayList<>(n);

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<Integer>());

        // undirected graph
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // bfs approach there shouldn't be cross edge
        //visited nodes
        boolean[] visited  = new boolean[n];
        int count =0;
        for(int i=0;i<n;i++){
            if(count ==0 && !visited[i] &&!bFSApproach(graph,n,visited)){
                return false;
            }else if(count>0 && !visited[i]){
                return false;
            }
           ++count;
        }

        //dfs appraoch
        count =0;
         visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(count>0){
                    return false;
                }else {
                    if(dFSApproach(graph,i,visited, -1))
                        return false;
                }
                ++count;
            }
        }
        return true;
    }

    public boolean bFSApproach(List<List<Integer>> graph, int n,boolean[] visited){

        //parent node
        int[] parent = new int[n];

        //starting from vertex 0
        List<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0]=true;

        while(queue.size()>0){

            int nodePolled = queue.remove(0);

            for(Integer nei : graph.get(nodePolled)){

                if(!visited[nei]){
                    visited[nei] =true;
                    parent[nei]= nodePolled;
                    queue.add(nei);
                }else{
                    //cross edge
                    if(nei != parent[nodePolled]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean dFSApproach(List<List<Integer>> graph, int node,boolean[] visited,int parent){
        visited[node] =true;
        for(Integer nei : graph.get(node)){
            if(!visited[nei]){
                if(dFSApproach(graph,nei,visited,node)){
                    return true;
                }
            }else if(nei != parent ){
                //back edge
                return true;
            }
        }
        return false;
    }
}
