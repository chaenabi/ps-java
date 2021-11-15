package LeetCode;

import java.util.*;

/**
 * Battleships in a Board
 * https://leetcode.com/problems/battleships-in-a-board/
 */
public class Leet419 {

    boolean[][] visited;
    int[] dw = { 0, 0, -1, 1 };
    int[] dh = { -1, 1, 0, 0 };

    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        int cnt = 0;

        for (int h = 0; h < m; h++) {
            for (int w = 0; w < n; w++) {
                if (board[h][w] == 'X' && !visited[h][w]) {
                    bfs(board, h, w, m, n);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void bfs(char[][] board, int h, int w, int m, int n) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(h, w));
        visited[h][w] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int hh = dh[i] + p.h;
                int ww = dw[i] + p.w;

                if (0 <= ww && ww < n && 0 <= hh && hh < m) {
                    if (!visited[hh][ww] && board[hh][ww] == 'X') {
                        visited[hh][ww] = true;
                        queue.offer(new Point(hh, ww));
                    }
                }
            }
        }
    }
}
