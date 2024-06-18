package algorithms.alpha;

public class Anagrams {
    public int minSteps(String s, String t) {
        //Map<Character,Integer> countMap = new HashMap<>();
        int[] charArray = new int[26];
        for(int i=0;i<s.length();i++){
            charArray[s.charAt(i)-97]+=1;
            charArray[t.charAt(i)-97]-=1;
        }

        int count=0;
        for(int i=0;i<26;i++){
            if(charArray[i]>0){
                count+=charArray[i];
            }
        }
        return count;
    }
}