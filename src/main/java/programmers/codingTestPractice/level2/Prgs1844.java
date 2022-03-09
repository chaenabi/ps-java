package programmers.codingTestPractice.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Prgs1844 {

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int answer = -1;

    public int solution(int[][] maps) {
        bfs(maps[0].length - 1, maps.length - 1, maps);
        return answer;
    }

    void bfs(int max_x, int max_y, int[][] maps) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ix = dx[i] + p.x;
                int iy = dy[i] + p.y;

                if (0 <= ix && ix <= max_x && 0 <= iy && iy <= max_y) {
                    if (maps[iy][ix] == 1) {
                        maps[iy][ix] = maps[p.y][p.x] + 1;
                        queue.offer(new Pair(iy, ix));
                    }
                }
            }
        }
        if (maps[max_y][max_x] != 1) answer = maps[max_y][max_x];
    }

    private static class Pair {
        public int y;
        public int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Prgs1844 prgs1844 = new Prgs1844();
        System.out.println(prgs1844.solution(new int[][]{{1,0,1,1,1},
                                                         {1,0,1,0,1},
                                                         {1,0,1,1,1},
                                                         {1,1,1,0,1},
                                                         {0,0,0,0,1}}));
    }
}
