package algorithms.dp;

public class RegularExpressionMatch {


    public  static boolean isMatch(String s, String p) {

        int maxValue = Math.max(p.length(),s.length());
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return isValid(s,p,0,0, maxValue,dp);
    }

    public static boolean isValid(String s, String p, int index, int index2, int maxValue, Boolean[][] dp){

        if(index>=s.length() && index2 >=p.length()){
            return true;
        }else if(index>s.length() || index2 >=p.length()){
            return false;
        }

        if(null != dp[index][index2]){
            return dp[index][index2];
        }

        boolean output =false;
        char ch = (index>=s.length())?'#':s.charAt(index);
        if(index2+1 <p.length() && '*' == p.charAt(index2+1) && '.' == p.charAt(index2)){
            for(int i=0;i<=maxValue &&!output;i++)
                output = output || isValid(s,p,index+i,index2+2,maxValue,dp);
        }else if(index2+1 <p.length() && '*' == p.charAt(index2+1)){
            // all other characters
            for(int i=0;i<=maxValue &&!output;i++){
                if(i==0 || (index+i-1<s.length() &&s.charAt(index+i-1) == p.charAt(index2))){
                    output = output || isValid(s,p,index+i,index2+2,maxValue,dp);
                }else{
                    break;
                }
            }
        }else if( ch == p.charAt(index2) || (index<s.length() &&'.'== p.charAt(index2))){
            output = output || isValid(s,p,index+1,index2+1,maxValue,dp) ;
        }

        dp[index][index2] = output;
        return dp[index][index2];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaa",".*.."));
        System.out.println(isMatch("a",".*.."));
        System.out.println(isMatch("aaa","a"));
        System.out.println(isMatch("aa","aab*b*"));
        System.out.println(isMatch("aa","a*"));
        System.out.println(isMatch("ab",".*"));
        System.out.println(isMatch("aab","c*a*b"));
        System.out.println(isMatch("mississippi","mis*is*p*."));
        System.out.println(isMatch("abbbaba","ab*a.a"));
        System.out.println(isMatch("abbbaba",".b*a.a"));
        System.out.println(isMatch("abbbaba","....b*a.a"));
    }
}
