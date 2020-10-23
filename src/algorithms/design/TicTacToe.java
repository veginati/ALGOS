package algorithms.design;

import java.util.HashSet;

/**
 * Time is O(n)
 * Space is O(n*n)
 */
public class TicTacToe {

        int[][] mem;
        int tempTotal;
        int n;
        HashSet<Integer> player1RowSet =new HashSet<>();
        HashSet<Integer> player1ColSet =new HashSet<>();
        HashSet<Integer> player2RowSet =new HashSet<>();
        HashSet<Integer> player2ColSet =new HashSet<>();
        HashSet<Integer> diagonal =new HashSet<>();
        HashSet<Integer> antidiagonal =new HashSet<>();
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            mem = new int[n][n];
            tempTotal=0;
            this.n =n;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {

            mem[row][col] = player;
            ++tempTotal;

            if(player == 1){
                player1RowSet.add(row);
                player1ColSet.add(col);
            }else{
                player2RowSet.add(row);
                player2ColSet.add(col);
            }

            if(row == col)
                diagonal.add(player);
            if(row+col ==n-1)
                antidiagonal.add(player);

            if(tempTotal>= n){
                if(player ==1 ){
                    if(isValidRowAndCol(row,col,player2ColSet,player2RowSet,player))
                        return player;
                }else{
                    if(isValidRowAndCol(row,col,player1ColSet,player1RowSet,player))
                        return player;
                }

                if((player ==1 && !diagonal.contains(2)) || (player ==2 && !diagonal.contains(1))){
                    if(validPlayerDiagonal(n,player))
                        return player;
                }

                if((player ==1 && !antidiagonal.contains(2)) || (player ==2 && !antidiagonal.contains(1))){
                    if(validPlayerAntiDiagonal(n,player))
                        return player;
                }
            }

            return 0;
        }


        private boolean validPlayerAntiDiagonal(int n, int player){
            int count =0;
            for(int i=n-1,j=0;i>=0;i--,j++){
                if(mem[j][i]!=player)
                    break;
                ++count;
            }
            return count ==n;
        }

        private boolean validPlayerDiagonal(int n, int player){
            int count =0;
            for(int i=0;i<n;i++){
                if(mem[i][i]!=player)
                    break;
                ++count;
            }
            return count ==n;
        }

        private boolean isValidRowAndCol(int row, int col, HashSet colSet, HashSet rowSet, int player){
            int count =0;
            if(!colSet.contains(col)){

                for(int i=0;i<n;i++){
                    if(mem[i][col]!=player)
                        break;
                    ++count;
                }

                if(count ==n)
                    return true;
            }

            count =0;
            if(!rowSet.contains(row)){
                for(int i=0;i<n;i++){
                    if(mem[row][i]!=player)
                        break;
                    ++count;
                }
            }
            return count ==n;
        }
    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
