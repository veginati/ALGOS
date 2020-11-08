package algorithms.trees;

import java.util.ArrayList;
import java.util.List;

public class LeftMostNode {

    public static List<Integer> getLeftMostNodeValues(TreeNode node){

        List<Integer> coll = new ArrayList<>();
        preOrderTree(node,coll,0);

        return coll;
    }

    public static void preOrderTree(TreeNode node, List<Integer> coll, int depth){

        if(null == node)
            return;
        // In order to print a value, we can keep track of max level so far whether
        // to print or not, this is so simple instead of using set.
        if(coll.size()<(1+depth))
            coll.add(node.val);
        preOrderTree(node.left,coll,depth+1);
        preOrderTree(node.right,coll,depth+1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode rl = new TreeNode(3);
        TreeNode rr = new TreeNode(7);
        TreeNode rlr = new TreeNode(4);
        TreeNode rrl = new TreeNode(6);
        TreeNode rrr = new TreeNode(8);
        TreeNode rrrl = new TreeNode(9);

        root.left=rl;
        root.right=rr;
        rl.right=rlr;
        rr.left =rrl;
        rr.right=rrr;
        rrr.left=rrrl;

        System.out.println(getLeftMostNodeValues(root));
    }
}
