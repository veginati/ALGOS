package algorithms.dp;

/**
 *  prefix array build O(mn)
 *  query O(1)
 *
 */
public class RangeQueryII {

    int[][] prefixSum = null;
    public RangeQueryII(int[][] matrix) {
        if(matrix.length>0){
            prefixSum = new int[1+matrix.length][1+matrix[0].length];

            for(int i=1;i<=matrix.length;i++){
                for(int j=1;j<=matrix[i-1].length;j++){
                    prefixSum[i][j] = prefixSum[i][j-1]+matrix[i-1][j-1];
                }
            }

            for(int i=1;i<=matrix[0].length;i++){
                for(int j=2;j<=matrix.length;j++){
                    prefixSum[j][i]+= prefixSum[j-1][i];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return prefixSum[row2+1][col2+1]-prefixSum[row1][col2+1] -(prefixSum[row2+1][col1]-prefixSum[row1][col1]);
    }

    public static void main(String[] args) {
        RangeQueryII rangeQueryII = new RangeQueryII(new int[][]{{10,5,6,1,1,4},{6,-7,1,4,3,5},{5,7,4,2,1,2},{5,5,5,1,4,2},{5,5,5,1,4,2}});

       System.out.println(rangeQueryII.sumRegion(0,3,4,3));
       System.out.println(rangeQueryII.sumRegion(2,1,4,5));
    }
}
