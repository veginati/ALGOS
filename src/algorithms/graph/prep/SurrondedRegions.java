package algorithms.graph.prep;

import java.util.Arrays;

public class SurrondedRegions {
    static int[][] dirs   ={{0,1},{1,0},{0,-1},{-1,0}};

    public void solve(char[][] board) {

        if(board.length ==0)
            return;

        boolean[][] visited = new boolean[board.length][board[0].length];

        //first col
        for(int i=0;i<board.length;i++){
            if(board[i][0] =='O'&&!visited[i][0])
                dfs(i,0,board,visited);
        }
        //first row
        for(int i=0;i<board[0].length;i++){
            if(board[0][i] =='O' &&!visited[0][i])
                dfs(0,i,board,visited);
        }

        //last col
        for(int i=0;i<board.length;i++){
            if(board[i][board[0].length-1] =='O' && !visited[i][board[0].length-1])
                dfs(i,board[0].length-1,board,visited);
        }
        //last row
        for(int i=0;i<board[0].length;i++){
            if(board[board.length-1][i] =='O' && !visited[board.length-1][i])
                dfs(board.length-1,i,board,visited);
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){

                if(board[i][j]=='O' && !visited[i][j])
                    board[i][j]='X';

            }
        }
    }

    public void dfs(int row, int col, char[][] board, boolean[][] visited){

        if(row<0 || col<0 || row>=board.length || col>= board[0].length || board[row][col] =='X' ||visited[row][col])
            return;

        visited[row][col]=true;

        for(int[] dir:dirs){
            dfs(row+dir[0],col+dir[1],board,visited);
        }
    }

    public static void main(String[] args) {
        SurrondedRegions surrRegion = new SurrondedRegions();

        char[][] board = {{'O','X','X'},{'X','O','X'},{'X','O','X'},{'X','X','X'}};
        surrRegion.solve(board);
        for(char[] layer:board)
        System.out.println(Arrays.toString(layer));
    }
}
