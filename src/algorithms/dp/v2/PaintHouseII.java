package algorithms.dp.v2;

public class PaintHouseII {

    public static int minCostII(int[][] costs) {

        int minValue=Integer.MAX_VALUE;
        int index1=-1;
        int minValue2 =Integer.MAX_VALUE;
        int index2=-1;

        for(int i=0;i<costs[0].length;i++){

            if(costs[0][i]<minValue){
                minValue2= minValue;
                index2=index1;
                minValue=costs[0][i];
                index1=i;
            }else if(costs[0][i]<minValue2){
                minValue2=costs[0][i];
                index2=i;
            }
        }

        int tempMinValue=Integer.MAX_VALUE;
        int tempIndex1=-1;
        int tempMinValue2 =Integer.MAX_VALUE;
        int tempIndex2=-1;

        for(int i=1;i<costs.length;i++){
            for(int j=0;j<costs[0].length;j++){
                int currMinValu = (index1!=j) ? minValue :minValue2;

                if(costs[i][j] + currMinValu<tempMinValue){
                    tempMinValue2= tempMinValue;
                    tempIndex2=tempIndex1;
                    tempMinValue=costs[i][j]+currMinValu;
                    tempIndex1=j;
                }else if(costs[i][j] + currMinValu<tempMinValue2){
                    tempMinValue2=costs[i][j]+currMinValu;
                    tempIndex2=j;
                }
            }

            minValue=tempMinValue;
            index1=tempIndex1;
            minValue2 =tempMinValue2;
            index2=tempIndex2;

            tempMinValue=Integer.MAX_VALUE;
            tempIndex1=-1;
            tempMinValue2 =Integer.MAX_VALUE;
            tempIndex2=-1;

        }

        return minValue;
    }

    public static void main(String[] args) {
        System.out.println(minCostII(new int[][]{{1,2,3,4,5,5}}));
        System.out.println(minCostII(new int[][]{{1,2,3},{3,5,2},{3,3,1},{1,2,4}}));
    }
}
