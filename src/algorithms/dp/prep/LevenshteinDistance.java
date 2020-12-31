package algorithms.dp.prep;

public class LevenshteinDistance {

    /*
     * Complete the levenshteinDistance function below.
     */
    static int levenshteinDistance(String strWord1, String strWord2) {
        /*
         * Write your code here.
         */

        char[] word1 = strWord1.toCharArray();
        char[] word2 = strWord2.toCharArray();

        int[][] cache = new int[word1.length+1][word2.length+1];

        for(int i=0;i<=word1.length;i++)
            cache[i][0]=i;

        for(int j=0;j<=word2.length;j++)
            cache[0][j]=j;

        for(int i=1;i<=word1.length;i++){

            for(int j=1;j<=word2.length;j++){

                if(word1[i-1]!=word2[j-1]){
                    cache[i][j] = 1+Math.min(cache[i-1][j-1],Math.min(cache[i][j-1],cache[i-1][j]));
                }else{
                    cache[i][j] = cache[i-1][j-1];
                }
            }
        }

        return cache[word1.length][word2.length];

    }

    public static void main(String[] args) {
        System.out.println(levenshteinDistance("kitten","sitting"));
    }
}
