package algorithms.array.prep;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;

public class UserVisitPattern {

        class UserInfo{
            String name;
            Integer timestamp;
            String website;

            public UserInfo(String n, Integer t, String w){
                this.name =n;
                this.timestamp=t;
                this.website =w;
            }
        }
        int maxValue = 0;

        public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

            UserInfo[] usersInfo = new UserInfo[username.length];

            for(int i=0;i<username.length;i++){
                usersInfo[i] = new UserInfo(username[i],timestamp[i],website[i]);
            }
            Arrays.sort(usersInfo,(i,j)->i.timestamp.compareTo(j.timestamp));

            Map<String,List<Integer>> count = new HashMap<>();
            Map<String,Integer> wordId = new HashMap<>();
            Map<Integer,String> idWord = new HashMap<>();

            int counter=0;
            for(UserInfo ui:usersInfo){
                String word = ui.website;
                wordId.putIfAbsent(word,counter++);
                int value = wordId.get(word);
                idWord.put(value,word);
                count.putIfAbsent(ui.name,new ArrayList<>());
                count.get(ui.name).add(value);
            }

            Map<List<Integer>,Integer> overallCount = new HashMap<>();
            List<Integer> currentList = new ArrayList<>();

            for(String uId:count.keySet()){
                if(count.get(uId).size()>=3)
                    threeSequence(0,currentList,overallCount,count.get(uId), new HashSet<List<Integer>>());
            }
            StringBuilder output = new StringBuilder();

            for(List<Integer> list:overallCount.keySet()){

                if(overallCount.get(list) ==maxValue){
                    StringBuilder temp = new StringBuilder();

                    for(Integer li:list){
                        temp.append(idWord.get(li));
                        temp.append(" ");
                    }

                    if(output.length()==0){
                        output.append(temp);
                    }else if(output.toString().compareTo(temp.toString())>0){
                        output.setLength(0);
                        output.append(temp);
                    }
                }
            }

            String[] data = output.toString().trim().split(" ");

            return Arrays.asList(data);
        }

        public void threeSequence(int index, List<Integer> currentList, Map<List<Integer>,Integer> overallCount, List<Integer> dict,Set<List<Integer>> tempDict){


            if(currentList.size() ==3){
                List<Integer> list = new ArrayList(currentList);
                if(tempDict.add(list)){
                    overallCount.put(list,1+overallCount.getOrDefault(list,0));
                    maxValue = Math.max(maxValue,overallCount.get(list));
                }
                return;
            }

            for(int i=index;i<dict.size();i++){
                currentList.add(dict.get(i));
                threeSequence(i+1,currentList,overallCount,dict,tempDict);
                currentList.remove(currentList.size()-1);
            }
        }


    public static void main(String[] args) {
       String[] user =  {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"};
       int[] timestamp = {527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930};
        String[] website = {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"};
        UserVisitPattern userVisit = new UserVisitPattern();
        System.out.println(userVisit.mostVisitedPattern(user,timestamp,website));
    }
}

