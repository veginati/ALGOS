package algorithms.trees;

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 *
 * Time complexity O(n)
 * Space complexity is O(n) in case of skewwed binary search tree
 */
public class ConstructTreePreOrder {
    private static int index =0;
    public static TreeNode bstFromPreorder(int[] preorder) {
        index=0;
        return generateBST(preorder,null,null);
    }

    public static TreeNode generateBST(int[] preorder, Integer min, Integer max){

        if(index>=preorder.length)
            return null;

        if(null!=min && preorder[index]<min)
            return null;

        if(null!=max && preorder[index]>max)
            return null;

        int value = preorder[index++];
        TreeNode node = new TreeNode(value);
        node.left = generateBST(preorder,min,value);
        node.right = generateBST(preorder,value,max);

        return node;
    }

    public  static void main(String[] args) {

        TreeNode node = bstFromPreorder(new int[]{8,5,1,7,10,12});

        PostOrderTraversalIterator preOrderTraversalIterator = new PostOrderTraversalIterator(node);

        while (preOrderTraversalIterator.hasNext())
            System.out.println(preOrderTraversalIterator.next().val);

    }
}
