package programmers.codingTestPractice.level2;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class Prgs60057Test {

    @Test
    public void pubcases() {
        Prgs60057 prgs60057 = new Prgs60057();
        assertEquals(7, prgs60057.solution("aabbaccc")); // 2a2ba3b
        assertEquals(9, prgs60057.solution("ababcdcdababcdcd")); // 2ababcdcd
        assertEquals(8, prgs60057.solution("abcabcdede")); // 2abcdede
        assertEquals(14, prgs60057.solution("abcabcabcabcdededededede")); // 2abcabc2dedede
        assertEquals(17, prgs60057.solution("xababcdcdababcdcd"));
    }

    @Test
    public void fiveStarByJava11() {
        String src = "*";
        var list = Stream.generate(() -> new String[]{src.repeat(5)}).limit(1).collect(toList());
        IntStream.range(0, list.size()).forEach((i) -> {
            IntStream.range(i, list.size() - 1).forEach((j) -> list.forEach((e) -> Arrays.stream(e).forEach(str -> System.out.print(j + str))));
            IntStream.range(0, 2*i+1).forEach((j) -> list.forEach((e) -> Arrays.stream(e).forEach(str -> System.out.println(j + str))));
            System.out.println();
        });
    }

}