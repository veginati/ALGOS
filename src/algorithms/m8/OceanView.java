package algorithms.m8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OceanView {

    public int[] findBuildings(int[] heights) {
        List<Integer> indexes = new ArrayList<>();
        int maxValue = -1;

        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxValue) {
                maxValue = heights[i];
                indexes.add(i);
            }
        }
        Collections.reverse(indexes);
        return indexes.stream().mapToInt(i -> i).toArray();
    }
}