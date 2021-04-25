package algorithms.math;

public class RobotRound {

    public static boolean isRobotBounded(String instructions) {

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        char[] ins = instructions.toCharArray();
        int currentDir =0;
        int currentX=0,currentY=0;

        for(int i=0;i<4;i++){

            for(int j=0;j<ins.length;j++){

                char tempIns = ins[j];
                if(tempIns =='L'){
                    --currentDir;
                    currentDir = (currentDir+4)%4;
                }else if(tempIns =='R'){
                    ++currentDir;
                    currentDir = (currentDir+4)%4;
                }else{
                    currentX+=dirs[currentDir][0];
                    currentY+=dirs[currentDir][1];
                }
            }

            if(currentX ==0 && currentY==0){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRobotBounded("GL")==true);
        System.out.println(isRobotBounded("GLRLLGLL")==true);
        System.out.println(isRobotBounded("GGLLGG")==true);
        System.out.println(isRobotBounded("GG")==false);
    }
}
