package programmers.codingTestPractice.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Prgs49189 {

    static boolean[][] visited;
    static int deepestDepth = 0;

    public int solution(int n, int[][] edge) {

        int[][] savedArray = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int[] ints : edge) {
            savedArray[ints[0]][ints[1]] = savedArray[ints[1]][ints[0]] = 1;
        }

        label: for (int y = 0; y < savedArray.length; y++) {
            for (int x = 0; x < savedArray[y].length; x++) {
                if (!visited[y][x] && savedArray[y][x] == 1) {
                    bfs(savedArray, y, x, n);
                    break label;
                }
            }
        }

        return deepestDepth;
    }

    private void bfs(int[][] savedArray, int y, int x, int max) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(y, x));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            

            deepestDepth = Math.max(queue.size(), deepestDepth);
        }
    }

    static class Point {
        public int y;
        public int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}


/*



    3, 6

 */