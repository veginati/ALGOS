package algorithms.graph;

import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 *
 */
public class ReConstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {

        HashMap<String,List<Pair<String,Integer>>> travelDes = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<tickets.size();i++){
            List<String> flightPath = tickets.get(i);
            if(travelDes.containsKey(flightPath.get(0))){
                int tempI =i;
                travelDes.get(flightPath.get(0)).add(new Pair<String,Integer>(flightPath.get(1),tempI));
            }else{
                int tempI =i;
                travelDes.put(flightPath.get(0), new ArrayList(){{add(new Pair<String,Integer>(flightPath.get(1),tempI));}});
            }
        }

        Set<String> setIterator = travelDes.keySet();

        for (String s : setIterator) {
            List<Pair<String, Integer>> values = travelDes.get(s);
            values.sort(Comparator.comparing(Pair::getKey));
        }

        List<String> output = new ArrayList<>();
        int count = tickets.size();

        findJourney("JFK",output,visited,count,travelDes);

        return output;
    }

    public boolean findJourney(String from, List<String> output, Set<Integer> visited, int count, HashMap<String,List<Pair<String,Integer>>> travelDes){

        if(visited.size() == count) {
            output.add(from);
            return true;
        }

        boolean temp = false;

        List<Pair<String,Integer>> destinations = travelDes.get(from);


        for(int i=0;null!=destinations && i<destinations.size()&&!temp ;i++){
            String to = destinations.get(i).getKey();
            Integer value = destinations.get(i).getValue();
            if(visited.add(value)){
                visited.add(value);
                output.add(from);
                temp = findJourney(to,output,visited,count,travelDes);
                if(temp){
                    return temp;
                }
                output.remove(output.size()-1);
                visited.remove(value);
            }

        }

        return temp;
    }
}