package ds.trie;

public class AddSearchWord {
     class Trie{

        Trie[] ch;
        boolean word;

        public Trie(){
            ch = new Trie[26];
            word =false;
        }

        private void setWord(){
            this.word = true;
        }

        private boolean isWord(){
            return word;
        }

        private Trie getTrieCh(int index){
            return ch[index];
        }

    }

    Trie root;
    /** Initialize your data structure here. */
    public AddSearchWord() {
        root = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

        Trie rootObj = root;

        for(int i=0;i<word.length();i++){

            if(null == rootObj.ch[word.charAt(i)-'a']){
                rootObj.ch[word.charAt(i)-'a'] = new Trie();
            }
            rootObj = rootObj.ch[word.charAt(i)-'a'];
        }
        rootObj.setWord();
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {

        return searchWord(word,0,root);
    }

    public boolean searchWord(String word, int index,Trie root){



        if(index == word.length()){
            return (null!=root)&&root.isWord();
        }

        boolean wordFound = false;
        if('.' == word.charAt(index)){

            for(int i=0;i<26 && !wordFound;i++){
                if(null!= root.getTrieCh(i)){
                    wordFound = searchWord(word, index+1, root.getTrieCh(i));
                }
            }
        }else{

            if(null!= root.getTrieCh(word.charAt(index)-'a')){
                wordFound = searchWord(word, index+1, root.ch[word.charAt(index)-'a']);
            }
        }

        return wordFound;
    }

    public static void main(String[] args) {

        AddSearchWord addSearchWord = new AddSearchWord();
        addSearchWord.addWord("maximum");
        addSearchWord.addWord("maximize");
        addSearchWord.addWord("minimum");

        System.out.println(addSearchWord.search("max....m"));
        System.out.println(addSearchWord.search("....m.m"));
        System.out.println(addSearchWord.search("maxim.m"));
    }
}
