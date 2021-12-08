package baekjoon.basic;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 빙산
 * https://www.acmicpc.net/problem/2573
 */
public class Bj2573 {
    static int[] dx = { 0, 0, -1, 1 }; // 상 하 좌 우
    static int[] dy = { -1, 1, 0, 0 };
    static boolean[][] visited;
    static int year = 0;
<<<<<<< HEAD
=======
    static boolean seperated = false;
>>>>>>> 634f92b032251488ab15cf1cb3d1ee4de91bc5d1

    public static void main(String[] args) throws IOException {
        solutionBackup();
    }

    public static void solutionBackup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] cord = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = cord[0], M = cord[1];
        int[][] map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        boolean leftIceburg = true;
        int secondRun = 0;

        while (leftIceburg) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (!visited[y][x] && map[y][x] > 0) {
                        bfs(map, y, x, N, M);
                        ++secondRun;
                    }
                }
            }
            if (secondRun > 1) { // 분리된채로 돌아갔다면
                bw.write(year + "");
                bw.flush();
                bw.close();
                return;
            }

<<<<<<< HEAD

=======
>>>>>>> 634f92b032251488ab15cf1cb3d1ee4de91bc5d1
            for (int y = 0; y < N; y++) { // 중간 출력
                for (int x = 0; x < M; x++) {
                    System.out.print(map[y][x] + " ");
                }
                System.out.println();
            }

            System.out.println("=================");

<<<<<<< HEAD

=======
>>>>>>> 634f92b032251488ab15cf1cb3d1ee4de91bc5d1
            long count = Arrays.stream(map)
                    .flatMapToInt(e -> Arrays.stream(e)
                            .filter(i -> i > 0)).count();

            if (count == 0 && year == 0) { // 처음부터 빙하가 없었다면
                bw.write(year + "");
                bw.flush();
                bw.close();
                return;
            }

            if (count > 0 && secondRun == 1) {
                ++year;
                for (int i = 0; i < N; i++) {
                    Arrays.fill(visited[i], false);
                }
            }
            else leftIceburg = false;
            secondRun = 0;
        }
        bw.write(0 + "");
        bw.flush();
        bw.close();
    }

    public int solution(int N, int M, int[][] map) {
        visited = new boolean[N][M];

        boolean leftIceburg = true;
        int secondRun = 0;

        while (leftIceburg) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (!visited[y][x] && map[y][x] > 0) {
                        bfs(map, y, x, N, M);
                        ++secondRun;
                    }
                }
            }
            if (secondRun > 1) {
                return year;
            }

            /*
            for (int y = 0; y < N; y++) { // 중간 출력
                for (int x = 0; x < M; x++) {
                    System.out.print(map[y][x] + " ");
                }
                System.out.println();
            }
            System.out.println("=======================");
             */

            long count = Arrays.stream(map)
                    .flatMapToInt(e -> Arrays.stream(e)
                            .filter(i -> i > 0)).count();

            if (count == 0 && year == 0) { // 처음부터 빙하가 없었다면
                return year;
            }

            if (count > 0 && secondRun == 1) {
                ++year;
                for (int i = 0; i < N; i++) {
                    Arrays.fill(visited[i], false);
                }
            }
            else leftIceburg = false;
            secondRun = 0;
        }
        return 0;
    }

    private static void bfs(int[][] map, int y, int x, int max_y, int max_x) {
<<<<<<< HEAD
=======
        if (seperated) return;

>>>>>>> 634f92b032251488ab15cf1cb3d1ee4de91bc5d1
        Queue<Pair> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.offer(new Pair(y, x));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = dx[i] + p.x;
                int yy = dy[i] + p.y;

                if (0 <= xx && xx < max_x && 0 <= yy && yy < max_y) {
                    if (!visited[yy][xx] && map[yy][xx] == 0) {
                        if (map[p.y][p.x] > 0) map[p.y][p.x] = map[p.y][p.x] - 1;
                    }
                    else if (!visited[yy][xx] && map[yy][xx] > 0) {
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

/*

7 9
0 0 0 0 0 0 0 0 0
<<<<<<< HEAD
0 1 1 1 1 1 1 1 0
0 0 1 0 1 0 1 0 0
0 0 1 2 1 2 1 0 0
0 1 1 1 1 1 1 1 0
0 0 1 0 1 0 1 0 0
0 0 0 0 0 0 0 0 0


=======
0 1 0 1 0 1 0 1 0
0 0 1 0 1 0 1 0 0
0 0 1 2 1 2 1 0 0
0 1 0 1 0 1 0 1 0
0 0 1 0 1 0 1 0 0
0 0 0 0 0 0 0 0 0
>>>>>>> 634f92b032251488ab15cf1cb3d1ee4de91bc5d1
 */