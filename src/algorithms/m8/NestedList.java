package algorithms.m8;

import java.util.List;

/**
 *  NestedInteger
 */
 interface  NestedInteger {

    public boolean isInteger();

    public int getInteger();

    public List<NestedInteger> getList();
    
}

public class NestedList {

     public int depthSum(List<NestedInteger> nestedList) {
        return totalSum(nestedList, 1);
    }

    public int totalSum(List<NestedInteger> nestedList, int depth){

        int total=0;

        for(int i=0;i<nestedList.size();i++){

            if(nestedList.get(i).isInteger()){
                total+= depth*nestedList.get(i).getInteger();
            }else{
                total+=totalSum(nestedList.get(i).getList(), depth+1);
            }
        }
        return total;
    }
    
}
