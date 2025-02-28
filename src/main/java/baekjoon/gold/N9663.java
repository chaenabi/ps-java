package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// nQueen
// https://www.acmicpc.net/problem/9663
public class N9663 {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        int[][] chessTable;

        for (int i = 0; i < N; i++) {
            chessTable = new int[N][N];
            chessTable[0][i] = 1;
            backtracking(chessTable, 1, N);
        }
        System.out.println(cnt);
    }

    private static void backtracking(int[][] chessTable, int row, int N) {
        if (row == N) {
            cnt++;
        } else {
            for (int i = 0; i < N; i++) {
                if (canLayDownNextQueen(chessTable, row, i)) {
                    chessTable[row][i] = 1;
                    backtracking(chessTable, row + 1, N);
                    chessTable[row][i] = 0;
                }
            }
        }
    }

    private static boolean canLayDownNextQueen(int[][] chessTable, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chessTable[i][col] == 1) {
                return false;
            }
            if (col - row + i >= 0 && chessTable[i][col - row + i] == 1) {
                return false;
            }
            if (col + row - i < chessTable.length && chessTable[i][col + row - i] == 1) {
                return false;
            }
        }
        return true;
    }
}