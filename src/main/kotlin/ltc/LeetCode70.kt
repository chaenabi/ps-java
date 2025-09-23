package ltc

/**
 * LeetCode 70: Climbing Stairs
 * URL: https://leetcode.com/problems/climbing-stairs/
 *
 * 문제 설명:
 * 계단을 오를 때, 한 번에 1계단 또는 2계단씩 오를 수 있습니다.
 * n개의 계단을 오르는 서로 다른 방법의 수를 구하세요.
 *
 * 예시 1:
 * 입력: n = 2
 * 출력: 2
 * 설명: 2개의 계단을 오르는 방법은 2가지입니다.
 * 1. 1계단 + 1계단
 * 2. 2계단
 *
 * 예시 2:
 * 입력: n = 3
 * 출력: 3
 * 설명: 3개의 계단을 오르는 방법은 3가지입니다.
 * 1. 1계단 + 1계단 + 1계단
 * 2. 1계단 + 2계단
 * 3. 2계단 + 1계단
 *
 * 제약사항:
 * - 1 <= n <= 45
 *
 * DP 접근법 힌트:
 * - n번째 계단에 도달하는 방법 = (n-1)번째 계단에서 1계단 오르기 + (n-2)번째 계단에서 2계단 오르기
 * - 점화식: dp[n] = dp[n-1] + dp[n-2]
 * - 이는 피보나치 수열과 동일한 패턴입니다!
 */
class LeetCode70 {

    /**
     * 동적 프로그래밍으로 해결하는 방법
     * 시간 복잡도: O(n)
     * 공간 복잡도: O(n)
     */
    fun climbStairs(n: Int): Int {
        // n이 1이거나 2일 때는 바로 반환
        if (n <= 2) return n

        // dp 배열 초기화
        // dp[i] = i번째 계단까지 오르는 방법의 수
        val dp = IntArray(n + 1)

        // 기저 사례 설정
        dp[1] = 1  // 1계단 오르는 방법: 1가지
        dp[2] = 2  // 2계단 오르는 방법: 2가지

        // 3번째 계단부터 n번째 계단까지 계산
        for (i in 3..n) {
            // i번째 계단에 도달하는 방법 =
            // (i-1)번째 계단에서 1계단 오르기 + (i-2)번째 계단에서 2계단 오르기
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n]
    }

    /**
     * 공간 최적화된 방법
     * 시간 복잡도: O(n)
     * 공간 복잡도: O(1)
     */
    fun climbStairsOptimized(n: Int): Int {
        if (n <= 2) return n

        // 이전 두 값만 저장하면 충분함
        var prev2 = 1  // dp[i-2]
        var prev1 = 2  // dp[i-1]

        for (i in 3..n) {
            val current = prev1 + prev2
            prev2 = prev1
            prev1 = current
        }

        return prev1
    }
}

fun main() {
    val solution = LeetCode70()

    // 테스트 케이스
    val testCases = listOf(
        1 to 1,
        2 to 2,
        3 to 3,
        4 to 5,
        5 to 8,
        6 to 13
    )

    println("=== Climbing Stairs 테스트 ===")
    println()

    for ((input, expected) in testCases) {
        val result1 = solution.climbStairs(input)
        val result2 = solution.climbStairsOptimized(input)

        println("입력: n = $input")
        println("기대값: $expected")
        println("결과 (DP 배열): $result1 ${if (result1 == expected) "✓" else "✗"}")
        println("결과 (최적화): $result2 ${if (result2 == expected) "✓" else "✗"}")

        if (input <= 5) {
            println("설명: ${getExplanation(input)}")
        }
        println()
    }
}

fun getExplanation(n: Int): String {
    return when (n) {
        1 -> "1가지 방법: [1]"
        2 -> "2가지 방법: [1+1], [2]"
        3 -> "3가지 방법: [1+1+1], [1+2], [2+1]"
        4 -> "5가지 방법: [1+1+1+1], [1+1+2], [1+2+1], [2+1+1], [2+2]"
        5 -> "8가지 방법: [1+1+1+1+1], [1+1+1+2], [1+1+2+1], [1+2+1+1], [2+1+1+1], [1+2+2], [2+1+2], [2+2+1]"
        else -> ""
    }
}