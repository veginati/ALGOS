package com.learnings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AvoidFloods {

    public static void main(String[] args) {

        int[] o = avoidFlood(new int[]{1,2,3,0,0,1,2,0,0,3,0});

        for(int i=0;i<o.length;i++){
            System.out.println(o[i]);
        }
    }
    public static  int[] avoidFlood(int[] rains) {

        int[] output = new int[rains.length];

        HashMap<Integer,Integer> alreadyRained = new HashMap<Integer,Integer>();
        List<Integer> nonRainyDay = new ArrayList<>();
        List<Integer> rainyDay = new ArrayList<Integer>();

        for(int i=0;i<rains.length;i++){

            if(rains[i]>0){

                if(alreadyRained.containsKey(rains[i])){
                    if(nonRainyDay.size()>0){
                        int day = nonRainyDay.remove(0);
                        output[day]= rains[i];
                        output[i]=-1;
                        rainyDay.remove(alreadyRained.get(rains[i]));
                    }else{
                        return new int[]{};
                    }
                }else{
                    output[i]=-1;
                    alreadyRained.put(rains[i],i);
                    rainyDay.add(i);
                }
            }else{
                nonRainyDay.add(i);
            }
        }

        while(nonRainyDay.size()>0){
            int xday = nonRainyDay.remove(0);
            if(rainyDay.size()>0){
                int day = rainyDay.remove(0);
                output[xday]= rains[day];
            }else{
                output[xday]=1;
            }

        }

        return output;
    }

}
