package algorithms.math.prep;

/**
 * Time complexity O(k), k is the number of valid permutations.
 * Space is O(n) recursion stack
 * Leetcode 526
 */
public class BeautifulArrangement {

    public static int countArrangement(int n) {

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }

        return perm(0,arr);
    }

    public static int perm(int index, int[] arr){

        if(index == arr.length)
            return 1;

        int counter=0;

        for(int i=index;i<arr.length;i++){
            swap(arr,index,i);
            if(arr[index]%(index+1) ==0 || (index+1)%arr[index] ==0){
                counter+=perm(index+1,arr);
            }
            swap(arr,index,i);
        }
        return counter;
    }

    public static void swap(int[] arr, int x, int y){
        int temp =arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }

    public static void main(String[] args) {
        System.out.println(countArrangement(10)==700);
    }
}
