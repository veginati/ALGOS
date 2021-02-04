package algorithms.strings;

public class TwoStringsEqual {

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        int i=0;
        int j=0;
        int k=0;
        int l=0;

        while(i<word1.length && j<word2.length){

            if(k<word1[i].length() && l< word2[j].length() && word1[i].charAt(k++)!= word2[j].charAt(l++)){
                return false;
            }

            if(k == word1[i].length()){
                k=0;
                i++;
            }

            if(l == word2[j].length()){
                l=0;
                j++;
            }
        }

        return i==word1.length && j==word2.length && k==0 && l==0;
    }

    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
    }
}
