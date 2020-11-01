package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateLetterCase {

    static List<String> driver(String input){
        List<String> result = new ArrayList<>();
        helper(input,0,"",result);
        return  result;
    }

    static void helper(String input, int index, String soFar, List<String> collection){

        if(index == input.length()){
            collection.add(soFar);
        }else{
            char currentChar = input.charAt(index);

            if(Character.isDigit(currentChar)){
                helper(input,index+1,soFar+currentChar,collection);
            }else{
                helper(input,index+1,soFar+Character.toLowerCase(currentChar),collection);
                helper(input,index+1,soFar+Character.toUpperCase(currentChar),collection);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(driver("t1D2"));
    }
}
