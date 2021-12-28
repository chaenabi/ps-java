package programmers.codingTestPractice.level1;

import java.util.Arrays;

import static java.util.Comparator.comparing;

public class Prgs12915 {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).sorted().sorted(comparing(i -> i.charAt(n))).toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] arr=  new Prgs12915().solution(new String[]{"abce", "abcd", "cdx"}, 2);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
