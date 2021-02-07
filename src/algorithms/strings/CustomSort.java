package algorithms.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomSort {
    public static String customSortString(String S, String T) {

        final int[] pos = new int[26];
        Arrays.fill(pos,-1);

        for(int i=0;i<S.length();i++){
            pos[S.charAt(i)-'a'] = i+1;
        }
         return Stream.of(T.split("")).sorted((a,b)->pos[a.charAt(0)-'a']-pos[b.charAt(0)-'a']).collect(Collectors.joining());
    }

    public static void main(String[] args) {
       System.out.println(customSortString("cba","abcd"));
       System.out.println(customSortString("cba","abcdabacadabacecded"));
    }
}
