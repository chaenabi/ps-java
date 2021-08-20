package LeetCode;

import java.util.*;

/**
 * All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 * 2021-08-04
 */
public class Leet797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.add(List.of(0));

        int dest = graph.length - 1;

        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            int lastNode = path.get(path.size() - 1);

            if (lastNode == dest) {
                result.add(new ArrayList<>(path));
            } else {
                int[] navers = graph[lastNode];
                for (int naver : navers) {
                    List<Integer> list = new ArrayList<>(path);
                    list.add(naver);
                    queue.offer(list);
                }
            }
        }
        return result;
    }

}
