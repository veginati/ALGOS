    /*
    For your reference:
    class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    */
class ValidateBST{
  
    static Boolean is_bst(BinaryTreeNode root) {
        // Write your code here.
        
        return is_bst(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    static Boolean is_bst(BinaryTreeNode root, int left, int right){
        
        if(null == root){
            return true;
        }
        
        boolean current_node_validate = root.value>=left && root.value<=right;
        
        return current_node_validate && is_bst(root.left, left, root.value) && is_bst(root.right,root.value, right);
        
    }
}
