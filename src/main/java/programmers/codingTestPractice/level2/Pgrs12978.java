package programmers.codingTestPractice.level2;

import java.util.*;

public class Pgrs12978 {

    static int MAX = Integer.MAX_VALUE;

    public int solution(int N, int[][] road, int K) {

        int[][] adj = new int[N][N];

        for (int[] arr : adj) {
            Arrays.fill(arr, MAX);
        }

        for (int[] arr : road) {
            int x = arr[0] - 1;
            int y = arr[1] - 1;
            int w = arr[2];
            if (w < adj[x][y]) {
                adj[x][y] = adj[y][x] = w;
            }
        }

        int[] dist = new int[N];

        Arrays.fill(dist, MAX);
        return bfs(adj, dist, N, K);
    }

    private static int bfs(int[][] adj, int[] dist, int N, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> dist[o]));
        boolean[] visited = new boolean[N];
        int answer = 0;

        dist[0] = 0;
        queue.add(0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (!visited[curr]) {
                visited[curr] = true;
                for (int i = 0; i < N; i++) {
                    if (adj[curr][i] == MAX) continue;

                    if (dist[i] > dist[curr] + adj[curr][i]) {
                        dist[i] = dist[curr] + adj[curr][i];
                        queue.offer(i);
                    }
                }
            }
        }
        for (int a : dist) {
            if (a <= K) answer++;
        }
        return answer;
    }
}
