package jobs.part13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CarpenterMazeEscape {

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] smap = new int[firstLine[0]][];
        boolean[][] visited = new boolean[firstLine[0]][firstLine[1]];
        boolean[][] checked = new boolean[firstLine[0]][firstLine[1]];

        for (int i = 0; i < firstLine[0]; i++) {
            smap[i] = Arrays.stream(br.readLine().split(" "))
                    .map(e -> {
                        if (e.equals("1")) {
                            return "-1";
                        }
                        return e;
                    })
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int[][] dmap = new int[firstLine[0]][firstLine[1]];
        for (int i = 0; i < smap.length; i++) {
            dmap[i] = Arrays.copyOf(smap[i], smap[i].length);
        }

        sbfs(smap, visited, firstLine[0] - 1, 0, firstLine[0], firstLine[1]);
        visited = new boolean[firstLine[0]][firstLine[1]];
        dmap[0][firstLine[1] - 1] = 1;
        dbfs(smap, dmap, visited, checked, 0, firstLine[1] - 1, firstLine[0], firstLine[1]);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < dmap.length; i++) {
            for (int j = 0; j < dmap[i].length; j++) {

                if (checked[i][j] && dmap[i][j] != 0) {
                    if (min > dmap[i][j]) {
                        min = dmap[i][j];
                    }
                }
            }
        }
        System.out.println(min);

    }

    private static void sbfs(int[][] smap, boolean[][] visited, int y, int x, int max_y, int max_x) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int px = p.x + dx[i];
                int py = p.y + dy[i];

                if (0 <= py && py < max_y && 0 <= px && px < max_x) {
                    if (!visited[py][px] && smap[py][px] >= 0) {
                        visited[py][px] = true;
                        smap[py][px] = smap[p.y][p.x] + 1;
                        q.offer(new Pair(py, px));
                    }
                }
            }
        }
    }

    private static void dbfs(int[][] smap, int[][] dmap, boolean[][] visited, boolean[][] checked, int y, int x, int max_y, int max_x) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int px = p.x + dx[i];
                int py = p.y + dy[i];

                if (0 <= px && px < max_x && 0 <= py && py < max_y) {
                    if (!visited[py][px] && dmap[py][px] == 0) {
                        dmap[py][px] = dmap[p.y][p.x] + 1;
                        q.offer(new Pair(py, px));
                        visited[py][px] = true;
                    }

                    if (!visited[py][px] && dmap[py][px] == -1) {
                        dmap[py][px] = dmap[p.y][p.x] + 1;
                        visited[py][px] = true;
                        for (int j = 0; j < 4; j++) {
                            int wx = px + dx[j];
                            int wy = py + dy[j];
                            if (0 <= wx && wx < max_x && 0 <= wy && wy < max_y) {
                                if (!visited[wy][wx] && smap[wy][wx] != 0 && dmap[wy][wx] == 0) {
                                    dmap[py][px] += smap[wy][wx];
                                    checked[py][px] = true;
                                }
                            }
                        }
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
