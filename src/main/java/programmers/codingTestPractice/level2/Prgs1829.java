package programmers.codingTestPractice.level2;

import java.util.*;

/**
 * 카카오 프렌즈 컬러링북
 * https://programmers.co.kr/learn/courses/30/lessons/1829
 * 2021-08-24 Tue
 */

public class Prgs1829 {
    boolean[][] visited;
    int[] dx = { 0, 1, 0, -1 };
    int[] dy = { -1, 0, 1, 0 };
    int max_x, max_y, max_size;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        max_x = n;
        max_y = m;
        visited = new boolean[max_y][max_x];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] > 0) {
                    max_size = 1;
                    bfs(i, j, picture);
                    numberOfArea++;
                    if (maxSizeOfOneArea < max_size) {
                        maxSizeOfOneArea = max_size;
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }


    private void bfs(int i, int j, int[][] picture) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now.w + dx[k];
                int ny = now.h + dy[k];

                if (0 <= nx && nx < max_y && 0 <= ny && ny < max_x) {
                    if (!visited[nx][ny] && picture[nx][ny] == picture[i][j]) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                        max_size++;
                    }
                }
            }
        }
    }

}
