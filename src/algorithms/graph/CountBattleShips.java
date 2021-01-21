package algorithms.graph;

public class CountBattleShips {
    public static int countBattleships(char[][] board) {

        boolean flag = false;
        int count=0;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){

                if(board[i][j] =='X' && i>0 && board[i-1][j] =='X')
                    continue;
                if(board[i][j] =='X' && j>0 && board[i][j-1] =='X')
                    continue;

                if(board[i][j] =='X' && !flag){
                    flag =true;
                    ++count;
                }else if(board[i][j] =='.' && flag){
                    flag =false;
                }
            }
            flag=false;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBattleships(new char[][]{{'.','X'},{'X','.'}}));
    }
}
