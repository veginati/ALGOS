package algorithms.graph.prep;

import java.util.*;

public class WordLadder2 {


    class Data{
        String w;
        int d;
        Data p;

        public Data(String w, int d){
            this.w =w;
            this.d =d;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> output = new ArrayList<>();
        Set<String> unie = new HashSet<>(wordList);
        Map<String,List<String>> neiMap = new HashMap<>();

        if(!unie.contains(endWord)){
            return output;
        }
        if(diff(beginWord,endWord)){
            output.add(Arrays.asList(beginWord,endWord));
            return output;
        }
        List<Data> lastNodes = new ArrayList<Data>();
        bfs(beginWord,endWord,wordList,lastNodes,unie,neiMap);
        for(Data data:lastNodes){
            output.add(build(data,endWord));
        }
        return output;
    }

    public List<String> build(Data data,String end){

        Data curr =data;
        List<String> output =new ArrayList<String>();
        output.add(end);
        while(null!=curr){
            output.add(curr.w);
            curr = curr.p;
        }
        Collections.reverse(output);
        return output;
    }

    public void bfs(String start, String stop, List<String> wordList, List<Data> output,Set<String> unie, Map<String,List<String>> neiMap){

        Queue<Data> queue = new LinkedList<Data>();
        queue.offer(new Data(start,0));
        Set<String> visited = new HashSet<String>();

        while(queue.size()>0){
            Data polledData = queue.poll();
            String w = polledData.w;
            int depth = polledData.d;

            if(output.size()>0 && depth>output.get(0).d)
                break;

            if(diff(w,stop)){
                output.add(polledData);
                continue;
            }
            if(!neiMap.containsKey(w)){
                neiMap.put(w,findNeighbors( wordList,w,unie));
            }
            List<String> neighbors = neiMap.get(w);

            for(String nei : neighbors){
                if(!visited.contains(nei) && diff(w,nei)){
                    Data child = new Data(nei,1+depth);
                    child.p =polledData;
                    queue.offer(child);
                }
            }
            visited.add(w);
        }
    }

    public List<String> findNeighbors(List<String> words, String node, Set<String> unie){
        if(words.size()<node.length()*26)
            return find_nei_approach1(words,node);
        return find_nei_approach2(words,node,unie);
    }

    public List<String> find_nei_approach1(List<String> words, String node){

        List<String> neis = new ArrayList<String>();
        for(String word:words){
            if(diff(word,node)){
                neis.add(word);
            }
        }
        return neis;
    }

    public List<String> find_nei_approach2(List<String> words, String node,Set<String> unie){

        List<String> neis = new ArrayList<String>();
        char[] ch = node.toCharArray();

        for(int i=0;i<ch.length;i++){

            char temp = ch[i];
            for(int j=0;j<26;j++){
                ch[i] = (char)(96+j);
                String newWord = String.valueOf(ch);
                if(unie.contains(newWord) && diff(newWord,node)){
                    neis.add(newWord);
                }
            }
            ch[i] = temp;
        }
        return neis;
    }

    public boolean diff(String word1, String word2){

        int count=0;

        for(int i=0;i<word1.length();i++){

            if(word1.charAt(i)!=word2.charAt(i)){

                if(count>0)
                    return false;

                ++count;
            }
        }

        return count ==1;
    }

    public static void main(String[] args) {
        List<List<String>> ladder = new WordLadder2().findLadders("qa","sq",Arrays.asList("si","go","se","cm","so","ci","ca","br","ti","ta","tb","ni","mr","pa","sq","ye"));
        System.out.println(ladder);
    }
}
