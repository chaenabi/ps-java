package programmers.codingTestPractice.level1;

import java.util.Comparator;

public class Prgs12917 {
    public String solution(String s) {
        return s.chars()
                .mapToObj(e -> (char) e)
                .sorted(Comparator.reverseOrder())
                .reduce("", (c1, c2) -> c1 + c2, (s1, s2) -> s1 + s2);
    }
}
