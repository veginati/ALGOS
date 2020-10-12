package algorithms.dp.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://cses.fi/problemset/task/1674/
 */
public class SubOrdinates {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] output = new int[n+1];

        List[] neighbours = new ArrayList[n+1];

        for(int i=2;i<=n;i++){
            int parent = scanner.nextInt();
            //  neighbours.get(i).add(parent);
            if(null!= neighbours[parent])
                neighbours[parent].add(i);
            else{
                int value =i;
                neighbours[parent] = new ArrayList<Integer>(){{add(value);}};
            }
        }
        getSubOrdinates(1,output,neighbours);
        for(int i=1;i<output.length;i++){
            System.out.print(output[i]);
            System.out.print(" ");
        }
    }


    public static void getSubOrdinates( int index, int[] output, List[] neighbours ){
        List<Integer> subOrdinates = neighbours[index];
        int total =0;
        if(null==subOrdinates){
            output[index] =total;
            return;
        }
        for(int i=0;i<subOrdinates.size();i++){
            getSubOrdinates(subOrdinates.get(i), output, neighbours);
            total+= 1+ output[subOrdinates.get(i)];
        }
        output[index] =total;
    }
}
