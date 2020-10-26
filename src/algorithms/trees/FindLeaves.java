package algorithms.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 *  time complexity is visiting all nodes
 *  space compelxity is max depth of the tree.
 */
public class FindLeaves {

    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> output =new ArrayList<>();

        findLeaves(root, output);
        return output;
    }

    public static int findLeaves(TreeNode root, List<List<Integer>> output){

        if(null == root){
            return 0;
        }

        int left = findLeaves(root.left, output);
        int right = findLeaves(root.right, output);

        int values = 1+Math.max(left,right);

        if(output.size()<values){
            output.add(new ArrayList<Integer>(){{add(root.val);}});
        }else{
            output.get(values-1).add(root.val);
        }

        return values;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode ll = new TreeNode(4);
        TreeNode rl = new TreeNode(5);

        root.left=l;
        root.right=r;
        l.left=ll;
        r.left=rl;

        System.out.print(findLeaves(root));
    }
}
