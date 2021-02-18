package tailwind;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Data{

    public Map<String,Integer> getCount(String s){
        String tempData = s.toLowerCase();

        String[] split = tempData.split(" ");
        Map<String,Integer> wordCount =new HashMap<String,Integer>();

        for(String eachString:split){
            char[] ch = eachString.toCharArray();
            StringBuilder sb = new StringBuilder();

            for(char eachChar:ch){
                if(eachChar>=97 && eachChar<=122){
                    sb.append(eachChar);
                }
            }

            String keyword = sb.toString();

            if(keyword.length()>0){
                wordCount.put(keyword, 1+wordCount.getOrDefault(keyword,0));
            }

        }

        return wordCount;
    }

    public void writeToFile(Map<String,Integer> wordCount){

        Set<String> keysObj = wordCount.keySet();
        Iterator<String> itrObj = keysObj.iterator();

        try{

            PrintWriter pw = new PrintWriter(new File("temp.txt"));

            while(itrObj.hasNext()){

                String key = itrObj.next();
                Integer val = wordCount.get(key);
                pw.println(key+" "+val);
            }
            pw.flush();
        }catch(FileNotFoundException fe){
            fe.printStackTrace();
        }
    }

    public static void main(String[] args){

        String input = "My Own Data, feels good to count @wOrds";
        Data dataObj = new Data();
        dataObj.writeToFile(dataObj.getCount(input));
    }

}