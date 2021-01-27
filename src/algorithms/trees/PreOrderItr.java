package algorithms.trees;

import java.util.Iterator;
import java.util.Stack;

public class PreOrderItr implements Iterator<TreeNode> {
    private Stack<TreeNode> stack=  null;

    public PreOrderItr(TreeNode root){
        stack = new Stack<>();
        stack.push(root);
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public TreeNode next(){

        while(hasNext()){
            TreeNode node = stack.pop();
            if(null ==node.left && null == node.right)
                return node;
            if(null!=node.right)
                stack.push(node.right);
            if(null!=node.left)
                stack.push(node.left);
        }
        throw new IllegalStateException("No More Leaf Nodes");
    }
}
