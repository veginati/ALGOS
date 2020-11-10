package algorithms.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/solution/
 * Time complexity : O(n), Iterating through all nodes at once.
 * Space Complexity : Max number of nodes in any level, in a complete tree max nodes are leaf nodes O(n/2)
 * Explicit time complexity for output is O(n)

 */
public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> coll = new LinkedList<>();

        // add based on the depth;
        if(null != root)
            generateLevels(root,coll);
        return coll;
    }

    public static void generateLevels(TreeNode node, List<List<Integer>> coll){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while(queue.size()>0){

            int size = queue.size();
            List<Integer> levelOrder = new LinkedList<>();

            while(size>0){
                TreeNode deletedNode = queue.poll();
                levelOrder.add(deletedNode.val);

                if(null!=deletedNode.left)
                    queue.offer(deletedNode.left);

                if(null!=deletedNode.right)
                    queue.offer(deletedNode.right);

                --size;
            }
            coll.add(levelOrder);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootL = new TreeNode(2);
        TreeNode rootR = new TreeNode(3);
        TreeNode rootLL = new TreeNode(4);
        TreeNode rootLR = new TreeNode(4);
        root.left =rootL;
        root.right=rootR;
        rootL.left =rootLL;
        rootL.right=rootLR;

        System.out.println(levelOrder(root));
    }
}
