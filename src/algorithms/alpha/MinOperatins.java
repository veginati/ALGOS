package algorithms.alpha;

import java.util.HashMap;
import java.util.Map;
//LC-2870
public class MinOperatins {

    public int minOperations(int[] nums) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num:nums){
            countMap.put(num, 1+countMap.getOrDefault(num,0));
        }
        
        int min=0;
        for(Integer key:countMap.keySet()){
            Integer valCount = countMap.get(key);

            if(valCount==1){
                return -1;
            }

            int div2 = valCount/2;
            int div3 = valCount%3==0?valCount/3:valCount/3+1;
            min+= Math.min(div2,div3);
        }
        return min;
    }
}