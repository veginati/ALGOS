package algorithms.graph.prep;

import java.util.LinkedList;
import java.util.Queue;

public class KnightMoves {

    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        // Write your code here.


        int[][] dirs = {{-2,1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};

        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[rows][cols];
        int level=0;
        queue.offer(new int[]{start_row,start_col});

        while(queue.size()>0){

            int tempSize =queue.size();

            while(tempSize-->0){
                int[] data = queue.poll();

                if(data[0] == end_row && data[1] == end_col) {
                    return level;
                }

                for(int i=0;i<dirs.length;i++){

                    int tempRow = data[0]+ dirs[i][0];
                    int tempCol = data[1]+ dirs[i][1];

                    if(tempRow < 0 || tempCol <0 || tempRow >=rows || tempCol>=cols || visited[tempRow][tempCol])
                        continue;

                    queue.offer(new int[]{tempRow,tempCol});
                }

                visited[data[0]][data[1]]=true;

            }
            ++level;
        }

        return -1;
    }


    public static void main(String[] args) {

        System.out.println(find_minimum_number_of_moves(5,5,0,0,4,1)==3);
    }

}
