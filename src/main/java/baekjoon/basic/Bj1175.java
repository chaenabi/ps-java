package baekjoon.basic;

import java.io.*;
import java.util.*;

/**
 * 배달
 * https://www.acmicpc.net/problem/1175
 */
public class Bj1175 {

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static boolean[][] visited;
    static int min = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] firstline = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = firstline[0]; // y, 세로
        int M = firstline[1]; // x, 가로

        char[][] classRoom = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            classRoom[i] = br.readLine().toCharArray();
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (classRoom[y][x] == 'S') {
                    bfs(classRoom, y, x, N, M);
                }
            }
        }

        boolean didMinsikDeliverSuccessfully = true;

        label: for (boolean[] vertex : visited) {
            for (boolean v : vertex) {
                if (!v) {
                    didMinsikDeliverSuccessfully = false;
                    break label;
                }
            }
        }

        if (!didMinsikDeliverSuccessfully) bw.write(-1 + "");
        else bw.write(min + "");
        bw.flush();
        bw.close();

    }

    private static void bfs(char[][] classRoom, int y, int x, int max_y, int max_x) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(y, x, 123923, 213902139));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = dx[i] + p.x;
                int yy = dy[i] + p.y;

                if (0 <= xx && xx < max_x && 0 <= yy && yy < max_y) {

                    if (yy - p.preY == (dy[i] - p.y) && xx - p.preX == (dx[i] - p.x)) {
                        continue;
                    } // TODO: 문제가 되는 것 같아보이는 지점 (이전 좌표로는 돌아가지 못하게 만들어야 함)

                    if (!visited[yy][xx] && classRoom[yy][xx] == 'C') {
                        visited[yy][xx] = true;
                    } else if (!visited[yy][xx] && classRoom[yy][xx] == '#') {
                        visited[yy][xx] = true;
                    } else if (!visited[yy][xx] && classRoom[yy][xx] == '.') {
                        visited[yy][xx] = true;
                        queue.offer(new Point(yy, xx, p.y, p.x));
                    }
                }
            }
            min++;
        }
    }

    static class Point {
        public int y;
        public int x;
        public int preY;
        public int preX;

        public Point(int y, int x, int preY, int preX) {
            this.y = y;
            this.x = x;
            this.preY = preY;
            this.preX = preX;
        }
    }
}