package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {


    static void generateCombinations(int n, int index, int left,int right, char[] ch, List<String> coll){

        if(left == n && right ==n){
            coll.add(String.valueOf(ch));
            return;
        }
        if(left> n || right>n || right>left || index>=2*n){
            return;
        }

        ch[index] = '(';
        generateCombinations(n,index+1,left+1,right,ch,coll);
        ch[index] = ')';
        generateCombinations(n,index+1,left,right+1,ch,coll);
    }

    static List<String> wellFormedParenthesis(int n){
        List<String> coll = new ArrayList<>();
        generateCombinations(n,0,0,0,new char[2*n],coll);

        return coll;
    }


    public static void main(String[] args) {
        System.out.println(wellFormedParenthesis(2));
        System.out.println(wellFormedParenthesis(3));
        System.out.println(wellFormedParenthesis(4));
    }
}
