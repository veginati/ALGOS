package algorithms.ds;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BSTTODLL {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list =new ArrayList<>();

        while(null!=head){
            list.add(head.val);
            head = head.next;
        }

        return buildTree(list,0,list.size()-1);
    }

    public TreeNode buildTree(List<Integer> list, int start, int end){

        if(start>end){
            return null;
        }

        int mid = (start+end)/2;

        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list,start,mid-1);
        root.right = buildTree(list,mid+1,end);
        return root;
    }
}
