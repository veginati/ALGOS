package algorithms.m8;

public class MinParameter {
    
    public int minAddToMakeValid(String s) {
        int left=0;
        int count=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                ++left;
            }else{
                --left;
            }

            if(left<0){
                ++count;
                left=0;
            }
        }

        count+=left;
        return count;
    }
}
