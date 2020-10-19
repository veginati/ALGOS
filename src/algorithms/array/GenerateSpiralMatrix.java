package algorithms.array;

import java.util.Arrays;

/**
 *  Generate Spiral Matrix  Time and SPace complexity is O(n^2)
 *  Read in spiral order 1D array Time and SPace complexity is O(n^2)
 */
public class GenerateSpiralMatrix {

    public static int[][] generateSpiralMatrix(int n){

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][] output = new int[n][n];
        int val=0;
        int row=0;
        int col=0;
        int currentDirection=0;
        int total= n*n;

        while(val<total){
            output[row][col] =++val;
            row+=dirs[currentDirection][0];
            col+=dirs[currentDirection][1];

            if(isInValid(output,row,col)){
                row-=dirs[currentDirection][0];
                col-=dirs[currentDirection][1];
                currentDirection=(currentDirection+1)%4;
                row+=dirs[currentDirection][0];
                col+=dirs[currentDirection][1];
            }
        }
        return output;
    }

    public static int[] generate1DArray(int[][] input){

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int val=0;
        int row=0;
        int col=0;
        int currentDirection=0;

        int rowStart=0;
        int rowEnd=input.length;
        int colStart =0;
        int colEnd= input[0].length;

        int[] output = new int[input.length * input[0].length];
        while(val<output.length){
            output[val++] = input[row][col];
            row+=dirs[currentDirection][0];
            col+=dirs[currentDirection][1];
            if(isInValid(row,col,rowStart,rowEnd,colStart,colEnd)){
                switch (currentDirection){
                    case 0:
                        rowStart++;
                        break;
                    case 1:
                        colEnd--;
                        break;
                    case 2:rowEnd--;
                        break;
                    case 3: colStart++;
                        break;
                    default:
                }
                row-=dirs[currentDirection][0];
                col-=dirs[currentDirection][1];
                currentDirection=(currentDirection+1)%4;
                row+=dirs[currentDirection][0];
                col+=dirs[currentDirection][1];
            }
        }
        return output;
    }
    public static boolean isInValid(int row, int col, int rowStart, int rowEnd, int colStart, int colEnd){
        return row<rowStart || col <colStart || row>=rowEnd || col>=colEnd;
    }
    public static boolean isInValid(int[][] matrix, int row, int col){
        return row<0 || col <0 || row>=matrix.length || col>=matrix[0].length || matrix[row][col]!=0;
    }

    public static void main(String[] args) {

        int n=1;
        int[][] output = generateSpiralMatrix(n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(Arrays.toString(generate1DArray(output)));
    }


}
