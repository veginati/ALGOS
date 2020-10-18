package algorithms.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/submissions/
 * Time Complexity is O(n)
 * Space Complexity is O(1)
 */
public class FindAllAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {

        Integer[] countCharacterInPattern = new Integer[26];
        List<Integer> indices =new ArrayList<>();

        if(null == s || null ==p || s.length() ==0 || p.length() ==0)
            return indices;

        int total=p.length();
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();


        for (char pChar : pChars) {

            if (null == countCharacterInPattern[pChar - 'a'])
                countCharacterInPattern[pChar - 'a'] = 0;
            countCharacterInPattern[pChar - 'a']++;
        }

        for(int i=0,j=-1;i<sChars.length;i++){

            char currentChar =sChars[i];

            if(null== countCharacterInPattern[currentChar-'a']){

                while(j+1<i){
                    char prevChar =sChars[++j];
                    ++countCharacterInPattern[prevChar-'a'];
                    ++total;
                }
                ++j;
            }else if(countCharacterInPattern[currentChar-'a'] ==0){
                while(sChars[j+1]!=currentChar){
                    char prevChar =sChars[++j];
                    ++countCharacterInPattern[prevChar-'a'];
                    ++total;
                }
                ++j;
            }else{
                --countCharacterInPattern[currentChar-'a'];
                --total;
            }

            if(total ==0){
                indices.add(i+1-pChars.length);
                char prevChar =sChars[++j];
                ++countCharacterInPattern[prevChar-'a'];
                ++total;
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
        System.out.println(findAnagrams("abababababab","ab"));
        System.out.println(findAnagrams("badcdsabad","dab"));
    }
}

