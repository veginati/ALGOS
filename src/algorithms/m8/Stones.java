package algorithms.m8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stones {

     public int[] numMovesStones(int a, int b, int c) {

        //int[] output = new int[2];
        List<Integer> temp = new ArrayList<>();
        temp.add(a);
        temp.add(b);
        temp.add(c);
        Collections.sort(temp);
        return new int[]{min(temp),max(temp)};
    }

    public int min(List<Integer> temp){

        if(temp.get(1)-temp.get(0)==1 && temp.get(2)-temp.get(1)==1){
            return 0;
        }

        if(temp.get(1)-temp.get(0)<=2 || temp.get(2)-temp.get(1)<=2){
            return 1;
        }

        return 2;
    }

    public int max(List<Integer> temp){
        return temp.get(2)-temp.get(0)-2;
    }
    
}
