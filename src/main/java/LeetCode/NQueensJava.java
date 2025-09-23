package LeetCode;

import java.util.*;

/**
 * LeetCode 51. N-Queens
 * URL: https://leetcode.com/problems/n-queens/
 *
 * 문제 설명:
 * n × n 체스판 위에 n개의 퀸을 서로 공격할 수 없도록 배치하는 문제입니다.
 * 퀸은 같은 행, 같은 열, 같은 대각선 상에 있는 다른 퀸을 공격할 수 있습니다.
 *
 * 입력:
 * - n: 체스판의 크기이자 배치할 퀸의 개수 (1 <= n <= 9)
 *
 * 출력:
 * - List<List<String>>: 모든 가능한 n개의 퀸 배치 방법
 * - 각 해답은 n개의 문자열 리스트로 표현
 * - 'Q'는 퀸을 나타내고 '.'는 빈 칸을 나타냄
 *
 * 예시 1:
 * 입력: n = 4
 * 출력: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 */
public class NQueensJava {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // 보드를 '.'으로 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // 0번째 행부터 백트래킹 시작
        backtrack(0, n, board, result);

        return result;
    }

    private void backtrack(int row, int n, char[][] board, List<List<String>> result) {
        // 기저 조건: 모든 행에 퀸을 성공적으로 배치했다면
        if (row == n) {
            // 현재 보드 상태를 문자열 리스트로 변환해서 결과에 추가
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            result.add(solution);
            return;
        }

        // 현재 행의 각 열에 퀸을 놓아보기
        for (int col = 0; col < n; col++) {
            // 이 위치에 퀸을 놓을 수 있는지 검사
            if (isSafe(board, row, col, n)) {
                // 1. 선택: 퀸을 놓는다
                board[row][col] = 'Q';

                // 2. 탐색: 다음 행으로 재귀 호출
                //    다음 행에서도 퀸을 놓을 수 있는지 시도
                backtrack(row + 1, n, board, result);

                // 3. 취소(백트래킹): 퀸을 제거하고 원래 상태로 복원
                //    재귀 호출이 끝나고 돌아오면 이 코드가 실행됨!
                //    이렇게 해야 다음 열(col+1)에도 시도해볼 수 있음
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        // 현재 위치 (row, col)에 퀸을 놓을 수 있는지 검사

        // 1. 같은 열에 퀸이 있는지 검사
        //    위쪽 행들만 확인하면 됨 (아래쪽은 아직 퀸을 놓지 않았음)
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 2. 왼쪽 위 대각선 검사 (↖)
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        // 3. 오른쪽 위 대각선 검사 (↗)
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        // 같은 행은 검사할 필요 없음 (한 행에 하나씩만 놓기 때문)
        // 아래쪽 대각선도 검사할 필요 없음 (아직 퀸을 놓지 않았기 때문)

        return true;
    }

    // 테스트용 main 메서드
    public static void main(String[] args) {
        NQueensJava solution = new NQueensJava();

        // n = 4 테스트
        System.out.println("N = 4 솔루션:");
        List<List<String>> result4 = solution.solveNQueens(4);
        for (List<String> board : result4) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }

        // n = 8 테스트 (솔루션 개수만 출력)
        List<List<String>> result8 = solution.solveNQueens(8);
        System.out.println("N = 8 솔루션 개수: " + result8.size());
    }
}