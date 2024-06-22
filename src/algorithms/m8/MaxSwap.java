package algorithms.m8;
import java.util.*;
public class MaxSwap {
    

    public int maximumSwap(int num) {

        List<Integer> base10 = new ArrayList<>();

        while(num>0){
            base10.add(num%10);
            num=num/10;
        }

        Collections.reverse(base10);

        for(int i=0;i<base10.size();i++){
            int value=base10.get(i);
            int index=-1;
            int maxValue=value;
            for(int j=i+1;j<base10.size();j++){
                if(base10.get(j)>value && base10.get(j)>=maxValue){
                    maxValue=base10.get(j);
                    index=j;
                }
            }

            if(index!=-1){
                swap(base10, i, index);
                break;
            }
        }

        Collections.reverse(base10);

        int output=0;
        int base=1;
        for(int k=0;k<base10.size();k++){
            output+=base10.get(k)*base;
            base=base*10;
        }
        return output;
    }

    public void swap(List<Integer> base10, int index1, int index2){
        int value1 = base10.get(index1);
        base10.set(index1, base10.get(index2));
        base10.set(index2,value1);
    }
}
