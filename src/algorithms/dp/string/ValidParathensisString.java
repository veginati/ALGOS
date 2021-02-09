package algorithms.dp.string;

public class ValidParathensisString {

    public static boolean checkValidString(String s) {
        if(s.length()==0)
            return true;
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] ch = s.toCharArray();

        //base conditions
        for(int i=0;i<s.length();i++)
            dp[i][i] = ch[i]=='*';

        for(int i=1;i<s.length();i++){
            if(ch[i-1] =='(' && ch[i] ==')'){
                dp[i-1][i]=true;
            }else if(ch[i-1] =='*' && ch[i] ==')'){
                dp[i-1][i]=true;
            }else if(ch[i-1] =='(' && ch[i] =='*'){
                dp[i-1][i]=true;
            }else if(ch[i-1] =='*' && ch[i] =='*'){
                dp[i-1][i]=true;
            }
        }

        for(int j=2;j<s.length();j++){
            for(int i=0;i+j<s.length();i++){

                if(ch[i] =='(' && ch[i+j] ==')' && dp[i+1][i+j-1]){
                    dp[i][i+j]=true;
                }else if(ch[i] =='(' && ch[i+j] =='*' && dp[i+1][i+j-1]){
                    dp[i][i+j]=true;
                }else if(ch[i] =='(' && ch[i+j] =='*' && dp[i][i+j-1]){
                    dp[i][i+j]=true;
                }else if(ch[i] =='*' && ch[i+j] ==')' && dp[i+1][i+j]){
                    dp[i][i+j]=true;
                }else if(ch[i] ==')' && ch[i+j] ==')'){
                    dp[i][i+j]=false;
                }else{

                    boolean flag =false;
                    int k=i+j-1;
                    while(!flag && k>=i){
                        flag = dp[i][k] &&dp[k+1][i+j];
                        k--;
                    }
                    dp[i][i+j]=flag;
                }
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("()*()(()(*()(((())()()())*))()*()(*)(((*))(())(())((*()*(()(())()*(((*(**))((())*)(((()()))(())()))"));
    }
    }

