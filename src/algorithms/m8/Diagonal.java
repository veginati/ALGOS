package algorithms.m8;

public class Diagonal {

    public int[] findDiagonalOrder(int[][] mat) {
        int[] output = new int[mat.length*mat[0].length];
        int index=0;
        int row=0;
        int col=0;
        boolean evenFlag=true;

        while(index<output.length){
            //System.out.println(row+" "+col);
            output[index++]=mat[row][col];
            int tempRow = row;
            int tempCol = col;

            if(evenFlag){
                tempRow-=1;
                tempCol+=1;
            }else{
                tempRow+=1;
                tempCol-=1;
            }

            if( tempRow<0 || tempCol<0 || tempRow>=mat.length || tempCol>=mat[0].length){
                if(evenFlag){
                    if(col<mat[0].length-1){
                        col+=1;
                    }else{
                        row+=1;
                    }
                    
                }else{
                    if(row<mat.length-1){
                        row+=1;
                    }else{
                        col+=1;
                    }
                }
                evenFlag=!evenFlag;
            }else{
                row=tempRow;
                col=tempCol;
            }
        }
        return output;

    }
    
}
