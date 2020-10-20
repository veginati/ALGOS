package algorithms.strings;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Time complexity : O ( Math.pow(2,n))
 * Space Complexity : O( Math.log(n)/Math.log(2))
 */
public class GenerateCombinations {

    public static List<String> getCombinations(String input, String[] dict){
        List<String>  output = new ArrayList<>();
        HashSet<String> setDictionary = new HashSet<>();
        Collections.addAll(setDictionary, dict);
        generateCombinations(0,input,output,setDictionary,new ArrayList<>());
        return  output;
    }

    public static void generateCombinations(int index, String input, List<String> output, HashSet<String> dict, List<String> currentList) {

        if(index == input.length()){
            String[] temp = new String[currentList.size()];
            output.add(String.join(" ",currentList.toArray(temp)));
            return;
        }

        for(int i=index;i<input.length();i++){

            if(dict.contains(input.substring(index,i+1))) {
                currentList.add(input.substring(index, i + 1));
                generateCombinations(i + 1, input, output, dict, currentList);
                currentList.remove(currentList.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(getCombinations("abcd", new String[]{"a","b","ab","cd"}));
        System.out.println(getCombinations("abcd", new String[]{"a","b","c","d","ab","bc","cd","abc","bcd","abcd"}));
    }
}
