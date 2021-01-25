package algorithms.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int n) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> prevList = null;
        for(int i=1;i<=n;i++){
            List<Integer> tempList = new ArrayList<Integer>();
            for(int j=1;j<=i;j++){

                if(j ==1){
                    tempList.add(1);
                }else if(j ==i){
                    tempList.add(1);
                }else{
                    tempList.add(prevList.get(j-1)+prevList.get(j-2));
                }
            }
            output.add(tempList);
            prevList = tempList;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
