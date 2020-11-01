package algorithms.recursion;

public class GeneratePermutations {


    static void helper(char[] ch, int idx, StringBuilder soFar){
        if(idx == ch.length)
            System.out.println(soFar.toString());
        else{
            for(int i=idx;i<ch.length;i++){
                swap(ch,idx,i);
                soFar.append(ch[idx]);
                helper(ch,idx+1,soFar);
                swap(ch,idx,i);
                soFar.deleteCharAt(soFar.length()-1);
            }
        }
    }

   static void swap( char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
   }

    public static void main(String[] args) {
        String data = "hat";
        helper(data.toCharArray(),0,new StringBuilder(""));
    }
}
