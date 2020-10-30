package algorithms.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/minesweeper/
 */
public class MineSweeper {

    int[] rDir= {-1,-1,0,1,1,1,0,-1};
    int[] cDir ={0,1,1,1,0,-1,-1,-1};

    public char[][] updateBoard(char[][] board, int[] click) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
        }else if(board[click[0]][click[1]] == 'E'){
            Deque<int[]> queue = new ArrayDeque<>();
            queue.offerLast(click);
            visited[click[0]][click[1]]=true;
            while(queue.size()>0){
                int[] cValues = queue.pollFirst();
                int row = cValues[0];
                int col = cValues[1];
                int count=0;
                int tempCount=0;
                for(int i=0;i<rDir.length;i++){

                    int tempRow= row+rDir[i];
                    int tempCol = col+cDir[i];

                    if(tempRow>=0 && tempCol>=0 && tempRow<board.length&& tempCol<board[0].length){
                        if(board[tempRow][tempCol] == 'M')
                            count++;
                        else if(board[tempRow][tempCol] == 'E' &&!visited[tempRow][tempCol]){
                            visited[tempRow][tempCol] =true;
                            queue.offerLast(new int[]{tempRow,tempCol});
                            tempCount++;
                        }

                    }
                }

                if(count>0){
                    board[row][col] = Character.forDigit(count,10);
                    while(tempCount>0){
                        int[] data = queue.pollLast();
                        visited[data[0]][data[1]] =false;
                        tempCount--;
                    }
                }else{
                    board[row][col] = 'B';
                }
            }
        }

        return board;
    }
}