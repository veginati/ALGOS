package algorithms.trees;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface NestedInteger{
              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();
 
              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();
 
              // Set this NestedInteger to hold a single integer.
              public void setInteger(int value);
 
              // Set this NestedInteger to hold a nested list and adds a nested integer to it.
              public void add(NestedInteger ni);
 
              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return empty list if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }
 
public class NestedListWeight {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Map<Integer,Integer> output = new HashMap<>();
        addElements(nestedList, output, 0) ;
        // System.out.println(output);
        int total=0;

        for(int i=output.size()-1,k=1;i>=0;i--,k++)  {
            total+= output.get(i)*k;
        }

        return total;
    }

    public void addElements(List<NestedInteger> nestedList, Map<Integer,Integer> dataDepth, int depth){

        dataDepth.putIfAbsent(depth,0);
        nestedList.forEach(i->{
            if( i.isInteger()){
                dataDepth.put(depth,i.getInteger()+dataDepth.get(depth));
            }else{
                if(null!=i.getList())
                    addElements(i.getList(),dataDepth,1+depth);
            }
        });

    }
}
