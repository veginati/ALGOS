package algorithms.m8;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    
    public long taskSchedulerII(int[] tasks, int space) {

        long minDay=0;
        Map<Integer, Long> prevDay = new HashMap<>();

        for(int task:tasks){
            if(prevDay.containsKey(task)){
                minDay = Math.max(minDay, prevDay.get(task)+space);
            }
            ++minDay;
            prevDay.put(task, minDay);
        }
        return minDay;
    }
}