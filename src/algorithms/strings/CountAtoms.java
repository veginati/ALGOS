package algorithms.strings;

import java.util.*;

public class CountAtoms {

    public static String countOfAtoms(String formula) {

        StringBuilder output = new StringBuilder();
        Map<String,Integer> map = countAtoms(formula.toCharArray(),0,formula.length());

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for(String keyId:keys){
            if(map.get(keyId)>1){
                output.append(keyId).append(map.get(keyId));
            }else{
                output.append(keyId);
            }
        }

        return output.toString();
    }

    public static Map<String,Integer> countAtoms(char[] formula, int startIndex,int endIndex){


        Map<String,Integer> currentMap = new HashMap<>();
        StringBuilder currentString = new StringBuilder();
        StringBuilder currentCount = new StringBuilder();

        for(int i=startIndex;i<=endIndex;i++){
            char ch = i<endIndex?formula[i]:'-';

            if(ch== '('){
                updateMap(currentString.toString(),currentCount.toString(),currentMap);
                currentString.setLength(0);
                currentCount.setLength(0);
                //find index of closing bracket.
                int j=i;
                int count=0;
                do{
                    if(formula[j]==')'){
                        --count;
                    }else if(formula[j]=='('){
                        ++count;
                    }
                }while(count>0 && ++j<endIndex);

                Map<String,Integer> tempMap = countAtoms(formula,i+1,j);
                while(j+1<endIndex && formula[j+1]>='0' && formula[j+1]<='9'){
                    currentCount.append(formula[++j]);
                }

                if(currentCount.length()>0){
                    Integer multipler = Integer.valueOf(currentCount.toString());

                    for(String keyId:tempMap.keySet()){
                        tempMap.put(keyId, multipler*tempMap.get(keyId));
                    }
                }
                merge(currentMap,tempMap);
                i=j;
                currentCount.setLength(0);
            }else if((ch>='A' && ch<='Z') || ch=='-'){
                updateMap(currentString.toString(),currentCount.toString(),currentMap);
                currentString.setLength(0);
                currentCount.setLength(0);
                currentString.append(ch);
            }else if(ch>='0' && ch<='9'){
                currentCount.append(ch);
            }else if(ch>='a' && ch<='z'){
                currentString.append(ch);
            }
        }

        return currentMap;
    }

    public static void updateMap(String key,String currentCount, Map<String,Integer> map){
        if(key.length()>0){
            Integer count = currentCount.length()>0 ? Integer.valueOf(currentCount):1;
            map.put(key,count+map.getOrDefault(key,0));
        }
    }

    public static void merge(Map<String,Integer> cMap, Map<String,Integer> tMap) {
        for (String key : tMap.keySet()) {
            cMap.put(key, tMap.get(key) + cMap.getOrDefault(key, 0));
        }
    }

    public static void main(String[] args) {
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    }
}
