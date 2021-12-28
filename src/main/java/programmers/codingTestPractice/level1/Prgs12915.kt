package programmers.codingTestPractice.level1

fun main() {
    println(solution(arrayOf("abce", "abcd", "cdx"), 2).joinToString(" "));
}

fun solution(strings: Array<String>, n: Int): Array<String> = strings.sortedWith(compareBy<String>{ it[n] }.thenBy{ it }).toTypedArray()
