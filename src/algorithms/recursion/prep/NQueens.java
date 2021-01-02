package algorithms.recursion.prep;
import java.util.List;
import java.util.ArrayList;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {

        int[] queensPlaced = new int[n];
        List<List<String>> output = new ArrayList<>();

        generateValidPlacements(n,queensPlaced,0,output);
        return output;
    }

    public void generateValidPlacements(int n, int[] queensPlaced, int row, List<List<String>> output){

        if(row ==n){
            output.add(buildOp(queensPlaced,n));
            return;
        }

        for(int i=0;i<n;i++){
            if(!isAttached(row,i,queensPlaced)){
                queensPlaced[row]=i;
                generateValidPlacements(n,queensPlaced,row+1,output);
                queensPlaced[row]=-1;
            }
        }
    }

    public boolean isAttached(int row, int col, int[] queensPlaced){

        // checking diagonal and columnar manner
        for(int i=0;i<row;i++){
            if(col == queensPlaced[i] || row-i == Math.abs(col-queensPlaced[i])){
                return true;
            }
        }

        return false;
    }

    public List<String> buildOp(int[] queensPlaced, int n){
        List<String> queensMap = new ArrayList<String>();

        for(int i=0;i<n;i++){
            StringBuffer line = new StringBuffer();
            for(int j=0;j<n;j++){
                if(queensPlaced[i] ==j){
                    line.append('Q');
                }else{
                    line.append('.');
                }
            }
            queensMap.add(line.toString());
        }

        return queensMap;
    }

    public static void main(String[] args) {

        NQueens nQueensObj = new NQueens();
        System.out.println(nQueensObj.solveNQueens(4));
        System.out.println(nQueensObj.solveNQueens(5));
    }

}
