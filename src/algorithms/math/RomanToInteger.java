package algorithms.math;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * Constriants of the problem:
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 *
 * With the following the constraints : Time complexity of a roman number is O(1)
 * Space Complexity is O(1)
 */
public class RomanToInteger {
        public static int romanToInt(String s) {

            Map<Character,Integer> romanValues = new HashMap<>();

            romanValues.put('I',1);
            romanValues.put('V',5);
            romanValues.put('X',10);
            romanValues.put('L',50);
            romanValues.put('C',100);
            romanValues.put('D',500);
            romanValues.put('M',1000);

            char[] ch = s.toCharArray();
            //output
            int total =0;

            //sum of values which are continuously greater
            int tempTotal=romanValues.get(ch[0]);

            //difference of values if they are continuously increasing.
            int  localMaximum =romanValues.get(ch[0]);

            for(int i=1;i<ch.length;i++){

                if(romanValues.get(ch[i])<=romanValues.get(ch[i-1])){
                    total+=localMaximum;
                    tempTotal =romanValues.get(ch[i]);
                    localMaximum=romanValues.get(ch[i]);
                }else{
                    localMaximum = romanValues.get(ch[i])-tempTotal;
                    tempTotal+=romanValues.get(ch[i]);
                }
            }

            if(localMaximum>0)
                total+=localMaximum;

            return total;
        }

    public static void main(String[] args) {

           System.out.println( romanToInt("MMMCMXCIX"));
           System.out.println( romanToInt("CDMIV"));
    }
}
