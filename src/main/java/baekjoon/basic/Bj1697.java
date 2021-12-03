package baekjoon.basic;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bj1697 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        int[] dist = new int[100_001];
        boolean[] visited = new boolean[100_001];

        bw.write(bfs(input[0], input[1], dist, visited, dist.length) + "");
        bw.flush();
        bw.close();
    }

    private static int bfs(int start, int dest, int[] dist, boolean[] visited, int max) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr - 1 >= 0) {
                if (!visited[curr - 1]) {
                    dist[curr - 1] = dist[curr] + 1;
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }
            }

            if ((curr + 1) < max) {
                if (!visited[curr + 1]) {
                    dist[curr + 1] = dist[curr] + 1;
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }
            }

            if ((curr * 2) < max) {
                if (!visited[curr * 2]) {
                    dist[curr * 2] = dist[curr] + 1;
                    visited[curr * 2] = true;
                    queue.offer(curr * 2);
                }
            }
        }

        return dist[dest];
    }

}
