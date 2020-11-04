package algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateSubSets {

    /*
     * Complete the function below.
     */
    static String[] generate_all_subsets(String s) {

        List<String> coll = new ArrayList<>();
        generateSubsets(0,s,new StringBuilder(),coll);

        String[] output = new String[coll.size()];
        return coll.toArray(output);
    }

    static void generateSubsets(int index,String s, StringBuilder soFar,List<String> coll){

        if(index == s.length()){
            coll.add(soFar.toString());
            return;
        }

        generateSubsets(index+1,s,soFar,coll);
        soFar.append(s.charAt(index));
        generateSubsets(index+1,s,soFar,coll);
        soFar.deleteCharAt(soFar.length()-1);
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(generate_all_subsets("xyz")));
    }
}
