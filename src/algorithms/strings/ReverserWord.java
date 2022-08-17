package algorithms.strings;

class ReverseWord {
    public void reverseWords(char[] s) {
        // reverse whole string.        
        reverseString(0,s.length,s);
        int previousIndex =0;
        for(int i=0;i<=s.length;i++){
            if(i==s.length || s[i]== ' '){
                reverseString(previousIndex,i,s);
                previousIndex=i+1;
            }
        }
        
    }
    
    public void reverseString(int start, int end, char[] s){
        for(int i=start,j=end-1;i<=j;i++,j--){
            char temp = s[j];
            s[j]= s[i];
            s[i]=temp;
        }
    }
}
