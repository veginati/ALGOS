package algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        path.add(0);
        dfs(output,path,0,graph);
        return output;
    }

    public void dfs(List<List<Integer>> output, List<Integer> path, int node, int[][] graph){

        if(node == graph.length-1){
            List<Integer> tempList = new ArrayList<Integer>(path);
            output.add(tempList);
            return;
        }

        for(int nei:graph[node]){
            path.add(nei);
            dfs(output,path,nei,graph);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new AllPaths().allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));
    }
}
