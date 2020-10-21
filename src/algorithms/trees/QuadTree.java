package algorithms.trees;


class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

/**
 *  https://leetcode.com/problems/construct-quad-tree/
 *  constraints
 *  n == grid.length == grid[i].length
 * n == 2^x where 0 <= x <= 6
 *  Time complexity is O( n*n)
 *  Space complexity is Stack O(log n)
 */
public class QuadTree {

    public Node construct(int[][] grid) {
        return generateNode(0,grid.length,0,grid[0].length,grid);
    }

    public Node generateNode(int rS, int rE, int cS, int cE, int[][] grid){

        if(rE-rS ==1 ){
            return new Node(grid[rS][cS]==1,true);
        }

        int mid = rS + (rE-rS)/2;
        int colMid = cS+ (cE-cS)/2;

        Node topLeft = generateNode(rS,mid,cS,colMid,grid);
        Node topRight = generateNode(rS,mid,colMid,cE,grid);
        Node bottomLeft = generateNode(mid,rE,cS,colMid,grid);
        Node bottomRight = generateNode(mid,rE,colMid,cE,grid);

        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val){
            return new Node(topLeft.val,true);
        }
        return new Node(true,false,topLeft,topRight,bottomLeft,bottomRight);
    }


    public static void main(String[] args) {

        QuadTree quadTree = new QuadTree();
        Node node = quadTree.construct(new int[][]{{0,1},{1,0}});
        Node node1 = quadTree.construct(new int[][]{{1,1},{1,1}});
        Node node2 = quadTree.construct(new int[][]{{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}});
        System.out.print(node);
        System.out.print(node1);
        System.out.println(node2);
    }
}