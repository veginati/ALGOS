package algorithms.graph;

/**
 * https://leetcode.com/problems/number-of-islands/
 * Time complexity is O(M*N)
 * Space Complexity is O(M*N) stack when all the nodes are connected.
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {

        int count =0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] =='1'){
                    ++count;
                    dfs(grid,i,j);
                }
            }
        }

        return count;
    }


    public static void dfs(char[][] grid, int row , int col){

        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || !('1'== grid[row][col])){
            return;
        }
        grid[row][col]='2';

        dfs(grid,row+1,col);
        dfs(grid,row,col+1);
        dfs(grid,row-1,col);
        dfs(grid,row,col-1);
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.print(numIslands(grid) ==1);
    }
}