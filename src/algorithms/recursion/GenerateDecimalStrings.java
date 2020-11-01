package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateDecimalStrings {

    public static List<String> generateDecimalString(int n){

        List<String> output = new ArrayList<>();
        helper(0,n,new char[n],output);;
        return output;
    }

    public static void helper(int index, int n, char[] ch, List<String> output){

        //base case
        if(index == n){
            output.add(String.valueOf(ch));
        }else {
            for(int i=0;i<10;i++){
                ch[index] = Character.forDigit(i,10);
                helper(index+1,n,ch,output);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(generateDecimalString(2));
    }
}
