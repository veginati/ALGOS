package algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {

    Map<String, List<Integer>> dict = null;

    public WordDistance(String[] words) {
        dict = new HashMap<>();
        int i=0;
        for(String word:words){
            dict.putIfAbsent(word, new ArrayList<>());
            dict.get(word).add(i++);
        }
    }

    public int shortest(String word1, String word2) {

        List<Integer> word1Index = dict.get(word1);
        List<Integer> word2Index = dict.get(word2);

        int i=0,j=0;
        int dist = Integer.MAX_VALUE;

        while(i<word1Index.size() && j<word2Index.size()){

            int iValue = word1Index.get(i);
            int jValue = word2Index.get(j);

            dist = Math.min(dist, Math.abs(iValue-jValue));

            if(iValue<jValue){
                i++;
            }else{
                j++;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        WordDistance wordDistance = new WordDistance(new String[]{"practice","makes","perfect","coding","makes"});
        System.out.println(wordDistance.shortest("makes","coding"));
        System.out.println(wordDistance.shortest("coding","practice"));
    }
}
