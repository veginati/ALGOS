package algorithms.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Time complexity is O(n)
 * Space complexity is O(n)
 */
public class CustomTreePostOrderInOrder {
    private int index=0;
    private Map<Integer,Integer> mapIndex= null;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1;
        mapIndex = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            mapIndex.put(inorder[i],i);

        return generateTree(postorder,null,null);
    }

    public TreeNode generateTree(int[] postorder, Integer min, Integer max){

        if(index<0)
            return null;

        if(null!=min && mapIndex.get(postorder[index])<min)
            return null;

        if(null!=max && mapIndex.get(postorder[index])>max)
            return null;

        int value = postorder[index--];
        int tempIndex = mapIndex.get(value);
        TreeNode node = new TreeNode(value);

        if(index>=0 && mapIndex.get(postorder[index])<tempIndex){
            node.left = generateTree( postorder,min, tempIndex);
        }else if(index>=0 && mapIndex.get(postorder[index])>tempIndex){
            node.right = generateTree( postorder, tempIndex,max);
        }

        if(null==node.left && index>=0 && mapIndex.get(postorder[index])<tempIndex){
            node.left = generateTree( postorder,min, tempIndex);
        }else if(null==node.right && index>=0 && mapIndex.get(postorder[index])>tempIndex){
            node.right = generateTree( postorder, tempIndex,max);
        }

        return node;
    }

    /***
     *https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34782/My-recursive-Java-code-with-O(n)-time-and-O(n)-space
     *
     * better version from leetcode
     *
     * int pInorder;   // index of inorder array
     * int pPostorder; // index of postorder array
     *
     * private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
     * 	if (pPostorder < 0) {
     * 		return null;
     *        }
     *
     * 	// create root node
     * 	TreeNode n = new TreeNode(postorder[pPostorder--]);
     *
     * 	// if right node exist, create right subtree
     * 	if (inorder[pInorder] != n.val) {
     * 		n.right = buildTree(inorder, postorder, n);
     *    }
     *
     * 	pInorder--;
     *
     * 	// if left node exist, create left subtree
     * 	if ((end == null) || (inorder[pInorder] != end.val)) {
     * 		n.left = buildTree(inorder, postorder, end);
     *    }
     *
     * 	return n;
     * }
     *
     * public TreeNode buildTree(int[] inorder, int[] postorder) {
     * 	pInorder = inorder.length - 1;
     * 	pPostorder = postorder.length - 1;
     *
     * 	return buildTree(inorder, postorder, null);
     * }
     */
}
