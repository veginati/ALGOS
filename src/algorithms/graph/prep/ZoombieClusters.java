package algorithms.graph.prep;

import java.util.Arrays;
import java.util.List;

public class ZoombieClusters {
    /*
     * Complete the 'zombieCluster' function below.
     *
     * The function accepts STRING ARRAY as parameter.
     */
    static class Graph{

        int[] parent;
        int[] rank;
        int clustersCount;

        public Graph(int m,int n){

            parent = new int[m*n];
            rank = new int[m*n];

            Arrays.fill(parent,-1);

            for(int i=0;i<n;i++)
                parent[i*n+i]=i*n+i;

            clustersCount=n;
        }

        public int findParent(int i){

            if(parent[i]!=i)
                parent[i]=findParent(parent[i]);
            return parent[i];
        }

        public boolean isValid(int i){
            return parent[i] ==-1;
        }

        public void union(int p1, int p2){

            int parent1 = findParent(p1);
            int parent2 = findParent(p2);

            if(parent1!=parent2){

                if(rank[parent1]<rank[parent2]){
                    parent[parent1] =parent2;
                }else if(rank[parent1]>rank[parent2]){
                    parent[parent2] =parent1;
                }else{
                    parent[parent1] =parent2;
                    rank[parent2]++;
                }
                --clustersCount;
            }
        }

        public int getCount(){
            return clustersCount;
        }

    }
    public static int zombieCluster(List<String> zombies) {
        // Write your code here

        if(null == zombies || zombies.size()==0)
            return 0;

        int row = zombies.size();
        int col = zombies.get(0).length();

        Graph graph = new Graph (row,col);

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                if(graph.isValid(col*i+j) && zombies.get(i).charAt(j)=='1'){
                    graph.parent[col*i+j] =col*j+j;
                    graph.union(col*i+i,col*i+j);
                }
            }
        }

        return graph.getCount();
    }

    public static void main(String[] args) {
        int clusters = zombieCluster(Arrays.asList("101","010","001"));
        System.out.println(clusters);
    }
}
