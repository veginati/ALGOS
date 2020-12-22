package algorithms.ds;
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};

/**
 * Time complexity is O(n), n is the number of nodes.
 * Space Complexity is O(1), two pointers used.
 */
public class CircularLinkedList {
    public Node insert(Node head, int val) {

        Node newNode = new Node(val);

        if(null == head){
            newNode.next = newNode;
            return newNode;
        }

        Node prev = null;
        Node curr = head;
        boolean found =false;
        do{

            if(val == curr.val){
                attach(curr,curr.next,newNode);
                found =true;
            }else if(null!=prev && val>prev.val && val< curr.val){
                attach(prev, curr,newNode);
                found =true;
            }else if(null!=prev && prev.val>curr.val && val> prev.val){
                attach(prev,curr,newNode);
                found =true;
            }else if(null!=prev && prev.val>curr.val && val<curr.val){
                attach(prev,curr,newNode);
                found =true;
            }

            prev =curr;
            curr = curr.next;

        } while(curr!=head && !found);

        if(!found){
            attach(prev,curr,newNode);
        }

        return head;
    }

    public void attach(Node curr, Node next, Node i){
        curr.next =i;
        i.next = next;
    }

    public static void main(String[] args) {

        Node l = new Node(8);
        Node f = new Node(5);
        Node n = new Node(6);

        f.next =n;
        n.next=l;
        l.next=f;

        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(f,2);
        cll.insert(f,100);
        cll.insert(f,12);

        Node temp =f;

        do{
            System.out.print(temp.val+" ");
            temp =temp.next;
        }while(f!=temp);
    }
}
