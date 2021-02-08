package algorithms.trees;

public class SerDeser {

    int count =0;
    public SerDeser(){
        count=0;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        return sb.toString();
    }

    public void preOrder(TreeNode root, StringBuilder sb){

        if(null == root){
            sb.append("T");
            return;
        }
        sb.append(root.val);
        sb.append("-");
        preOrder(root.left,sb);
        sb.append("-");
        preOrder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes  = data.split("-");
        return buildTree(nodes);
    }

    public TreeNode buildTree(String[] data){

        if(data[count].equals("T")){
            count++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(data[count++]));
        root.left = buildTree(data);
        root.right = buildTree(data);
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(15);
        root.right = new TreeNode(45);

        SerDeser serDeser = new SerDeser();
        String obj = serDeser.serialize(root );
        System.out.println(obj);
        serDeser.deserialize(obj);

    }
}
