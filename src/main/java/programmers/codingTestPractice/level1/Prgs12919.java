package programmers.codingTestPractice.level1;

import java.util.Arrays;

public class Prgs12919 {
    public String solution(String[] seoul) {
        return "김서방은 " + Arrays.asList(seoul).indexOf("Kim") + "에 있다";
    }

    public static void main(String[] args) {
        System.out.println(new Prgs12919().solution(new String[]{"a", "Kim"}));
    }
}
