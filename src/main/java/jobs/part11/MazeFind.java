package jobs.part11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MazeFind {

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int y = arr[0]; // 10
        int x = arr[1]; // 10
        map = new int[y][x];
        visited = new boolean[y][x];

        for (int i = 0; i < y; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).map(e -> e.equals("1") ? "-1" : e).mapToInt(Integer::parseInt).toArray();
        }
        br.close();
        bfs(y,  x);
        System.out.println(map[0][x - 1]);
    }

    private static void bfs(int starty, int destx) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(starty - 1, 0));
        visited[starty - 1][0] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int py = dy[i] + p.y;
                int px = dx[i] + p.x;

                if (0 <= py && py < starty && 0 <= px && px < destx) {
                    if (!visited[py][px] && map[py][px] != -1) {
                        visited[py][px] = true;
                        map[py][px] = map[p.y][p.x] + 1;
                        queue.offer(new Pair(py, px));
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
