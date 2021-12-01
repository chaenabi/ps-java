package baekjoon.basic;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 섬의 개수
 * https://www.acmicpc.net/problem/1406
 */
public class Bj4963 {

    // 12시 방향에서 시작해 11시방향까지
    static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        while (input[0] != 0 && input[1] != 0) {

            int[][] map = new int[input[1]][input[0]];
            visited = new boolean[input[1]][input[0]];

            for (int i = 0; i < input[1]; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int result = 0;
            for (int i = 0; i < input[1]; i++) {
                for (int j = 0; j < input[0]; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(map, i, j, input[0], input[1]);
                        result++;
                    }
                }
            }
            bw.write(result + "\n");
            for (boolean[] visit : visited) {
                Arrays.fill(visit, false);
            }
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs(int[][] map, int y, int x, int max_x, int max_y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 8; i++) {
                int xx = dx[i] + p.x;
                int yy = dy[i] + p.y;

                if (0 <= xx && xx < max_x && 0 <= yy && yy < max_y) {
                    if (map[yy][xx] == 1 && !visited[yy][xx]) {
                        visited[yy][xx] = true;
                        queue.offer(new Point(xx, yy));
                    }
                }
            }
        }
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
