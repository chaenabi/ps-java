package jobs.part8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class TreeHeight {

    private static int[] visitedHeight;
    private static Graph graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int node = arr[0];
        int rootNum = arr[1];
        graph = new Graph(node);
        visitedHeight = new int[node];

        Arrays.fill(visitedHeight, -1);

        for (int i = 0; i < node - 1; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = edge[0];
            int b = edge[1];
            graph.put(a, b);
        }

        dfs(rootNum, 0);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < node; i++) {
            if (max < visitedHeight[i]) max = visitedHeight[i];
        }

        System.out.println(max);
        br.close();
    }

    private static void dfs(int v, int height) {
        visitedHeight[v] = height;
        for (int i = 0; i < graph.getNode(v).size(); i++) {
            int w = graph.getNode(v).get(i);
            if (visitedHeight[w] == -1) {
                dfs(w, height + 1);
            }
        }
    }
}

class Graph {
    private final ArrayList<ArrayList<Integer>> graph;

    public Graph(int nodeSize) {
        graph = new ArrayList<>();

        for (int i = 0; i < nodeSize + 1; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void put(int n, int m) {
        graph.get(n).add(m);
        graph.get(m).add(n);
    }

    public ArrayList<Integer> getNode(int n) {
        return graph.get(n);
    }
}