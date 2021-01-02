package algorithms.recursion.prep;

/**
 * Time complexity is O(n!)
 * T(n) = n * T(n-1) +n^2
 */
public class NQueensII {

    public int totalNQueens(int n) {
        int[] queensPlaced = new int[n];
        return countValidPlacements(n,queensPlaced,0);
    }

    public int countValidPlacements(int n, int[] queensPlaced, int row){
        if(row ==n){
            return 1;
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(!isAttacked(row,i,queensPlaced)){
                queensPlaced[row]=i;
                count+=countValidPlacements(n,queensPlaced,row+1);
                queensPlaced[row]=-1;
            }
        }
        return count;
    }

    public boolean isAttacked(int row, int col, int[] queensPlaced){

        // checking diagonal and columnar manner
        for(int i=0;i<row;i++){
            if(col == queensPlaced[i] || row-i == Math.abs(col-queensPlaced[i])){
                return true;
            }
        }

        return false;
    }
}
