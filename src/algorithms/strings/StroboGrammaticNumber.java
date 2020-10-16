package algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/strobogrammatic-number-ii/
 * Time compleixty : O (5 ^ n/2)
 * Space complexity : O( n/2) recursive stack
 *
 */
public class StroboGrammaticNumber {

        public static List<String> findStrobogrammatic(int n) {

            char[] validValues = {'0','1','6','8','9'};
            List<String> output = new ArrayList<>();

            if(n==0){
                output.add("");
                return output;
            }

            Map<Character,Character> mirror = new HashMap<>();
            mirror.put('0','0');
            mirror.put('1','1');
            mirror.put('6','9');
            mirror.put('8','8');
            mirror.put('9','6');


            generateStrobogrammatic(output,0,n,validValues,mirror,  new char[n]);

            return output;
        }

        public static void generateStrobogrammatic(List<String> output, int index, int n, char[] validValues, Map<Character,Character> mirror, char[] currString){

            if( (n%2 ==1 && index == n/2) || (n%2 ==0 &&index == n/2)){
                if(n%2 ==1){
                    char[] oddDigitValid = {'0','1','8'};
                    for(int i=0;i<oddDigitValid.length;i++){
                        currString[index]= oddDigitValid[i];
                        output.add(new String(currString));
                    }
                }else{
                    output.add(new String(currString));
                }
                return;
            }

            for(int i=0;i<validValues.length;i++){
                if(i ==0 && index==0)
                    continue;

                currString[index]= validValues[i];
                currString[n-(index+1)]= mirror.get(validValues[i]);
                generateStrobogrammatic(output, index+1, n, validValues, mirror, currString);
            }
        }

    public static void main(String[] args) {
        System.out.println(findStrobogrammatic(0));
        System.out.println(findStrobogrammatic(1));
        System.out.println(findStrobogrammatic(2));
        System.out.println(findStrobogrammatic(3));
        System.out.println(findStrobogrammatic(4));
    }
}