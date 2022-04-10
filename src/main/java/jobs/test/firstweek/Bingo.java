package jobs.test.firstweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bingo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = 5;
        int[][] board = new int[n][n];
        int[][] call = new int[n][n];
        int bingo = 0, callCount = 0;

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < n; i++) {
            call[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int cy = 0; cy < n; cy++) {
            for (int cx = 0; cx < n; cx++) {
                ++callCount;
                // compare board with caller
                for (int by = 0; by < n; by++) {
                    for (int bx = 0; bx < n; bx++) {
                        if (call[cy][cx] != board[by][bx]) continue;
                        if (call[cy][cx] == board[by][bx]) {
                            board[by][bx] = -1;
                        }

                        // 가로 비교
                        for (int i = 0; i < n; i++) {
                            int cnt = 0;
                            for (int j = 0; j < n; j++) {
                                if (board[i][j] == -1) {
                                    ++cnt;
                                }
                                if (cnt == 5) ++bingo;
                            }
                        }

                        // 세로 비교
                        for (int i = 0; i < n; i++) {
                            int cnt = 0;
                            for (int j = 0; j < n; j++) {
                                if (board[j][i] == -1) {
                                    ++cnt;
                                }
                                if (cnt == 5) ++bingo;
                            }
                        }

                        // 대각선 비교 (\)
                        int cnt = 0;
                        for (int i = 0; i < n; i++) {
                            if (board[i][i] == -1) ++cnt;
                            if (cnt == 5) ++bingo;
                        }

                        // 대각선 비교 (/)
                        cnt = 0;
                        for (int i = 0; i < n; i++) {
                            if (board[i][4 - i] == -1) ++cnt;
                            if (cnt == 5) ++bingo;
                        }

                        if (bingo >= 3) {
                            System.out.println(callCount);
                            return;
                        }
                        bingo = 0;
                    }
                }
            }
        }

    }

}
