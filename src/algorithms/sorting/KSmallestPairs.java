package algorithms.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> bag = new PriorityQueue<>((a, b)->b[2]-a[2]);

        for(int i=0;i<nums1.length;i++){

            for(int j=0;j<nums2.length;j++){

                if(bag.size()<k){
                    bag.offer(new int[]{nums1[i],nums2[j],nums1[i]+nums2[j]});
                }else if(nums1[i]+nums2[j]< bag.peek()[2]){
                    bag.poll();
                    bag.offer(new int[]{nums1[i],nums2[j],nums1[i]+nums2[j]});
                }else{
                    break;
                }
            }
        }

        List<List<Integer>> output = new LinkedList<>();

        while(bag.size()>0){
            int[] data = bag.poll();
            output.add(0, Arrays.asList(data[0],data[1]));
        }

        return output;
    }
}
