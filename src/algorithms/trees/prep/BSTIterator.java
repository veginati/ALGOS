package algorithms.trees.prep;

import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
    int val;
    TreeNode left;
   TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val,TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * leetcode 1586
 */
public class BSTIterator {

    TreeNode prevNode = null;
    int previousCount=0;
    TreeNode nextNode = null;

    Deque<TreeNode> stack = new ArrayDeque<>();
    public BSTIterator(TreeNode root) {
        nextNode =root;
        previousCount=0;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || previousCount>0 || null!=nextNode;
    }

    public int next() {
        if(previousCount>0){
            previousCount--;
            prevNode = prevNode.right;
            return prevNode.val;
        }
        TreeNode node = inOrderTraversal(nextNode,stack);
        nextNode = (null!=node) ?node.right:node;
        if(null!=prevNode)
            prevNode.right = node;
        if(null!=node)
            node.left =prevNode;
        prevNode = node;
        return node.val;
    }

    public boolean hasPrev() {
        return null!=prevNode && null!=prevNode.left;
    }

    public int prev() {
        prevNode = prevNode.left;
        previousCount++;

        return prevNode.val;
    }

    public TreeNode inOrderTraversal(TreeNode node, Deque<TreeNode> stack){

        while(null!=node){
            stack.offerFirst(node);
            node = node.left;
        }
        return stack.pollFirst();
    }
}
