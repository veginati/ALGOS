package algorithms.graph;

/**
 * https://leetcode.com/problems/friend-circles/
 *   Time Complexity : O(n^2) , union find - followed by path compression technique reduces union find to constant time.
 *   Space Complexity is O(n)
 */
public class FriendCircles {
    static class Graph{

        int[] parent;
        int[] rank;
        int count;
        public Graph(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            this.count =n;

            for(int i=0;i<n;i++)
                parent[i]=i;
        }

        public int findParent(int index){

            if(parent[index]!=index)
                parent[index] = findParent(parent[index]);

            return parent[index];
        }

        public void union(int index1, int index2){

            int parent1 = findParent(index1);
            int parent2 = findParent(index2);

            if(parent1 !=parent2){

                if(rank[parent1]<rank[parent2]){
                    parent[parent1]=parent2;
                }else if(rank[parent2]<rank[parent1]){
                    parent[parent2]=parent1;
                }else{
                    parent[parent1]=parent2;
                    rank[parent2]++;
                }
                --count;
            }
        }
    }

    public static int findCircleNum(int[][] M) {

        Graph graph = new Graph(M.length);

        for(int i=0;i<M.length;i++){
            for(int j=i+1;j<M.length;j++){

                if(M[i][j] ==1){
                    graph.union(i,j);
                }
            }
        }

        return graph.count;
    }

    public static void main(String[] args) {

        int[][] m = {{1,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
                {0,1,1,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,1,1,0,0,0,0,0,0,0,0,1,0,0,1},
                {0,0,0,1,0,1,0,0,1,0,0,0,0,1,0},
                {0,0,0,0,1,0,0,0,0,0,0,1,0,0,0},
                {0,0,0,1,0,1,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {1,0,0,1,0,0,0,0,1,1,1,0,0,1,0},
                {0,0,0,0,0,0,0,0,1,1,0,1,1,0,0},
                {0,0,0,0,0,0,0,0,1,0,1,1,0,0,0},
                {0,0,1,0,1,1,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,1,0,1},
                {0,1,0,1,0,0,0,0,1,0,0,0,0,1,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,1,0,1}};

        System.out.print(findCircleNum(m)==3);

    }
}
