package algorithms.m8;

public class ValidAbb {

    public static boolean validWordAbbreviation(String word, String abbr) {
        
        int currIdx=0;
        StringBuffer tempBuffer = new StringBuffer();

        for(int i=0;i<=abbr.length();i++){

            if(i<abbr.length() && Character.isDigit(abbr.charAt(i))){
                if(tempBuffer.length() ==0 && abbr.charAt(i)=='0'){
                    return false;
                }
                tempBuffer.append(abbr.charAt(i));
            }else{
                if(tempBuffer.length()>0){
                    Integer num = Integer.valueOf(tempBuffer.toString());
                    currIdx+=num;
                    tempBuffer.setLength(0);
                }

                if(i<abbr.length() && currIdx>=word.length()){
                    return false;
                }

                if(i<abbr.length() && word.charAt(currIdx)!=abbr.charAt(i)){
                        return false;
                }
                currIdx++;
            }

        }


        return currIdx==word.length()+1;

    }

    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("internationalization", "i12iz4n")== true);
        System.out.println(validWordAbbreviation("substitution", "12")== true);
        System.out.println(validWordAbbreviation("substitution", "su3i1u2on")== true);
        System.out.println(validWordAbbreviation("internationalization", "i011")== false);
    }
    
}
