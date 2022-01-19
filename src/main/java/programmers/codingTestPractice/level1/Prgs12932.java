package programmers.codingTestPractice.level1;

import java.util.Arrays;
import java.util.stream.LongStream;

public class Prgs12932 {
    public int[] solution(long n) {
        return Arrays.stream(LongStream.of(n)
                        .mapToObj(String::valueOf)
                        .flatMap(c -> c.chars().mapToObj(c1 -> (char) c1))
                        .reduce("", (s, c2) -> c2 + s, (s1, s2) -> s2 + s1)
                        .split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Prgs12932().solution(12345)));
    }
}
