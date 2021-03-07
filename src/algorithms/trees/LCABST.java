package algorithms.trees;

public class LCABST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val<=q.val){
            return findAncestor(root,p,q);
        }
        return findAncestor(root,q,p);
    }

    public TreeNode findAncestor(TreeNode r, TreeNode p, TreeNode q){

        if(null == r){
            return null;
        }

        if(r.val>p.val && r.val<q.val){
            return r;
        }else if(r.val==p.val && r.val<q.val){
            return r;
        }else if(r.val == q.val && r.val>p.val){
            return r;
        }

        if(p.val<=r.val &&q.val<=r.val){
            return findAncestor(r.left,p,q);
        }
        return findAncestor(r.right,p,q);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        LCABST lcabstObj = new LCABST();

        TreeNode node = lcabstObj.lowestCommonAncestor(root, root.left,root.right);
        System.out.println(node.val);
    }
}
