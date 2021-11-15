package programmers.codingTestPractice.level2;

import java.util.*;

/**
 * 거리두기 확인하기
 * https://programmers.co.kr/learn/courses/30/lessons/81302
 */
/*

    대기실 5개, 각 대기실은 5x5 크기
    빈테이블은 0
    응사자가 앉아있는 자리는 P
    파티션은 X

    한명이라도 맨해튼 거리 2이하에 있으면 0
    모두 2이상이면 1을 리턴

    맨해튼 거리가 2이하이지만 파티션이 사이에 있으면 괜찮음.

    맨해튼 거리:
    두 테이블 T1, T2가 행렬 (r1, c1),
                                   (r2, c2)에 각각 위치하고 있다면,
    T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 로 계산된다.

    (0, 0), ------
    ------  (1, 1)
    일때 |0 - 1| + |0 - 1| = 2 ----> 맨해튼거리이하이므로 거리두기를 지키지 않음

    (0, 0)
    ------
    (2, 0)
    일때 |0 - 2| + |0 - 0| = 2  ----> 맨해튼거리이하이므로 거리두기를 지키지 않음

    (0, 0) -----  -----
    -----  -----  (1, 2)
    -----  -----  (2, 2)
    일때 |0 - 2| + |0 - 2| = 4 -----> 맨해튼 거리이상이므로 거리두기를 지킴

    접근:
    1. 현재 좌표에 P가 있고 이 좌표를 기준으로 상하좌우 검사하여 상하좌우에 P가 있다면 바로 0 반환
    2. 아래 네가지 조건에 대해 검사
       (상하좌우 검사도중 X를 만나면 아래 네가지 조건을 모두 만족하는지 검사, 하나라도 만족하지 않으면 바로 0 반환)
       1. PX    2. PXP  3.  P    4.  XP
          XP                X        PX
                            P
 */

public class Pgrs81302 {

    boolean[][] visited = new boolean[5][5];
    int[] dh = { -1, 0, 1, 0};
    int[] dw = { 0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int roomNum = 0;

        while (roomNum < 5) {
            answer[roomNum] = bfs(places[roomNum]);
            roomNum++;
        }
        return answer;
    }

    private int bfs(String[] places) {
        String[][] room = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                room[i][j] = String.valueOf(places[i].charAt(j));
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(!isLawful(room, i, j)) return 0;
            }
        }
        return 1;
    }
    private boolean isLawful(String[][] room, int r, int c) {
        Point p = new Point(r, c);

        for (int i = 0; i < 4; i++) {
            int hh = dh[i] + p.h;
            int ww = dw[i] + p.w;

            //1. 상하좌우, 대각선 0X 검사하여 하나라도 적법하지 않으면 false 리턴
            if (0 <= hh && hh < 5 && 0 <= ww && ww < 5 && !visited[hh][ww]) {
                visited[hh][ww] = true;
                // PP  P
                //     P
                if (room[hh][ww].equals("P")) {
                    return false;
                }

                if (room[hh][ww].equals("X")) {
                    int ph = p.h + 1;
                    int pw = p.w + 1;

                    // PX
                    // 0P
                    if (ph < 5) {
                        if (room[ph][p.w].equals("O")) {
                            if (room[ph][pw].equals("P")) return false;
                        }
                    }

                    // P0
                    // XP
                    if (pw < 5) {
                        if (room[p.h][pw].equals("O")) {
                            if (room[ph][pw].equals("P")) return false;
                        }
                    }
                    // 0P
                    // PX
                    if (ww - 1 >= 0) {
                        if (room[hh][ww - 1].equals("P")) {
                            if (room[hh - 1][ww - 1].equals("O")) return false;
                        }
                    }
                    // XP
                    // P0
                    if (hh + 1 < 5) {
                        if (room[hh + 1][ww].equals("P")) {
                            if (room[ph][p.w].equals("O")) return false;
                        }
                    }
                }

                if (room[hh][ww].equals("O")) {
                    int ph = p.h + 2;
                    int pw = p.w + 2;

                    if (pw < 5) {
                        // P0P
                        if (room[p.h][pw].equals("P")) return false;
                    }
                    if (ph < 5) {
                        // P
                        // 0
                        // P
                        if (room[ph][p.w].equals("P")) return false;
                    }
                }
            }
        }
        return true;
    }

}
