package jobs.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bingo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = 5;
        int[][] bingo = new int[n][n];
        int[][] dealer = new int[n][n];
        boolean[][] checked = new boolean[n][n];

        for (int i = 0; i < n; i++) bingo[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) dealer[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        int threebingo = 0;
        int dealerCallCount = 0;

        for (int dy = 0; dy < n; dy++) {
            for (int dx = 0; dx < n; dx++) {
                dealerCallCount++;
                for (int by = 0; by < n; by++) {
                    for (int bx = 0; bx < n; bx++) {
                        if (dealer[dy][dx] == bingo[by][bx] && !checked[by][bx]) {
                            checked[by][bx] = true;
                        }

                        // 세로 비교
                        for (int cy = 0; cy < n; cy++) {
                            int connected = 0;
                            for (int cx = 0; cx < n; cx++) {
                                if (checked[cx][cy]) {
                                    ++connected;
                                    if (connected == 5) {
                                        ++threebingo;
                                    }
                                }
                            }
                        }

                        // 가로 비교
                        for (int cx = 0; cx < n; cx++) {
                            int connected = 0;
                            for (int cy = 0; cy < n; cy++) {
                                if (checked[cx][cy]) {
                                    ++connected;
                                    if (connected == 5) {
                                        ++threebingo;
                                    }
                                }
                            }
                        }

                        // 대각선 비교 (\)
                        int connected = 0;
                        for (int i = 0; i < n; i++) {
                            if (checked[i][i]) ++connected;
                            if (connected == 5) ++threebingo;
                        }

                        // 대각선 비교 (/)
                        connected = 0;
                        for (int i = 0; i < n; i++) {
                            if (checked[i][4 - i]) ++connected;
                            if (connected == 5) ++threebingo;
                        }

                        if (threebingo >= 3) {
                            System.out.println(dealerCallCount);
                            return;
                        }
                        threebingo = 0;
                    }
                }
            }
        }
        System.out.println(dealerCallCount);
        // 가로 비교
        // (0, 0) (0, 1) (0, 2) (0, 3) (0, 4)
        // (1, 0) (1, 1) (1, 2) (1, 3) (1, 4)
        // (2, 0)
        // (3, 0)
        // (4, 0)
        // true인지 비교

        // 세로 비교
        // (0, 0) (0, 1) (0, 2) (0, 3) (0, 4) 일때
        // (1, 0) 
        // (2, 0)
        // (3, 0)
        // (4, 0)
        // true인지 비교

        // 대각선 비교 (\)
        /* (0, 0)
                 (1, 1)
                        (2, 2)
                               (3, 3)
                                      (4, 4)
        */

        // 대각선 비교 (/)
        /*                           (0, 4)
                              (1, 3)
                        (2, 2)
                 (3, 1)
           (4, 0)
        */
    }
}
