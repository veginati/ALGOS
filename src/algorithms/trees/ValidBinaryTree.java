package algorithms.trees;

public class ValidBinaryTree {

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // identifying root is important.
        int[] inward = new int[n];
        for(int i=0;i<n;i++){
            if(leftChild[i]!=-1)
                inward[leftChild[i]]++;
            if(rightChild[i]!=-1)
                inward[rightChild[i]]++;
        }
        int root=0;
        for(int i=0;i<n;i++)
            if(inward[i]==0)
                root =i;

        boolean[] visited = new boolean[n];
        if(!isValid(visited,root,leftChild,rightChild)) {
            return false;
        }

        boolean output =true;
        for(boolean i:visited){
            output = output && i;
        }

        return output;
    }

    public static boolean isValid( boolean[] visited,int n, int[] lc,int[] rc){

        visited[n]=true;
        if(lc[n]==-1 && rc[n]==-1){
            return true;
        }

        int left = lc[n];
        if(left!=-1){
            if(visited[left]){
                return false;
            }else{
                boolean leftValid = isValid(visited,left,lc,rc);
                if(!leftValid){
                    return false;
                }
            }
        }

        int right = rc[n];
        if(right!=-1){
            if(visited[right]){
                return false;
            }else{
                boolean rightValid = isValid(visited,right,lc,rc);
                if(!rightValid){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validateBinaryTreeNodes(4,new int[]{3,-1,1,-1},new int[]{-1,-1,0,-1}));
    }
}
