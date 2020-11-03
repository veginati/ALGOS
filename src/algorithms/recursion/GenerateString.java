package algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateString {

    static String[] generate_all_expressions(String s, long target) {

        List<String> coll = new ArrayList<>();
        generateExpression(0,0L,new StringBuilder(),s,0L,coll,target);

        String[] output = new String[coll.size()];
        return coll.toArray(output);
    }


    static void generateExpression(int index, long previousValue, StringBuilder soFar,String s, long totalValue,List<String> coll,long target){

        if(index == s.length() && totalValue==target){
            coll.add(soFar.toString());
            return;
        }

        if(index>=s.length()){
            return;
        }

        for(int i=index;i<s.length();i++){

            Long value = Long.valueOf(s.substring(index,i+1));


            if(soFar.length()>0){

                soFar.append("+").append(s.substring(index,i+1));
                generateExpression(i+1,value, soFar,s,totalValue+value,coll,target);
                soFar.setLength(soFar.length()-(i+2-index));

                soFar.append("*").append(s.substring(index,i+1));
                generateExpression(i+1,value*previousValue, soFar,s,(totalValue-previousValue+(value*previousValue)),coll,target);
                soFar.setLength(soFar.length()-(i+2-index));

            }else{
                soFar.append(s.substring(index,i+1));
                generateExpression(i+1,value, soFar,s,totalValue+value,coll,target);
                soFar.setLength(soFar.length()-(i+1-index));
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generate_all_expressions("52341",20)));
    }
}
