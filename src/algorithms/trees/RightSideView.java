package algorithms.trees;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightViewList = new ArrayList<>();
        inOrderTraversal(0,root,rightViewList);
        return rightViewList;
    }

    public static void inOrderTraversal(int depth, TreeNode root,List<Integer> rightViewList){

        if(null == root)
            return;

        if((1+depth)>rightViewList.size())
            rightViewList.add(root.val);

        inOrderTraversal(depth+1,root.right,rightViewList);
        inOrderTraversal(depth+1,root.left,rightViewList);

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
        rlr.left=rrr;
        rrr.right=rrrl;

        /**
         *
         *                               5
         *                             /  \
         *                           3     7
         *                          / \
         *                         4   6
         *                       /
         *                      8
         *                     /
         *                    9
         *
         *                    right side view should be [5,7,6,8,9]
         */
        System.out.println(rightSideView(root));
    }

}
