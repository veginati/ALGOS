package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IslandII {

    class Graph{
        int[] parent;
        int[] rank;
        int count =0;

        public Graph(int m,int n){
            parent = new int[m*n];
            rank = new int[m*n];
            Arrays.fill(parent,-1);
        }

        public int findParent(int n){

            if(parent[n]!=n){
                parent[n] = findParent(parent[n]);
            }
            return parent[n];
        }

        public void union(int n, int m){

            int p1 = findParent(n);
            int p2 = findParent(m);

            if(p1!=p2){

                if(rank[p1]>rank[p2]){
                    parent[p2] =p1;
                }else if(rank[p1]<rank[p2]){
                    parent[p1] =p2;
                }else{
                    parent[p2] =p1;
                    rank[p1]++;
                }
                --count;
            }
        }

        public int[] getParent(){
            return parent;
        }

        public void setParent(int i) {
            parent[i] = i;
            ++count;
        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {


        Graph graph = new Graph(m,n);

        List<Integer> output = new ArrayList<Integer>();
        int[][] dirs ={{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] k:positions){
            int index = n* k[0]+ k[1];
            Integer tempPointIndex = null;

            if(graph.parent[index] !=-1){
                output.add(graph.count);
                continue;
            }
            graph.setParent(index);
            for(int[] dir:dirs){
                int row = dir[0]+k[0];
                int col = dir[1]+k[1];
                if(row<0 || col<0 || row>=m || col>=n)
                    continue;
                int tempIndex = row*n +col;
                if(graph.parent[tempIndex] ==-1)
                    continue;
                graph.union(tempIndex,index);
            }
            output.add(graph.count);
        }
        return output;

    }

    public static void main(String[] args) {
        IslandII islandII = new IslandII();

        System.out.println(islandII.numIslands2(3,3,new int[][]{{0,0},{0,1},{1,2},{2,1},{1,0},{0,0},{2,2},{1,2},{1,1},{0,1}}));
    }
}
