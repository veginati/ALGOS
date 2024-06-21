package algorithms.alpha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

    class CustomComparator implements Comparator<String>{
        @Override
        public int compare(String s1, String s2){
            String tempa = s1+s2;
            String tempb = s2+s1;
            return tempb.compareTo(tempa);
        }
    }
    public String largestNumber(int[] nums) {

        List<String> testNums = new ArrayList<>();
        for(int num:nums){
            testNums.add(String.valueOf(num));
        }

        Collections.sort(testNums, new CustomComparator());
        if (testNums.get(0).equals("0")) {
            return "0";
        }

        StringBuffer output = new StringBuffer();

        for(String testStr: testNums){
            output.append(testStr);
        }
    return output.toString();
  }
}