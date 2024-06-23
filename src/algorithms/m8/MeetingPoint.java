package algorithms.m8;

import java.util.ArrayList;
import java.util.List;

// Table pattern
// DP
public class MeetingPoint {
    
    public int minTotalDistance(int[][] grid) {
        List<int[]> locations = new ArrayList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    locations.add(new int[]{i, j});
                }
            }
        }

        int row=0;
        int col=0;
        int rowIndexMinCost=Integer.MAX_VALUE;
        int colIndexMinCost=Integer.MAX_VALUE;
        for(;col<grid[row].length;col++){
            int rowIndexCost=0;
            int colIndexCost=0;
            for(int[] loc:locations){
                rowIndexCost+=Math.abs(loc[0]-0);
                colIndexCost+=Math.abs(loc[1]-col);
            }
            rowIndexMinCost = Math.min(rowIndexMinCost, rowIndexCost);
            colIndexMinCost = Math.min(colIndexMinCost, colIndexCost);
        }

        col=0;
        for(row=0;row<grid.length;row++){
            int rowIndexCost=0;
            int colIndexCost=0;
            for(int[] loc:locations){
                rowIndexCost+=Math.abs(loc[0]-row);
                colIndexCost+=Math.abs(loc[1]-0);
            }
            rowIndexMinCost = Math.min(rowIndexMinCost, rowIndexCost);
            colIndexMinCost = Math.min(colIndexMinCost, colIndexCost);
        }
        return rowIndexMinCost+colIndexMinCost;
    }
}
