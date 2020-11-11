package algorithms.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class PostOrderTraversalIterator implements Iterator<TreeNode> {

    Deque<TreeNode> stack;
    TreeNode previousNode = null;

    public PostOrderTraversalIterator(TreeNode node) {
        stack = new ArrayDeque<>();
        stack.offerFirst(node);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public TreeNode next() {

        if (stack.isEmpty()) {
            throw new IllegalStateException("No more elements found");
        }

        TreeNode node = stack.peekFirst();
        if(null == node.right || node.right != previousNode)
        while ((null!=node.left && node.left != previousNode) || (null!=node.right && node.right != previousNode)) {

            if (null != node.left && node.left != previousNode) {
                node = node.left;
            } else{
                node = node.right;
            }
            stack.offerFirst(node);
        }
        previousNode = stack.pollFirst();
        return previousNode;
    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(10);
        TreeNode rl = new TreeNode(20);
        TreeNode rr = new TreeNode(30);
        TreeNode rll = new TreeNode(40);
        TreeNode rrr = new TreeNode(50);
        TreeNode rrrl = new TreeNode(122);

        TreeNode rrl = new TreeNode(60);

        root.left = rl;
        root.right = rr;
        rl.left = rll;

        rr.left = rrl;
        rr.right = rrr;

        rrr.left =rrrl;

        /**
         *
         *               10
         *           20      30
         *        40        60  50
         *                     122
         *        40 20 60 122 50 30 10
         */

        PostOrderTraversalIterator postOrderItr = new PostOrderTraversalIterator(root);

        while (postOrderItr.hasNext()) {
            System.out.println(postOrderItr.next().val);
        }

    }
}
