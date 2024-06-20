package algorithms.alpha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> mem = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            mem.add(new ArrayList<>());
        }

        for(int i=0;i<nums.length;i++){
            List<Integer> tempList = new ArrayList<>();
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j] == 0 && mem.get(j).size()>tempList.size()){
                    tempList = mem.get(j);
                }
            }
            //tempList.add(nums[i]);
            mem.get(i).addAll(tempList);
            mem.get(i).add(nums[i]);
            //System.out.println(mem);
        }
        
        List<Integer> output = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(mem.get(i).size()>output.size()){
                output = mem.get(i);
            }
        }
        return output;
    }
}