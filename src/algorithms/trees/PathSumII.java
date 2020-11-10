package algorithms.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 * In a complete tree, there will be at most logn nodes in a path,
 * and in worst case every leaf node would lead to target sum,
 * Therefore to copy logn nodes for n/2 leaf would be (n logn)
 *
 * Time complexity : O(nlogn)
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> coll = new LinkedList<>();
        LinkedList<Integer> currList = new LinkedList<>();

        generatePaths(sum,root, coll,currList,0);
        return coll;
    }

    public void generatePaths(int target, TreeNode root, List<List<Integer>> coll, LinkedList<Integer> currList, int currSum)     {
        if(null == root)
            return;

        currSum+=root.val;
        currList.add(root.val);
        if(currSum==target && root.left ==null && root.right == null){
            coll.add(new LinkedList<>(currList));
        }

        if(null!=root.left)
            generatePaths(target, root.left,coll,currList,currSum);

        if(null!=root.right)
            generatePaths(target, root.right,coll,currList,currSum);

        currSum-=root.val;
        currList.removeLast();
    }
}
