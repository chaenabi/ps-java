package baekjoon.basic;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 */
public class Bj1260 {

    static Queue<Integer> queue = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] graph = new int[inputs[0] + 1][inputs[0] + 1];
        boolean[] visited = new boolean[inputs[0] + 1];

        while (inputs[1]-- > 0) {
            int[] vertex = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[vertex[0]][vertex[1]] = vertex[0];
            graph[vertex[1]][vertex[0]] = vertex[1];
        }

        for (int[] grap : graph) {
            for (int gra : grap) {
                System.out.print(gra + " ");
            }
            System.out.println();
        }

        br.close();
        _dfs(inputs[2], visited, inputs[0], graph);
        bw.write("\n");
        Arrays.fill(visited, false);
        _bfs(inputs[2], visited, inputs[0], graph);
        bw.flush();
        bw.close();

    }
    static void _dfs(int i, boolean[] visited, int n, int[][] arr) throws IOException {
        visited[i] = true;
        bw.write(i + " ");

        for (int j = 1; j < n + 1; j++) {
            if (arr[i][j] >= 1 && !visited[j]) {
                _dfs(j, visited, n, arr);
            }
        }
    }
    static void _bfs(int i, boolean[] visit, int n, int[][] arr) throws IOException {
        queue.offer(i);
        visit[i] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            bw.write(temp + " ");

            for (int k = 1; k <= n; k++) {
                if (arr[temp][k] >= 1 && !visit[k]) {
                    queue.offer(k);
                    visit[k] = true;
                }
            }
        }
    }
}
