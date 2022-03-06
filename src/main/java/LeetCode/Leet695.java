package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Leet695 {

    public static void main(String[] args) {
        System.out.println(new Leet695().maxAreaOfIsland(
                new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                            {0,0,0,0,0,0,0,1,1,1,0,0,0},
                            {0,1,1,0,1,0,0,0,0,0,0,0,0},
                            {0,1,0,0,1,1,0,0,1,0,1,0,0},
                            {0,1,0,0,1,1,0,0,1,1,1,0,0},
                            {0,0,0,0,0,0,0,0,0,0,1,0,0},
                            {0,0,0,0,0,0,0,1,1,1,0,0,0},
                            {0,0,0,0,0,0,0,1,1,0,0,0,0}}
                )
        );
        System.out.println(new Leet695().maxAreaOfIsland(
                        new int[][]{{1}}
                )
        );
    }

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {

        int max_x = grid[0].length;
        int max_y = grid.length;
        visited = new boolean[max_y][max_x];
        int max = 0;
        int max_area = 0;

        for (int y = 0; y < max_y; y++) {
            for (int x = 0; x < max_x; x++) {
                if (!visited[y][x] && grid[y][x] == 1) {
                    max = bfs(x, y, max_x, max_y, grid);
                    if (max_area < max) {
                        max_area = max;
                    }
                }
            }
        }

        return max_area;
    }

    private int bfs(int x, int y, int max_x, int max_y, int[][] grid) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        int result = 0;
        if (grid[y][x] == 1) {
            result++;
            visited[y][x] = true;
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = dx[i] + p.x;
                int yy = dy[i] + p.y;

                if (xx >= 0 && xx < max_x && yy >= 0 && yy < max_y) {
                    if (!visited[yy][xx] && grid[yy][xx] == 1) {
                        visited[yy][xx] = true;
                        result++;
                        queue.offer(new Point(xx, yy));
                    }
                }
            }
        }
        return result;
    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}



