package algorithms.math;

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 * Time and space is O(1) time
 */
public class SumOfTwoInteger {

    public static int getSum(int a, int b) {

        int total;
        int carry;

        do{
            total= a^b;
            carry = (a&b)<<1;
            a =total;
            b =carry;
        }while(carry!=0);

        return total;
    }

    public static void main(String[] args) {
        System.out.println(getSum(15,16) == 31);
        System.out.println(getSum(2147483647,-2147483648) ==-1);
    }
}
