package algorithms.dp;

public class WildCardMatching {
    public static boolean isMatch(String s, String p) {

        Boolean[][] dp = new Boolean[s.length()+1][p.length()];
        return isMatch(0,0,s,p,dp);
    }

    private static boolean isMatch(int sIndex, int pIndex, String s,String p,Boolean[][] dp){

        if(sIndex == s.length() && pIndex == p.length()){
            return true;
        }else if(sIndex > s.length() || pIndex == p.length()){
            return false;
        }

        char pChar = p.charAt(pIndex);
        char sChar = sIndex<s.length()?s.charAt(sIndex):'#';

        if(pIndex == p.length()-1 && '*'== pChar){
            return true;
        }

        if(null!=dp[sIndex][pIndex]){
            return dp[sIndex][pIndex];
        }

        boolean output = false;

        if('?'== pChar || pChar == sChar ){
            output = output || isMatch(sIndex+1, pIndex+1, s,p,dp);
        }else if('*'==pChar){

            for(int i=0;i<Math.max(s.length(),p.length());i++){
                output = output|| isMatch(sIndex+i, pIndex+1, s,p,dp);
            }
        }

        dp[sIndex][pIndex]= output;
        return dp[sIndex][pIndex];
    }

    public static void main(String[] args) {

        System.out.println(isMatch("mississippi","m??*ss*?i*pi"));
        System.out.println(isMatch("ho","ho**"));
        System.out.println(isMatch("a","a**"));
        System.out.println(isMatch("aa","*"));
        System.out.println(isMatch("","*********"));
        System.out.println(isMatch("abcdef","abcdeg*"));
    }
}