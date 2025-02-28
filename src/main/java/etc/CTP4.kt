package etc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/*
   코딩 테스트 합격자 되기 116 page
   모의고사
 */
class CTP4 {

    private fun mockTest(answers: IntArray): IntArray {
        val answersLen = answers.size
        val first = intArrayOf(1, 2, 3, 4, 5)
        val second = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val third = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        val candidates = listOf(first, second, third)

        val toList = candidates.listIterator()
            .asSequence()
            .map { candidate ->
                candidate.mapIndexed { index, value ->
                    if (answers[index % answersLen] == value) 1 else 0
                }.sum()
            }.toList()
        val max = toList.maxOrNull()
        return toList.mapIndexed { index, value -> if (value == max) index + 1 else 0 }
            .filter { it != 0 }
            .toIntArray()
    }

    @Test
    fun test(): Unit {
       assertThat(mockTest(intArrayOf(1, 2, 3, 4, 5))).isEqualTo(intArrayOf(1))
        assertThat(mockTest(intArrayOf(1, 3, 2, 4, 2))).isEqualTo(intArrayOf(1, 2, 3))
    }
}