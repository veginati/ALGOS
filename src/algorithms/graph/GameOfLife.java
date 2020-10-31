package algorithms.graph;

/**https://leetcode.com/problems/game-of-life/
 *
 * Time compelxity : O( n^2)
 * Space Complexity : O(n^2)
 */
public class GameOfLife {

    static int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};

    public static void gameOfLife(int[][] board) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        dfs(board,visited,0,0);
    }

    public static void dfs(int[][] board, boolean[][] visited, int row, int col){

        if(row<0 || col<0 || row>=board.length || col>=board[0].length || visited[row][col]){
            return;
        }

        visited[row][col] =true;

        int currentValue = board[row][col];
        int neighborsAlive =0;

        for(int i=0;i<dirs.length;i++){
            int tempRow = dirs[i][0]+row;
            int tempCol = dirs[i][1]+col;

            if(tempRow<0 || tempCol<0 || tempRow>=board.length || tempCol>=board[0].length)
                continue;

            if(board[tempRow][tempCol] ==1)
                ++neighborsAlive;
        }

        for(int i=0;i<dirs.length;i++){
            int tempRow = dirs[i][0]+row;
            int tempCol = dirs[i][1]+col;

            dfs(board, visited, tempRow, tempCol);
        }

        if(currentValue ==1 && neighborsAlive<2){
            board[row][col] = 0;
        }else if(currentValue ==1 && neighborsAlive>=4 ){
            board[row][col] = 0;
        }else if(currentValue ==0 && neighborsAlive==3 ){
            board[row][col] = 1;
        }
        return;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        System.out.println("Initial Board");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println(" ");
        }

        gameOfLife(board);
        System.out.println("Updated Board");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}