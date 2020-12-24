package algorithms.graph.prep;

public class MaxAreaIsland {

    static int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
    public static int maxAreaOfIsland(int[][] grid) {
        int max =0;
        if(null == grid)
            return max;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]==1)
                    max = Math.max(max,dfs(grid,i,j));
            }
        }

        return max;
    }

    public static int dfs(int[][] grid, int row, int col){

        if(row<0 || col < 0 || row>=grid.length || col>=grid[0].length || grid[row][col]!=1)
            return 0;

        grid[row][col]=2;

        int total=0;
        for(int[] dir:dirs){
            total+=dfs(grid,row+dir[0], col+dir[1]);
        }

        return 1+total;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{{1,0,0,1},{1,0,0,1},{1,0,0,1},{1,1,1,1}}));
    }
}
