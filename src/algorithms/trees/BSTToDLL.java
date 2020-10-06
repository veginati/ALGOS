package algorithms.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTToDLL {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static Node treeToDoublyList(Node root) {

        Deque<Node> stack = new ArrayDeque<>();
        Node first = null;
        Node last = null;
        Node temp =root;
        while(!stack.isEmpty() || null!=temp)  {

            Node element = buildTree(temp,stack);
            temp = null;

            if(null!=element){
                temp= element.right;
                element.left = null;
                element.right = null;
            }

            if(null == first && null!=element){
                first = element;
                last =element;
            }else  if(null!=element){
                last.right =element;
                element.left =last;
                last =last.right;
            }

        }

        first.left =last;
        last.right =first;

        return first;
    }

    public static Node buildTree(Node root, Deque<Node> stack){

        while(null!= root){
            stack.offerFirst(root);
            root = root.left;
        }

        return !stack.isEmpty()?stack.pollFirst():null;
    }


    public static void main(String[] args) {

        Node n = new Node(4);
        Node nl = new Node(2);
        Node nr = new Node(5);
        Node nll = new Node(1);
        Node nlr = new Node(3);

        n.left =nl;
        n.right=nr;
        nl.left=nll;
        nl.right=nlr;

        treeToDoublyList(n);

    }


}