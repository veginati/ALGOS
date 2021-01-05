package algorithms.array;

/**
 * Time complexity is O(n)
 * Space Complexity is O(1)
 *  Leetcode 769
 */
public class MaxChunks {

    public static int maxChunksToSorted(int[] arr) {

        int counter=0;
        int endIndex=-1;

        for(int i=0;i<arr.length;i++){

            if(i!=arr[i]){

                if(endIndex ==-1){
                    endIndex =arr[i];
                }else{
                    endIndex = Math.max(endIndex,arr[i]);
                }

            }

            if(endIndex == -1 && i==arr[i]){
                ++counter;
            }else if(endIndex>0 && i == endIndex){
                endIndex=-1;
                ++counter;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{1,0,2,3,4}));
        System.out.println(maxChunksToSorted(new int[]{4,0,2,3,1}));
    }
}
