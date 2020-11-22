package algorithms.dp.prep;

public class InterleavingStrings {


    public static boolean isInterleaving(char[] a, char[] b, char[] c){

        boolean[][] validateInterL = new boolean[a.length+1][b.length+1];

        //base case.
        validateInterL[0][0] =true;

        for(int i=0;i<=a.length;i++){
            for(int j=0;j<=b.length;j++){
                validateInterL[i][j] = (i==0 && j==0) ||
                        (i>0 && validateInterL[i-1][j] && a[i-1] == c[i+j-1]) ||
                        (j>0 && validateInterL[i][j-1] && b[j-1] == c[i+j-1]);
            }
        }
        return validateInterL[a.length][b.length];
    }

    public static void main(String[] args) {

        String a = new String("xxyx");
        String b = new String("xzy");
        String c = new String("xxzxyyx");
        System.out.println(isInterleaving(a.toCharArray(),b.toCharArray(),c.toCharArray()));
    }
}
