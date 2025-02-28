package programmers.practice.kt

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Prgs181907 {

    fun solution(my_string: String, n: Int): String {
        return my_string.substring(0, n)
    }

    @Test
    fun test(): Unit {
        assertThat(solution("ProgrammerS123", 11)).isEqualTo("ProgrammerS")
    }
}