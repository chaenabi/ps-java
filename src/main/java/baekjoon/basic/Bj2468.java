package baekjoon.basic;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 안전 영역 (해결)
 * https://www.acmicpc.net/problem/2468
 */
public class Bj2468 {

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i <= N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int maxHeight = Arrays.stream(map).flatMapToInt(Arrays::stream).max().orElse(0);
        int count = 0;

        for (int i = 0; i < maxHeight; i++) {
            int cases = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (!visited[y][x] && map[y][x] <= i) {
                        sinked(map, y, x, N, i);
                    }
                }
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (!visited[y][x]) {
                        unsinked(map, y, x, N);
                        cases++;
                        count = Math.max(count, cases);
                    }
                }
            }

            visited = new boolean[N][N];
        }

        System.out.println(count);

    }

    private static void sinked(int[][] map, int y, int x, int n, int maxHeight) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(y, x));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int yy = dy[i] + p.y;
                int xx = dx[i] + p.x;

                if (0 <= yy && yy < n && 0 <= xx && xx < n) {
                    if (!visited[yy][xx] && map[yy][xx] <= maxHeight) {
                        visited[yy][xx] = true;
                        queue.offer(new Pair(yy, xx));
                    }
                }
            }
        }
    }


    private static void unsinked(int[][] map, int y, int x, int n) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(y, x));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int yy = dy[i] + p.y;
                int xx = dx[i] + p.x;

                if (0 <= yy && yy < n && 0 <= xx && xx < n) {
                    if (!visited[yy][xx]) {
                        visited[yy][xx] = true;
                        queue.offer(new Pair(yy, xx));
                    }
                }
            }
        }
    }

    static class Pair {
        public int y;
        public int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
