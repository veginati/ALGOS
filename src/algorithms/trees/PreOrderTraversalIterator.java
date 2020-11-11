package algorithms.trees;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class PreOrderTraversalIterator implements Iterator<TreeNode> {

    private Deque<TreeNode> stack = null;

    public PreOrderTraversalIterator(TreeNode root){
        stack = new ArrayDeque<>();
        stack.offerFirst(root);
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public TreeNode next(){

        if(stack.isEmpty()){
           throw new IllegalStateException("No more elements found");
        }

        TreeNode node = stack.pollFirst();

        if(null!=node.right)
            stack.offerFirst(node.right);

        if(null!=node.left)
            stack.offerFirst(node.left);

        return node;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        TreeNode rl = new TreeNode(20);
        TreeNode rr = new TreeNode(30);
        TreeNode rll = new TreeNode(40);
        TreeNode rrr = new TreeNode(50);

        TreeNode rrl = new TreeNode(60);

        root.left=rl;
        root.right=rr;
        rl.left=rll;

        rr.left = rrl;
        rr.right = rrr;

        /**
         *
         *               10
         *           20      30
         *        40        60  50
         *
         *        10 20 40 30 60 50
         */

        PreOrderTraversalIterator preOrderItr = new PreOrderTraversalIterator(root);
        while(preOrderItr.hasNext()){
            System.out.println(preOrderItr.next().val);
        }
    }
}
