package algorithms.ad;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;

public class PacificAtlantic {
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        boolean[][] po = new boolean[heights.length][heights[0].length];
        boolean[][] ao = new boolean[heights.length][heights[0].length];
        

        Deque<int[]> poIndex = new ArrayDeque<>();
        Deque<int[]> aoIndex = new ArrayDeque<>();

        for(int row=0;row<heights.length;row++){
            po[row][0]=true;
            poIndex.offerLast(new int[]{row,0});
        }
        for(int col=0;col<heights[0].length;col++){
            po[0][col]=true;
            poIndex.offerLast(new int[]{0,col});
        }

        for(int row=0;row<heights.length;row++){
            ao[row][heights[0].length-1]=true;
            aoIndex.offerLast(new int[]{row,heights[0].length-1});
        }
        for(int col=0;col<heights[0].length;col++){
            ao[heights.length-1][col]=true;
            aoIndex.offerLast(new int[]{heights.length-1,col});
        }

        // for(int i=0;i<po.length;i++){
        //     System.out.println(Arrays.toString(po[i]));
        // }

        bfs(heights, po, poIndex);
        // System.out.println("#####");
        // for(int i=0;i<po.length;i++){
        //     System.out.println(Arrays.toString(po[i]));
        // }
        bfs(heights, ao, aoIndex);

        List<List<Integer>> output = new ArrayList<>();

        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(po[i][j] && ao[i][j]){
                    output.add(List.of(i,j));
                }
            }
        }
        return output;
    }

    public void bfs(int[][] heights,boolean[][] po,  Deque<int[]> queueObj){
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while(queueObj.size()>0){
            int[] curr = queueObj.pollFirst();

            for(int[] dir : dirs){

                int row = dir[0] + curr[0];
                int col = dir[1] + curr[1];

                if( row < 0 || col <0 || row>=heights.length || col>= heights[0].length){
                    continue;
                }

                if(po[row][col]){
                    continue;
                }

                if(heights[curr[0]][curr[1]]<=heights[row][col]){
                    po[row][col]=true;
                    queueObj.offerLast(new int[]{row,col});
                }
            }
        }

    }
}