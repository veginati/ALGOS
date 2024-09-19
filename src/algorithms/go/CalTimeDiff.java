package algorithms.go;

import java.util.List;

class CalTimeDiff{

    public int findMinDifference(List<String> timePoints) {
        timePoints.sort((a,b)->a.compareTo(b));

        int minTimeDiff = 24*60;

        for(int i=0;i<timePoints.size()-1;i++){
            String next = timePoints.get(i+1);
            String curr = timePoints.get(i);
            minTimeDiff = Math.min(minTimeDiff, getDiff(curr, next));
            //System.out.println(minTimeDiff);
        }
        

         minTimeDiff = Math.min(minTimeDiff, getDiff(timePoints.get(0), timePoints.get(timePoints.size()-1)));

        return minTimeDiff;
    }

    private int getDiff(String time1, String time2){

        String[] data1 = time1.split(":");
        String[] data2 = time2.split(":");

        int min1 = Integer.valueOf(data1[0])*60+Integer.valueOf(data1[1]);
        int min2 = Integer.valueOf(data2[0])*60+Integer.valueOf(data2[1]);
        int min3 = 24*60-min2+min1;
        //System.out.println(min1+"_"+min2+"_"+min3);
        return Math.min(Math.abs(min2-min1), Math.abs(min3));
    }
}