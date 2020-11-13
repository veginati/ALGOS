package algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeBSTs {

    public static TreeNode mergeTwoBSTs(TreeNode root1, TreeNode root2) {
        // Write your code here.
        if(null == root1)
            return root2;
        if(null == root2)
            return root1;

        LinkedList<Integer> tree1List = new LinkedList<>();
        LinkedList<Integer> tree2List = new LinkedList<>();
        generateInOrder(root1, tree1List);
        generateInOrder(root2, tree2List);

        List<Integer> sortedList = mergeList(tree1List,tree2List);

        return generateTree(sortedList,0,sortedList.size()-1);
    }

    static void generateInOrder(TreeNode node,LinkedList<Integer> list){

        if(null == node)
            return;
        generateInOrder(node.left,list);
        list.add(node.val);
        generateInOrder(node.right,list);
    }

    static List<Integer> mergeList(LinkedList<Integer> l1, LinkedList<Integer> l2){

        List<Integer> sortedList = new ArrayList<>(l1.size()+l2.size());
        while(!l1.isEmpty() && !l2.isEmpty()){

            if(l1.getFirst()<l2.getFirst())
                sortedList.add(l1.removeFirst());
            else
                sortedList.add(l2.removeFirst());
        }

        while(!l1.isEmpty())
            sortedList.add(l1.removeFirst());
        while(!l2.isEmpty())
            sortedList.add(l2.removeFirst());

        return sortedList;
    }

    static TreeNode generateTree(List<Integer> sortedList, int start, int end){

        if(start>end)
            return null;

        int mid = start + (end-start)/2;

        TreeNode TreeNode = new TreeNode(sortedList.get(mid));
        TreeNode.left = generateTree(sortedList,start,mid-1);
        TreeNode.right = generateTree(sortedList,mid+1,end);

        return TreeNode;
    }
}
