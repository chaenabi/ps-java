package cote;

import java.util.*;

public class Solution {

    static int answer = 0;

    public int solution(String[] drum) {

        int drumLen = drum.length;
        String[][] arr = new String[drumLen][drumLen];

        for (int i = 0; i < drumLen; i++) {
            arr[i] = drum[i].split("");
        }

        for (int y = 0; y < drumLen; y++) {
            bfs(arr, y, drumLen);
        }

        return answer;
    }

    private void bfs(String[][] arr, int y, int max) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, y)); // x: 가로, y: 세로
        int star = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (0 <= p.x && p.x < max && 0 <= p.y && p.y < max) {
                if (star > 1) break;

                switch (arr[p.x][p.y]) {
                    case ">":
                        queue.offer(new Point(p.x, p.y + 1));
                        break;
                    case "#":
                        queue.offer(new Point(p.x + 1, p.y));
                        break;
                    case "<":
                        queue.offer(new Point(p.x, p.y - 1));
                        break;
                    case "*":
                        queue.offer(new Point(p.x + 1, p.y));
                        star++;
                }
            }
            if (p.x == max) {
                answer++;
                break;
            }
        }
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
