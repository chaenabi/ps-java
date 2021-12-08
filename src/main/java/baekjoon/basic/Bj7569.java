package baekjoon.basic;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 토마토
 * https://www.acmicpc.net/problem/7569
 */
public class Bj7569 {

    static boolean[][][] visited;
    static int[] dz = { -1, 1, 0, 0, 0, 0 }; // 위 아래 상 하 좌 우
    static int[] dy = { 0, 0, -1, 1, 0, 0 };
    static int[] dx = { 0, 0, 0, 0, -1, 1 };
    static Queue<ThreeDimension> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] firstLine = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int M = firstLine[0]; // x
        int N = firstLine[1]; // y
        int Z = firstLine[2]; // height

        int[][][] boxes = new int[Z][N][M];
        visited = new boolean[Z][N][M];

        for (int i = 0; i < Z; i++) {
            for (int j = 0; j < N; j++) {
                boxes[i][j] = Arrays.stream(br.readLine().split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
            }
        }
        br.close();

        long count = Arrays.stream(boxes).flatMapToInt(e -> Arrays.stream(e)
                .flatMapToInt(e1 -> Arrays.stream(e1)
                        .filter(n -> n == 0))).count();

        if (count == 0) {
            bw.write(0 + ""); bw.flush(); bw.close(); return;
        }

        for (int z = 0; z < Z; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (boxes[z][y][x] == 1) queue.offer(new ThreeDimension(z, y, x));
                }
            }
        }

        bfs(boxes, Z, N, M);
        int days = 0;

        for (int z = 0; z < Z; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (boxes[z][y][x] == 0) {
                        bw.write(-1 + ""); bw.flush(); bw.close(); return;
                    }
                    days = Math.max(days, boxes[z][y][x]);
                }
            }
        }
        bw.write(days - 1 + ""); bw.flush(); bw.close();
    }

    private static void bfs(int[][][] boxes, int max_z, int max_y, int max_x) {
        while (!queue.isEmpty()) {
            ThreeDimension td = queue.poll();

            for (int i = 0; i < 6; i++) {
                int xx = dx[i] + td.x;
                int yy = dy[i] + td.y;
                int zz = dz[i] + td.z;

                if (0 <= xx && xx < max_x && 0 <= yy && yy < max_y && 0 <= zz && zz < max_z) {
                    if (!visited[zz][yy][xx] && boxes[zz][yy][xx] == 0) {
                        boxes[zz][yy][xx] = boxes[td.z][td.y][td.x] + 1;
                        visited[td.z][td.y][td.x] = true;
                        queue.offer(new ThreeDimension(zz, yy, xx));
                    }
                }
            }
        }
    }

    static class ThreeDimension {
        public int z;
        public int y;
        public int x;

        public ThreeDimension(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}

/*

5 3 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0

: 4

3 3 1
0 0 0
0 0 1
1 0 0

: 2

4 5 2
0 1 0 0
0 1 -1 1
-1 -1 1 -1
0 0 0 0
-1 -1 0 -1
-1 1 0 -1
0 0 -1 1
-1 0 1 0
0 0 0 -1
0 0 1 -1

: 3

5 5 2
1 -1 1 -1 1
0 0 -1 -1 1
0 -1 -1 1 0
0 -1 0 0 1
0 0 1 -1 1
1 -1 -1 -1 -1
0 -1 0 1 1
0 1 0 0 -1
-1 -1 -1 -1 -1
-1 0 0 1 -1

: 3

 */
