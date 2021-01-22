package algorithms.greedy;

import java.util.TreeMap;

/**
 * leetcode 1727
 * Time complexity is N^2 logn
 *
 */
public class LargestSubMatrix {

    public static int largestSubmatrix(int[][] matrix) {

        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]!=0){
                    matrix[i][j]+=matrix[i-1][j];
                }
            }
        }

        int max=0;
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        for(int i=0;i<matrix.length;i++){

            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]!=0){
                    treeMap.put(matrix[i][j],1+treeMap.getOrDefault(matrix[i][j],0));
                }
            }
            int count =0;
            while(treeMap.size()>0){
                int key = treeMap.lastKey();
                int value = treeMap.get(key);
                treeMap.remove(key);
                count+=value;
                max = Math.max(max,key*count);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestSubmatrix(new int[][]{{0,0,1},{1,1,1},{1,0,1}}));
    }
}
