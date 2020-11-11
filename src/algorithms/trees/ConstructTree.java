package algorithms.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *  Time Complexity : O(n)
 *  Space Complexity: O(n)
 */
public class ConstructTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0)
            return null;

        int i = 1;
        int j = 0;

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        stack.offerFirst(root);
        visited.add(preorder[0]);
        //left
        int nextElementToAdd = 0;

        do {
            while (j < inorder.length && visited.contains(inorder[j])) {
                if (!stack.isEmpty() && stack.peekFirst().val != inorder[j]) {
                    stack.pollFirst();
                } else {
                    j++;
                    nextElementToAdd = 1;
                }
            }

            if (i < preorder.length) {
                visited.add(preorder[i]);
                TreeNode node = new TreeNode(preorder[i]);
                if (nextElementToAdd == 0) {
                    stack.peekFirst().left = node;
                } else {
                    stack.peekFirst().right = node;
                }
                stack.offerFirst(node);
                nextElementToAdd = 0;
                i++;
            }

        } while (i < preorder.length);

        return root;
    }

    public static void main(String[] args) {

        TreeNode node = buildTree(new int[]{1,8,9,10,11,12,14,15}, new int[]{8,9,10,1,12,11,15,14});

        PostOrderTraversalIterator postOrderTraversalIterator = new PostOrderTraversalIterator(node);

        while (postOrderTraversalIterator.hasNext()) {
            System.out.print(postOrderTraversalIterator.next().val);
            System.out.print(" ");
        }
    }
}