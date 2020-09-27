package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThroneInheritance {

    class King{
        String name;
        boolean alive;
        public King(String name, boolean alive){
            this.name = name;
            this.alive= alive;
        }
    }

    Map<String,List<King>> mapObj = new HashMap<>();

    Map<String,King> kingObj = new HashMap<String,King>();

    String kingName = null;
    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        King kingO = new King(kingName,true);
        mapObj.put(kingName,new ArrayList<King>());
        kingObj.put(kingName,kingO);
    }

    public void birth(String parentName, String childName) {

        if(mapObj.containsKey(parentName)){
            King king = new King(childName,true);
            mapObj.get(parentName).add(king);
            kingObj.put(childName,king);
        }else{
            List<King> listObj = new ArrayList<King>();
            King king = new King(childName,true);
            listObj.add(king);
            mapObj.put(parentName,listObj);
            kingObj.put(childName,king);
        }
    }

    public void death(String name) {
        kingObj.get(name).alive=false;
    }

    public List<String> getInheritanceOrder() {
        List<String> output = new ArrayList<>();

       King king = kingObj.get(kingName);
       if(king.alive)
           output.add(kingName);
        dfs(kingName,output);
        return output;
    }

    public void dfs(String name,List<String> output){

        List<King> temObj = mapObj.get(name);

        if(null!=temObj){
            for(int i=0;i<temObj.size();i++){
                King obj = temObj.get(i);
                if(obj.alive){
                    output.add(obj.name);
                }
                dfs(obj.name,output);
            }

        }
    }

    public static void main(String[] args) {

        ThroneInheritance throne = new ThroneInheritance("king");
        throne.birth("king","andy");
        throne.birth("king","bob");
        throne.birth("king","catherine");

        throne.birth("andy","matthew");
        throne.birth("bob","alex");
        throne.birth("bob","asha");

        System.out.println(throne.getInheritanceOrder());
        throne.death("bob");
        System.out.println(throne.getInheritanceOrder());
    }

}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */