package algorithms.m8;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class MaxDiameter {
    
    int maxLen=0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxLen;
    }

    public int traverse(TreeNode root){

        if(null==root){
            return 0;
        }

        int left = 0;
        if(null!=root.left)
            left = 1+traverse(root.left);
        int right = 0;
         if (null!=root.right)
            right = 1+traverse(root.right);
        maxLen = Math.max(maxLen, left+right);
        return Math.max(left,right);
    }
}