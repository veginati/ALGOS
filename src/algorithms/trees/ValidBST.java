package algorithms.trees;


public class ValidBST {

    public static boolean isValidBST(TreeNode root) {
        return validTree(root, null,null);
    }

    public static boolean validTree(TreeNode node, Integer lowerBound, Integer upperBound){

        if(null == node){
            return true;
        }

        if(null!=lowerBound && null!=upperBound && !(node.val>lowerBound && node.val<upperBound)){
            return false;
        }else if(null!=lowerBound && !(node.val>lowerBound)){
            return false;
        }else if(null!=upperBound && !(node.val<upperBound)){
            return false;
        }

        return validTree(node.left, lowerBound,node.val) && validTree(node.right,node.val,upperBound);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(-2147483648);
        TreeNode right = new TreeNode(2147483647);
        root.left =left;
        root.right=right;

        System.out.println(isValidBST(root));
        System.out.println(isValidBST(left));
        System.out.println(isValidBST(right));
    }
}
