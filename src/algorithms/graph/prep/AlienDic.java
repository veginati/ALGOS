package algorithms.graph.prep;

import java.util.*;

public class AlienDic {

    /*
     * Complete the function below.
     */
    static String find_order(String[] words) {
        //build a graph
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (int i = 1; i < words.length; i++) {
            int j = 0, k = 0;

            while (j < words[i - 1].length() && k < words[i].length()) {

                if (words[i - 1].charAt(j) != words[i].charAt(k)) {
                    graph.putIfAbsent(words[i - 1].charAt(j), new ArrayList<>());
                    graph.get(words[i - 1].charAt(j)).add(words[i].charAt(k));
                    indegree.putIfAbsent(words[i - 1].charAt(j), 0);
                    indegree.putIfAbsent(words[i].charAt(k), 0);
                    indegree.put(words[i].charAt(k), 1 + indegree.get(words[i].charAt(k)));
                    break;
                }
                indegree.putIfAbsent(words[i - 1].charAt(j), 0);
                j++;
                k++;
            }

            while (j < words[i - 1].length()) {
                indegree.putIfAbsent(words[i - 1].charAt(j), 0);
                j++;
            }

            while (k < words[i].length()) {
                indegree.putIfAbsent(words[i].charAt(k), 0);
                k++;
            }
        }

        // find a node with degree 0;
        Queue<Character> nodes = new LinkedList<>();
        Iterator<Character> itr = indegree.keySet().iterator();

        while (itr.hasNext()) {
            Character charData = itr.next();
            if (indegree.get(charData) == 0) {
                nodes.offer(charData);
            }
        }

        StringBuilder output = new StringBuilder();

        while (nodes.size() > 0) {

            Character charData = nodes.poll();
            output.append(charData);

            List<Character> outEdges = graph.get(charData);

            if (null != outEdges && outEdges.size() > 0) {

                Iterator<Character> itr1 = outEdges.iterator();

                while (itr1.hasNext()) {
                    Character nextEdge = itr1.next();

                    if (indegree.get(nextEdge) == 1) {
                        nodes.offer(nextEdge);
                        indegree.remove(nextEdge);
                    } else if (indegree.get(nextEdge) > 0) {
                        int value = indegree.get(nextEdge);
                        indegree.put(nextEdge, value - 1);
                    }
                }
            }
        }

        return output.toString();

    }

    public static void main(String[] args) {

        System.out.println(find_order(new String[]{"baa","abcd","abca","cab","cad"}));
    }

}
