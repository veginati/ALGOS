package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubSets {

    void helper(int[] input, int idx, StringBuilder soFar, List<String> coll ){

        if(idx == input.length){
            coll.add(soFar.toString());
        }else{
            helper(input,idx+1, soFar,coll);
            soFar.append(input[idx]);
            helper(input,idx+1, soFar,coll);
            soFar.deleteCharAt(soFar.length()-1);
        }
    }

    public void generatePowerSet(int[] input){
        List<String> result =new ArrayList<>();
        helper(input,0,new StringBuilder(),result);
    }
}
