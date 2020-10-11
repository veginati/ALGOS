package algorithms.strings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 * Time Complexity : O (n) , validating till end of the string
 * Space Complexity: O( maximum of left or right brackets in the string)
 */
public class MaximumNestingParathesis {

    public static int maxDepth(String s) {

        Deque<String> stack = new ArrayDeque<>();
        int max =0;
        char[] ch = s.toCharArray();


        for (char data : ch) {

            if ('(' == data) {
                stack.offerFirst("(");
            } else if (')' == data) {

                int total = 0;

                while (!stack.isEmpty() && !"(".equals(stack.peekFirst())) {
                    total += Integer.parseInt(stack.pollFirst());
                }
                stack.pollFirst();
                ++total;
                while (!stack.isEmpty() && !"(".equals(stack.peekFirst())) {
                    total = Math.max(total, Integer.parseInt(stack.pollFirst()));
                }
                max = Math.max(max, total);

                if (!stack.isEmpty()) {
                    stack.offerFirst(String.valueOf(total));
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
        System.out.println(maxDepth("1+(2*3)/(2-1)"));
        System.out.println(maxDepth("1"));
    }
}