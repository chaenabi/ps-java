package programmers.intermediate;

import java.util.HashSet;

/**
 * Valid Sudoku/
 * https://leetcode.com/problems/valid-sudoku/
 */
public class Leet36 {

    public boolean isValidSudoku(char[][] board) {

        HashSet<Character> hashSet = new HashSet<>();

        // 가로
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val != '.') {
                    if (!hashSet.add(val)) {
                        return false;
                    }
                }
            }
            hashSet.clear();
        }

        // 세로
        int j = 0;
        for (int i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                char val = board[j][i];
                if (val != '.') {
                    if (!hashSet.add(board[j][i])) return false;
                }
            }
            hashSet.clear();
        }

        // 박스

        // 0,0 ~ 2,8
        for (int i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                char val = board[i][j];
                if (val != '.') {
                    if (!hashSet.add(board[i][j])) return false;
                }
            }
        }
        hashSet.clear();

        for (int i = 0; i < 3; i++) {
            for (j = 3; j < 6; j++) {
                char val = board[i][j];
                if (val != '.') {
                    if (!hashSet.add(board[i][j])) return false;
                }
            }
        }
        hashSet.clear();

        for (int i = 0; i < 3; i++) {
            for (j = 6; j < 9; j++) {
                char val = board[i][j];
                if (val != '.') {
                    if (!hashSet.add(board[i][j])) return false;
                }
            }
        }
        hashSet.clear();

        // 3,0 ~ 5,8
        for (int i = 3; i < 6; i++) {
            for (j = 0; j < 3; j++) {
                char val = board[i][j];
                if (val != '.') {
                    if (!hashSet.add(board[i][j])) return false;
                }
            }
        }
        hashSet.clear();

        for (int i = 3; i < 6; i++) {
            for (j = 3; j < 6; j++) {
                char val = board[i][j];
                if (val != '.') {
                    if (!hashSet.add(board[i][j])) return false;
                }
            }
        }
        hashSet.clear();

        for (int i = 3; i < 6; i++) {
            for (j = 6; j < 9; j++) {
                char val = board[i][j];
                if (val != '.') {
                    if (!hashSet.add(board[i][j])) return false;
                }
            }
        }
        hashSet.clear();

        // 6,0 ~ 8,8
        for (int i = 6; i < 9; i++) {
            for (j = 0; j < 3; j++) {
                char val = board[i][j];
                if (val != '.') {
                    if (!hashSet.add(board[i][j])) return false;
                }
            }
        }
        hashSet.clear();

        for (int i = 6; i < 9; i++) {
            for (j = 3; j < 6; j++) {
                char val = board[i][j];
                if (val != '.') {
                    if (!hashSet.add(board[i][j])) return false;
                }
            }
        }
        hashSet.clear();

        for (int i = 6; i < 9; i++) {
            for (j = 6; j < 9; j++) {
                char val = board[i][j];
                if (val != '.') {
                    if (!hashSet.add(board[i][j])) return false;
                }
            }
        }
        hashSet.clear();
        return true;
    }

}
