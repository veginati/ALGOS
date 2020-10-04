package algorithms.array;

/**
 *  Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 */
public class Search2D {

    public static boolean searchMatrix(int[][] matrix, int target) {

        if(null == matrix || matrix.length ==0){
            return false;
        }

        int start=0;
        int end = matrix.length * matrix[0].length-1;
        while(start<=end){

            int mid = start + (end-start)/2;

            int r = mid/matrix[0].length;
            int c = mid%matrix[0].length;

            if(matrix[r][c]== target){
                return true;
            }else if(matrix[r][c]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }

        }


        return false;
    }

    public static void main(String[] args) {

        int[][] input = {{1,2,3,4,5,5,5,6,7,7,8,9}};

        System.out.println(searchMatrix(input,4));
        System.out.println(searchMatrix(input,9));
        System.out.println(searchMatrix(input,11));

        input = new int[][]{{1,2,3,4},{5,5,5,6},{7,7,8,9}};

        System.out.println(searchMatrix(input,4));
        System.out.println(searchMatrix(input,9));
        System.out.println(searchMatrix(input,11));
    }

}