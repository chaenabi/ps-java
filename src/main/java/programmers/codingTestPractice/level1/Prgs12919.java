package programmers.codingTestPractice.level1;

import java.util.Arrays;

public class Prgs12919 {
    public String solution(String[] seoul) {
        return Arrays.stream(seoul)
                .mapToInt(e -> {
                    int i = 0;
                    if (!e.equals("Kim")) {
                        ++i;
                    }
                    return i;
                })
                .mapToObj(s -> "김서방은 " + s + "에 있다")
                .findFirst()
                .get();
    }
}
