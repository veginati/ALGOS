package algorithms.trees.prep;

import java.util.ArrayList;
import java.util.List;

/**
 * Given unbalanced tree convert to balanced tree
 *
 */
public class BalancedBST {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> values = new ArrayList<>();
        inOrderTraversal(root,values);
        return buildTree(values,0,values.size()-1);
    }

    public void inOrderTraversal(TreeNode root,List<TreeNode> values){
        if(null==root)
            return;
        inOrderTraversal(root.left,values);
        values.add(root);
        inOrderTraversal(root.right,values);
    }

    public TreeNode buildTree(List<TreeNode> values, int start, int end){

        if(start>end)
            return null;

        int mid = start +(end-start)/2;

        TreeNode node = values.get(mid);
        node.left = buildTree(values,start,mid-1);
        node.right = buildTree(values,mid+1,end);
        return node;
    }
}
