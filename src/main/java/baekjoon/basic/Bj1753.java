package baekjoon.basic;

import java.io.*;
import java.util.*;

/**
 * 최단경로 (미해결)
 * https://www.acmicpc.net/problem/1753
 */
public class Bj1753 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] ve = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = ve[0]; // 정점
        int e = ve[1]; // 간선
        int start = Integer.parseInt(br.readLine());

        int[] dist = new int[v + 1];
        boolean[] visited = new boolean[v + 1];
        Set<Edge> set = new HashSet<>();

        while (e-- > 0) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Edge eg = set.stream()
                            .filter(edge -> edge.from == arr[0])
                            .filter(edge -> edge.to == arr[1])
                            .findFirst()
                            .orElse(null);

            if (eg != null) {
                if (eg.distance > arr[2]) {
                    eg.distance = arr[2];
                    set.add(eg);
                }
            } else {
                set.add(new Edge(arr[0], arr[1], arr[2]));
            }
        }

        dist = bfs(set, start, v, visited, dist);

        Arrays.stream(dist).forEach(System.out::println);
    }

    private static int[] bfs(Set<Edge> set, int start, int v, boolean[] visited, int[] dist) {
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(set.iterator().next());

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int from = edge.from;
            int to = edge.to;
            int distance = edge.distance;

            if (!visited[to]) {
                visited[to] = true;
                if (dist[to] < dist[from] + distance) {
                    dist[to] = dist[from] + distance;
                    queue.add(set.iterator().next());
                }
            }
        }

        return dist;
    }

    static class Edge {
        int from;
        int to;
        int distance;

        public Edge(int from, int to, int distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", distance=" + distance +
                    '}';
        }
    }
}

/*
5 7
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
3 4 3
 */