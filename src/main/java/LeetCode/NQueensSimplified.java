package leetcode;

import java.util.*;

/**
 * N-Queens 문제 - 더 자세한 주석과 디버그 출력을 포함한 버전
 * 백트래킹의 동작을 이해하기 쉽게 만든 교육용 버전입니다.
 */
public class NQueensSimplified {

    private int callCount = 0;  // 재귀 호출 횟수 추적

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // 보드 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        System.out.println("=== N-Queens 시작 (N=" + n + ") ===\n");
        backtrack(0, n, board, result);
        System.out.println("\n총 재귀 호출 횟수: " + callCount);
        System.out.println("찾은 해답 개수: " + result.size());

        return result;
    }

    private void backtrack(int row, int n, char[][] board, List<List<String>> result) {
        callCount++;
        String indent = "  ".repeat(row);  // 들여쓰기로 재귀 깊이 표현

        System.out.println(indent + "→ backtrack(row=" + row + ") 호출");

        // 모든 퀸을 성공적으로 배치했다면
        if (row == n) {
            System.out.println(indent + "✓ 해답 발견!");
            printBoard(board, indent);

            // 결과 저장
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            result.add(solution);
            return;
        }

        // 현재 행의 각 열에 퀸 놓아보기
        for (int col = 0; col < n; col++) {
            System.out.println(indent + "  [" + row + "," + col + "] 위치 검사중...");

            if (isSafe(board, row, col, n)) {
                System.out.println(indent + "  ✓ [" + row + "," + col + "]에 퀸 놓기");

                // 1. 퀸을 놓는다
                board[row][col] = 'Q';

                // 2. 다음 행으로 재귀 호출
                backtrack(row + 1, n, board, result);

                // 3. 퀸을 제거 (백트래킹!)
                board[row][col] = '.';
                System.out.println(indent + "  ← [" + row + "," + col + "]에서 퀸 제거 (백트래킹)");

            } else {
                System.out.println(indent + "  ✗ [" + row + "," + col + "] 불가능");
            }
        }

        System.out.println(indent + "← backtrack(row=" + row + ") 종료");
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        // 같은 열 검사
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 왼쪽 위 대각선
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 오른쪽 위 대각선
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void printBoard(char[][] board, String indent) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(indent + "  " + new String(board[i]));
        }
    }

    public static void main(String[] args) {
        NQueensSimplified solution = new NQueensSimplified();

        // 작은 예제로 동작 과정 확인
        System.out.println("작은 예제 (N=6)로 백트래킹 과정 보기:\n");
        solution.solveNQueens(6);
    }
}