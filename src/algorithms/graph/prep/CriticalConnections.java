package algorithms.graph.prep;

import java.util.*;

public class CriticalConnections {
    static int time=0;
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        Set<List<Integer>> output = new HashSet<>();

        //Build Graph
        List<List<Integer>> graph = new ArrayList<>(n);
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<Integer>());

        for(List<Integer> i:connections){
            graph.get(i.get(0)).add(i.get(1));
            graph.get(i.get(1)).add(i.get(0));
        }

        boolean[] visited = new boolean[n];
        int[] timer = new int[n];

        dfs(graph, output,visited, 0,-1,timer);
        return new ArrayList<>(output);
    }

    public static void dfs( List<List<Integer>> graph, Set<List<Integer>> output,
                     boolean[] visited, int node, int parent,int[] timer){

        visited[node] =true;
        timer[node]= ++time;
        int currentTime = timer[node];

        for(Integer nei: graph.get(node)){

            if(nei== parent)
                continue;
            if(!visited[nei]){
                dfs(graph, output,visited,nei,node,timer);
            }
            timer[node] = Math.min(timer[nei],timer[node]);

            if(currentTime<timer[nei])
                output.add(new ArrayList<Integer>(){{add(node);add(nei);}});
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1,0));
        input.add(Arrays.asList(2,0));
        input.add(Arrays.asList(3,2));
        input.add(Arrays.asList(4,2));
        input.add(Arrays.asList(4,3));
        input.add(Arrays.asList(3,0));
        input.add(Arrays.asList(4,0));

        List<List<Integer>> criticalConnections = criticalConnections(5, input);
        System.out.println(criticalConnections);
    }
}
