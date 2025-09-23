package leetcode

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
 * 설명: 4-Queens 문제에는 두 가지 해답이 존재합니다.
 *
 * 예시 2:
 * 입력: n = 1
 * 출력: [["Q"]]
 */
class NQueens {
    fun solveNQueens(n: Int): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val board = Array(n) { CharArray(n) { '.' } }

        // 0번째 행부터 시작해서 백트래킹으로 퀸을 배치
        backtrack(0, n, board, result)

        return result
    }

    private fun backtrack(row: Int, n: Int, board: Array<CharArray>, result: MutableList<List<String>>) {
        // 모든 행에 퀸을 성공적으로 배치했다면
        if (row == n) {
            // 현재 보드 상태를 문자열 리스트로 변환해서 결과에 추가
            val solution = board.map { String(it) }
            result.add(solution)
            return
        }

        // 현재 행의 각 열에 퀸을 놓아보기
        for (col in 0 until n) {
            // 이 위치에 퀸을 놓을 수 있는지 검사
            if (isSafe(board, row, col, n)) {
                // 1. 퀸을 놓기
                board[row][col] = 'Q'

                // 2. 다음 행으로 재귀 호출 (다음 행에 퀸 배치 시도)
                backtrack(row + 1, n, board, result)

                // 3. 퀸을 제거 (백트래킹 - 이전 상태로 복원)
                // 재귀 호출이 끝나고 돌아오면 이 코드가 실행됨!
                board[row][col] = '.'
            }
        }
    }

    private fun isSafe(board: Array<CharArray>, row: Int, col: Int, n: Int): Boolean {
        // 현재 위치 (row, col)에 퀸을 놓을 수 있는지 검사

        // 1. 같은 열에 퀸이 있는지 검사 (위쪽 행들만 확인하면 됨)
        for (i in 0 until row) {
            if (board[i][col] == 'Q') return false
        }

        // 2. 왼쪽 위 대각선 검사
        var i = row - 1
        var j = col - 1
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false
            i--
            j--
        }

        // 3. 오른쪽 위 대각선 검사
        i = row - 1
        j = col + 1
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') return false
            i--
            j++
        }

        // 같은 행은 검사할 필요 없음 (한 행에 하나씩만 놓기 때문)
        // 아래쪽도 검사할 필요 없음 (아직 퀸을 놓지 않았기 때문)

        return true
    }
}