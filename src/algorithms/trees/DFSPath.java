 /*
    For your reference:
    class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    */
    static ArrayList<ArrayList<Integer>> all_paths_of_a_binary_tree(BinaryTreeNode root) {
        
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        path_traversal(root, new ArrayList<Integer>(), output);
        
        // Write your code here.
        return output;
    }
    
    static void path_traversal(BinaryTreeNode root, ArrayList<Integer> currentList, ArrayList<ArrayList<Integer>> output){
        if(null == root){
            return;
        }
        
        //add a leaf node
         if(null == root.left && null== root.right){
            currentList.add(root.value);
            output.add(new ArrayList<Integer>(currentList));    
            currentList.remove(currentList.size()-1);
            return;
        }
        
        currentList.add(root.value);
        path_traversal(root.left, currentList, output);
        path_traversal(root.right, currentList, output);
        currentList.remove(currentList.size()-1);
    }
