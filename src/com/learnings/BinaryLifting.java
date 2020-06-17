package com.learnings;

import java.util.ArrayList;
import java.util.Arrays;

// Referred from Geek For Geeks.
public class BinaryLifting {

    ArrayList<Integer> graphRep[] = null;
    int dp[][] = null;
    int level[] = null;
    int maxDepth=-1;

    BinaryLifting(){

        // Number of nodes
        int n = 9;
        graphRep = new ArrayList[n + 1];

        maxDepth = (int) Math.ceil(Math.log(n)/Math.log(2));
        level = new int[n+1];
        dp = new int[n+1][maxDepth+1];

        // Initialising memo values with -1
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        for (int i = 0; i <= n; i++)
            graphRep[i] = new ArrayList<>();
        // Add edges
        graphRep[1].add(2);
        graphRep[2].add(1);
        graphRep[1].add(3);
        graphRep[3].add(1);
        graphRep[1].add(4);
        graphRep[4].add(1);
        graphRep[2].add(5);
        graphRep[5].add(2);
        graphRep[3].add(6);
        graphRep[6].add(3);
        graphRep[3].add(7);
        graphRep[7].add(3);
        graphRep[3].add(8);
        graphRep[8].add(3);
        graphRep[4].add(9);
        graphRep[9].add(4);


    }

    public void depthFirstSearch(int node, int parent){
        //base case
        dp[node][0]=parent;

        for(int i=1;i<=maxDepth;i++){
            dp[node][i] = dp[dp[node][i-1]][i-1];
        }
        for(int neighbour:graphRep[node]){

            if(neighbour !=parent){
                level[neighbour]= 1+level[node];
                depthFirstSearch(neighbour,node);
            }
        }
    }

    public int leastCommonAncestor(int u, int v){
        // The node which is present farthest
        // from the root node is taken as u
        // If v is farther from root node
        // then swap the two
        if (level[u] < level[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        // Finding the ancestor of u
        // which is at same level as v
        for (int i = maxDepth; i >= 0; i--) {
            if ((level[u] - (int)Math.pow(2, i)) >= level[v])
                u = dp[u][i];
        }


        // If v is the ancestor of u
        // then v is the LCA of u and v
        if (u == v)
            return u;

        // Finding the node closest to the root which is
        // not the common ancestor of u and v i.e. a node
        // x such that x is not the common ancestor of u
        // and v but memo[x][0] is
        for (int i = maxDepth; i >= 0; i--) {
            if (dp[u][i] != dp[v][i]) {
                u = dp[u][i];
                v = dp[v][i];
            }
        }

        return dp[u][0];
    }

    public static void main(String[] args) {

        BinaryLifting binaryLifting = new BinaryLifting();
        binaryLifting.depthFirstSearch(1,1);

       System.out.println( binaryLifting.leastCommonAncestor(1,6));
        System.out.println( binaryLifting.leastCommonAncestor(6,9));
        System.out.println( binaryLifting.leastCommonAncestor(7,8));
    }
}

