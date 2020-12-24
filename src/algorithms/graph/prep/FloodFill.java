package algorithms.graph.prep;

public class FloodFill {
    int[][] dirs ={{0,1},{1,0},{0,-1},{-1,0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if(null!=image && image.length>0 && image[sr][sc]!=newColor){
            dfs(image[sr][sc],newColor,image,sr,sc);
        }
        return image;
    }

    public void dfs(int color, int newColor, int[][] image, int row, int col){
        if(row<0 || col<0 || row>=image.length || col>=image[0].length || image[row][col]!=color)
            return;
        image[row][col] =newColor;
        for(int i=0;i<dirs.length;i++)
            dfs(color,newColor,image,row+dirs[i][0],col+dirs[i][1]);
    }
}
