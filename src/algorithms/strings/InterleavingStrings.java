package algorithms.strings;

/**
 * https://leetcode.com/problems/interleaving-string/
 * Time and Space Complexity is O(n*m)
 * n- length of s1
 * m- length of s2
 */
public class InterleavingStrings {
    public static boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length()+s2.length()>s3.length())
            return false;

        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return isValid(s1,0,s2,0,s3,dp);
    }

    public static Boolean isValid(String s1, int index1, String s2, int index2, String s3,Boolean[][] dp){

        if(index1>=s1.length() && index2>=s2.length() && index1+index2 ==s3.length()){
            return true;
        }

        if(null!=dp[index1][index2])
            return dp[index1][index2];

        boolean valid =false;

        if(index1<s1.length() && s1.charAt(index1)==s3.charAt(index1+index2)){
            valid = isValid(s1,index1+1, s2,index2,s3,dp);
        }

        if(valid)
            return valid;

        if(index2<s2.length() && s2.charAt(index2)==s3.charAt(index1+index2)){
            valid = isValid(s1,index1, s2,index2+1,s3,dp);
        }

        dp[index1][index2]=valid;

        return  dp[index1][index2];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
        System.out.println(isInterleave("aabcc","dbbca","aadbbbaccc"));
        System.out.println(isInterleave("","","a"));
    }
}
