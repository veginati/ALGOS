package com.learnings;

import java.util.HashMap;

public class FolderNames {

    public static void main(String[] args) {

        String[] data = {"kingston(0)","kingston(2)","kingston","kingston","kingston"};

        data = getFolderNames(data);

        for(int i=0;i<data.length;i++){
            System.out.println(data[i]);
        }
    }
    public static String[] getFolderNames(String[] names) {
        HashMap<String,Integer> dictionary = new HashMap<String,Integer>();

        for(int i=0;i<names.length;i++){

            String[] data = names[i].split("\\(");

            if(data.length==1){
                if(dictionary.containsKey(data[0])){
                    names[i] = new String(names[i]+"("+dictionary.get(data[0])+")");
                    while(dictionary.containsKey(names[i])){
                        names[i] = new String(names[i]+"("+dictionary.get(data[0])+")");
                    }
                    dictionary.put(data[0], 1+dictionary.get(data[0]));
                    dictionary.put(names[i],1);
                }else{
                    dictionary.put(data[0],1);
                }
            }else{

                if(dictionary.containsKey(data[0])){
                    dictionary.put(data[0], 1+dictionary.get(data[0]));
                }

                if(dictionary.containsKey(names[i])){
                    String temp = names[i];
                    names[i] = new String(names[i]+"("+dictionary.get(names[i])+")");
                    dictionary.put(names[i], 1);
                    dictionary.put(temp, 1+dictionary.get(temp));
                }else{
                    dictionary.put(names[i], 1);
                }
            }
        }

        return names;
    }

}
