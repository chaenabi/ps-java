package baekjoon.basic;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Bj2636 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = init[0];
        int M = init[1];

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        br.close();

        int removeCount = 0;
        int count = 0;

        while (true) {
            int result = bfs(arr, N, M);
            if (result == 0) {
                break;
            }
            removeCount++;
            count = result;
        }

        bw.write(removeCount + "\n");
        bw.write(count + "");

        bw.flush();
        bw.close();
    }

    private static int bfs(int[][] arr, int max_x, int max_y) {
        boolean[][] visited = new boolean[max_x][max_y];
        Queue<Point> queue = new LinkedList<>();
        int cycle = 0;

        queue.offer(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int x = dx[d] + p.x;
                int y = dy[d] + p.y;

                if (0 <= x && x < max_x && 0 <= y && y < max_y) {
                    if (arr[x][y] != 1 && !visited[x][y]) {
                       visited[x][y] = true;
                       queue.offer(new Point(x, y));
                    } else if (arr[x][y] == 1) {
                       arr[x][y] = 0;
                       visited[x][y] = true;
                       cycle++;
                    }
                }
            }
        }
        return cycle;
    }
}

/*

13 12
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 1 0 0 0
0 1 1 1 0 0 0 1 1 0 0 0
0 1 1 1 1 1 1 0 0 0 0 0
0 1 1 1 1 1 0 1 1 0 0 0
0 1 1 1 1 0 0 1 1 0 0 0
0 0 1 1 0 0 0 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0


 */