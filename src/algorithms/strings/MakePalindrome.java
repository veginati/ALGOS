package algorithms.strings;

public class MakePalindrome {

    /**
     * https://leetcode.com/problems/split-two-strings-to-make-palindrome/
     * Time complexity : O(n)
     * Space Complexity : O(1)
     * @param a
     * @param b
     * @return
     */
    public  static boolean checkPalindromeFormation(String a, String b) {

        if(a.length()<=1){
            return true;
        }

        int i=0, j= b.length()-1;

        while(i<j){
            if(a.charAt(i) ==b.charAt(j) ){
                i++;
                j--;
            }else if( isPalindrome(a.substring(i,a.length()-i)) || isPalindrome(b.substring(i,b.length()-i))){
                return true;
            }else{
                break;
            }
        }

        if(i ==j ||j<i) {
            return true;
        }

        i=0;
        j= b.length()-1;

        while(i<j){
            if(b.charAt(i) ==a.charAt(j) ){
                i++;
                j--;
            }else if( isPalindrome(b.substring(i,b.length()-i)) || isPalindrome(a.substring(i,a.length()-i))){
                return true;
            }else{
                break;
            }
        }
        if(i ==j ||j<i) {
            return true;
        }
        return false;
    }

    public  static boolean isPalindrome(String s){

        int i=0;
        int j=s.length()-1;

        while(i<j){

            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {

       System.out.println(checkPalindromeFormation("ulacfd","jizalu"));
         System.out.println(checkPalindromeFormation("feibaaabb","desterief"));
        System.out.println(checkPalindromeFormation("abddfd","eredba"));
        System.out.println(checkPalindromeFormation("pvhmupgqeltozftlmfjjde","yjgpzbezspnnpszebzmhvp"));
        System.out.println(checkPalindromeFormationv2("pvhmupgqeltozftlmfjjde","yjgpzbezspnnpszebzmhvp"));
         }

    /**
     * Time complexity : O(n^2)
     * @param a
     * @param b
     * @return
     */
    public  static boolean checkPalindromeFormationv2(String a, String b) {

        if(a.length()<=1){
            return true;
        }
        for(int i=0;i<a.length();i++){
            if(isPalindrome(a.substring(0,i)+b.substring(i)) || isPalindrome(b.substring(0,i)+a.substring(i))){
                System.out.println(a.substring(0,i)+b.substring(i));
                System.out.println(b.substring(0,i)+a.substring(i));
                return true;
            }
        }

        return false;
    }
}
