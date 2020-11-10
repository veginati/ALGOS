package algorithms.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();

        if(null!=root)
            stack1.offerFirst(root);

        List<List<Integer>> coll = new LinkedList<>();

        while(null!=root && (!stack1.isEmpty() || !stack2.isEmpty())){
            List<Integer> levelValues = new LinkedList<>();

            if(!stack1.isEmpty()){
                while(!stack1.isEmpty()){
                    TreeNode node = stack1.pollFirst();
                    levelValues.add(node.val);
                    if(null!=node.left)
                        stack2.offerFirst(node.left);
                    if(null!=node.right)
                        stack2.offerFirst(node.right);
                }
            }else{
                while(!stack2.isEmpty()){
                    TreeNode node = stack2.pollFirst();
                    levelValues.add(node.val);
                    if(null!=node.right)
                        stack1.offerFirst(node.right);
                    if(null!=node.left)
                        stack1.offerFirst(node.left);
                }
            }
            coll.add(levelValues);
        }

        return coll;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode rl = new TreeNode(3);
        TreeNode rr = new TreeNode(7);
        TreeNode rlr = new TreeNode(4);
        TreeNode rrl = new TreeNode(6);
        TreeNode rrr = new TreeNode(8);
        TreeNode rrrl = new TreeNode(9);
        root.left =rl;
        root.right=rr;
        rl.left =rlr;
        rl.right=rrl;
        rr.left=rrr;
        rr.right=rrrl;

        System.out.println(zigzagLevelOrder(root));
    }
}
