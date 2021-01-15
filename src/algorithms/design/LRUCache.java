package algorithms.design;
import java.util.*;
class LRUCache {
    class Node{
        Node left;
        int key;
        int value;
        Node right;

        public Node(int key,int value){
            this.key =key;
            this.value =value;
        }
    }
    private int capacity =0;
    private  Map<Integer,Node> mapObj = null;
    private  Node firstNode = null;
    private  Node lastNode = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mapObj = new HashMap<>(capacity);
        this.firstNode = null;
        this.lastNode = null;

    }

    public int get(int key) {
        Node node = mapObj.get(key);
        if(null == node)
            return -1;
        Node deleteNode = deleteNode(node);
        if(null!=deleteNode){
            put(deleteNode.key,deleteNode.value);
        }

        return mapObj.get(key).value;
    }

    public Node deleteNode(Node node){

        if(node == firstNode){
            firstNode =firstNode.right;
            if(null!=firstNode)
                firstNode.left = null;
            mapObj.remove(node.key);
            return node;
        }else if(node !=lastNode){
            Node left = node.left;
            Node right = node.right;
            left.right =right;
            right.left =left;
            mapObj.remove(node.key);
            return node;
        }
        return null;
    }

    public void put(int key, int value) {

        if(mapObj.containsKey(key)){
            Node node = deleteNode(mapObj.get(key));
            if(null == node){
                mapObj.get(key).value=value;
                return;
            }
        }

        if(mapObj.size()<capacity){
            Node data = new Node(key,value);
            if(null == firstNode){
                firstNode =data;
                lastNode = data;
            }else{
                lastNode.right =data;
                data.left =lastNode;
                lastNode = lastNode.right;
            }
            mapObj.put(key,data);
        }else{
            //least recently used
            Node temp = firstNode;
            firstNode =firstNode.right;
            if(null!=firstNode)
                firstNode.left = null;
            mapObj.remove(temp.key);
            put(key,value);
        }

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1,11);
        lruCache.put(2,22);
        lruCache.put(3,33);
        lruCache.put(4,43);
        lruCache.put(5,53);

        lruCache.get(3);
        lruCache.get(1);
        lruCache.get(2);
        lruCache.put(6,63);
        Node temp = lruCache.firstNode;

        while(null!=temp){
            System.out.println(temp.value);
            temp=temp.right;
        }

    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */