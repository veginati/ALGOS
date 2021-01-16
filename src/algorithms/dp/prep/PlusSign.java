package algorithms.dp.prep;

/**
 * Time and space O(N^2)
 *
 */
public class PlusSign {

    public static int orderOfLargestPlusSign(int N, int[][] mines) {

        if(mines.length ==0){
            return N/2;
        }else if (mines.length == N*N){
            return 0;
        }

        boolean[][] area = new boolean[N][N];
        int output =1;
        for(int[] mine:mines)
            area[mine[0]][mine[1]]=true;

        int[][] left = new int[N][N];
        int[][] top = new int[N][N];
        for(int i=0;i<N;i++){
            left[0][i] = (area[0][i])?0:1;
            top[0][i] = (area[0][i])?0:1;
        }

        for(int i=0;i<N;i++){
            left[i][0] = (area[i][0])?0:1;
            top[i][0] = (area[i][0])?0:1;
        }

        for(int i=1;i<N;i++){
            for(int j=1;j<N;j++){
                if(!area[i][j]){
                    top[i][j] = 1+ top[i-1][j];
                    left[i][j] = 1+left[i][j-1];
                }
            }
        }

        int[][] bottom = new int[N][N];
        int[][] right = new int[N][N];

        for(int i=N-1;i>=0;i--){
            bottom[N-1][i] = (area[N-1][i])?0:1;
            right[N-1][i] = (area[N-1][i])?0:1;
        }

        for(int i=N-1;i>=0;i--){
            bottom[i][N-1] = (area[i][N-1])?0:1;
            right[i][N-1] = (area[i][N-1])?0:1;
        }

        for(int i=N-2;i>=0;i--){
            for(int j=N-2;j>=0;j--){
                if(!area[i][j]){
                    bottom[i][j] = 1+ bottom[i+1][j];
                    right[i][j] = 1+right[i][j+1];
                    output = Math.max(output, Math.min(Math.min(left[i][j], right[i][j]), Math.min(bottom[i][j],top[i][j])));
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(orderOfLargestPlusSign(5,new int[][]{{3,0},{3,3}}));
    }
}
