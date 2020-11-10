package algorithms.trees;
/***
 *  https://leetcode.com/problems/count-univalue-subtrees/submissions/
 *
 */

public class UniValueTree {

   static class UniValue{
        boolean isUniValue;
        int count;
        public UniValue(boolean isUniValue, int count ){
            this.isUniValue=isUniValue;
            this.count=count;
        }
    }

    public static int countUnivalSubtrees(TreeNode root) {
        UniValue uniValue = countUniValueTree(root);

        return uniValue.count;
    }

    public static UniValue countUniValueTree(TreeNode node){
        // edge case for root node to be null
        if(null == node)
            return new UniValue(true,0);

        //leaf node
        if(null == node.left && null ==  node.right){
            return new UniValue(true,1);
        }

        UniValue left = countUniValueTree(node.left);
        UniValue right = countUniValueTree(node.right);

        if((null!=node.left && node.val!=node.left.val) || !left.isUniValue)
            return new UniValue(false,left.count+right.count);

        if((null!=node.right && node.val!=node.right.val) || !right.isUniValue)
            return new UniValue(false,left.count+right.count);

        left.count+=right.count;
        left.count+=1;

        return left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode rl = new TreeNode(5);
        TreeNode rr = new TreeNode(5);
        TreeNode rlr = new TreeNode(5);
        TreeNode rrl = new TreeNode(5);
        TreeNode rrr = new TreeNode(5);
        TreeNode rrrl = new TreeNode(5);
        root.left =rl;
        root.right=rr;
        rl.left =rlr;
        rl.right=rrl;
        rlr.left=rrr;
        rrr.right=rrrl;

        /**
         *
         *                               5
         *                             /  \
         *                           5     5
         *                          / \
         *                         5   5
         *                       /
         *                      5
         *                     /
         *                    5
         *
         *                    total subtree of univalue =7
         */

        System.out.println(countUnivalSubtrees(root) ==7);
    }
}
