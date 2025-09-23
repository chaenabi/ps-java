package leetcode

fun main() {
    val solution = NQueens()

    // Test n = 1
    println("Test n = 1:")
    val result1 = solution.solveNQueens(1)
    val expected1 = listOf(listOf("Q"))
    println("Expected: $expected1")
    println("Result: $result1")
    println("Pass: ${result1 == expected1}")
    println()

    // Test n = 2 (해답 없음)
    println("Test n = 2:")
    val result2 = solution.solveNQueens(2)
    println("Expected: [] (no solution)")
    println("Result: $result2")
    println("Pass: ${result2.isEmpty()}")
    println()

    // Test n = 3 (해답 없음)
    println("Test n = 3:")
    val result3 = solution.solveNQueens(3)
    println("Expected: [] (no solution)")
    println("Result: $result3")
    println("Pass: ${result3.isEmpty()}")
    println()

    // Test n = 4
    println("Test n = 4:")
    val result4 = solution.solveNQueens(4)
    val expected4 = listOf(
        listOf(".Q..", "...Q", "Q...", "..Q."),
        listOf("..Q.", "Q...", "...Q", ".Q..")
    )
    println("Expected solutions count: 2")
    println("Result solutions count: ${result4.size}")
    println("Results:")
    result4.forEach { board ->
        board.forEach { println(it) }
        println()
    }
    println("Pass: ${result4.size == 2 && isAllValidSolutions(result4)}")
    println()

    // Test n = 5
    println("Test n = 5:")
    val result5 = solution.solveNQueens(5)
    println("Expected solutions count: 10")
    println("Result solutions count: ${result5.size}")
    println("Pass: ${result5.size == 10 && isAllValidSolutions(result5)}")
    println()

    // Test n = 8
    println("Test n = 8:")
    val result8 = solution.solveNQueens(8)
    println("Expected solutions count: 92")
    println("Result solutions count: ${result8.size}")
    println("Pass: ${result8.size == 92 && isAllValidSolutions(result8)}")
}

/**
 * 모든 솔루션이 유효한지 검사
 */
fun isAllValidSolutions(solutions: List<List<String>>): Boolean {
    return solutions.all { isValidSolution(it) }
}

/**
 * 주어진 체스판 배치가 유효한 N-Queens 솔루션인지 검증
 */
fun isValidSolution(board: List<String>): Boolean {
    val n = board.size
    val queens = mutableListOf<Pair<Int, Int>>()

    // 퀸의 위치 찾기
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == 'Q') {
                queens.add(Pair(i, j))
            }
        }
    }

    // 정확히 n개의 퀸이 있는지 확인
    if (queens.size != n) return false

    // 모든 퀸 쌍에 대해 서로 공격할 수 없는지 확인
    for (i in queens.indices) {
        for (j in i + 1 until queens.size) {
            val (r1, c1) = queens[i]
            val (r2, c2) = queens[j]

            // 같은 행
            if (r1 == r2) return false
            // 같은 열
            if (c1 == c2) return false
            // 같은 대각선
            if (kotlin.math.abs(r1 - r2) == kotlin.math.abs(c1 - c2)) return false
        }
    }

    return true
}