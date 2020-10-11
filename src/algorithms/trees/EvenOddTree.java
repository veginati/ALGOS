package algorithms.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvenOddTree {

    /**
     * https://leetcode.com/problems/even-odd-tree/
     * Time complexity : O(no. of nodes) visiting all nodes once
     * Space Complexity: O( max no of nodes in any level, leaf nodes would be n/2) -- O(n)
     * @param root1
     * @return
     */
    public static boolean isEvenOddTree(TreeNode root1) {

        Deque<TreeNode> treeElements = new ArrayDeque<>();
        if(null!=root1)
            treeElements.offerLast(root1);

        //keep track of levels
        int count =0;
        while(!treeElements.isEmpty()){

            int size = treeElements.size();
            Integer prevElement = null;
            for(int i=0;i<size;i++){

                TreeNode tree = treeElements.pollFirst();

                if(count%2 ==0){
                    if(tree.val%2 ==0 || (null!=prevElement &&  tree.val<=prevElement)){
                        return false;
                    }

                }else{
                    if(tree.val%2 ==1  || (null!=prevElement &&  tree.val>=prevElement)){
                        return false;
                    }
                }
                prevElement= tree.val;

                if(null!=tree.left){
                    treeElements.offerLast(tree.left);
                }

                if(null!=tree.right){
                    treeElements.offerLast(tree.right);
                }
            }
            ++count;
        }

        return true;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode rootL = new TreeNode(10);
        TreeNode rootR = new TreeNode(4);

        root.left = rootL;
        root.right = rootR;
        System.out.println(isEvenOddTree(root));

    }
}
