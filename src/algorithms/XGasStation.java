class XGasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int[] travelCost = new int[gas.length];

        for(int i=0;i<gas.length;i++){
            travelCost[i]=gas[i]-cost[i];
        }
        int startIndex=-1;
        int currentValue=0;

        for(int i=0;i<travelCost.length;i++){
            if(currentValue+travelCost[i]<0){
                startIndex=-1;
                currentValue=0;
            }else{
                if(startIndex==-1){
                    startIndex=i;
                }
                currentValue+=travelCost[i];
            }
        }

        if(startIndex!=-1){
            for(int i=0;i<startIndex;i++){
                if(currentValue+travelCost[i]<0){
                    return -1;
                }else{
                    currentValue+=travelCost[i];
                }
            }

        }

        return startIndex;
    }


}
