package algorithms.dp.prep;

import java.util.ArrayDeque;
import java.util.Deque;

public class UniquePathIII {

    static class Path{
        int state;
        int[] index;
        public Path(int state, int[] i){
            this.state=state;
            this.index=i;
        }
    }
    static int[][] dirs ={{0,1},{1,0},{0,-1},{-1,0}};

    public static int uniquePathsIII(int[][] grid) {
        int maxState=0;
        int startIndex = -1;
        int endIndex = -1;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                int temp = (i*grid[0].length)+j;
                if(grid[i][j]==1){
                    startIndex = temp;
                    maxState|=(1<<temp);
                }else if(grid[i][j] == 0){
                    maxState|=(1<<temp);
                }else if(grid[i][j] ==2){
                    endIndex = temp;
                }

            }
        }

        if(startIndex ==-1 || endIndex == -1)
            return 0;

        int count=0;
        Deque<Path> currentPath = new ArrayDeque<>();
        currentPath.offer(new Path((1<<startIndex) , new int[]{startIndex/grid[0].length, startIndex%grid[0].length}));

        while(currentPath.size()>0){

            Path path = currentPath.poll();
            int[] index = path.index;
            int state = path.state;

            for(int[] dir:dirs){

                int row = index[0]+dir[0];
                int col = index[1]+dir[1];

                if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] ==-1)
                    continue;

                int value = row * grid[0].length+col;

                if((state & (1<<value)) !=0)
                    continue;

                if(grid[row][col] ==0){
                    int tempState = (state | (1<<value));
                    currentPath.offer(new Path(tempState , new int[]{row,col}));
                }else if(grid[row][col] ==2  && state == maxState){
                    ++count;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}}));
    }
}
