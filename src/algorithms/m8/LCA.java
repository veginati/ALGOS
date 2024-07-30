package algorithms.m8;

import java.util.ArrayDeque;
import java.util.Deque;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
public class LCA {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node tempP = p;
        Node tempQ = q;
        Deque<Node> parentP = new ArrayDeque<>();
        Deque<Node> parentQ = new ArrayDeque<>();

        while(tempP!=null){
            parentP.offerFirst(tempP);
            tempP=tempP.parent;
        }

        while(tempQ!=null){
            parentQ.offerFirst(tempQ);
            tempQ=tempQ.parent;
        }
        Node parent = null;
        while(parentP.size()>0 && parentQ.size()>0){
            Node tempParentP = parentP.pollFirst();
            Node tempParentQ = parentQ.pollFirst();
            if(tempParentP == tempParentQ){
                parent = tempParentQ;
            }else{
                break;
            }
        }
        return parent;
    }
}
