package programmers.codingTestPractice.level1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 12, 15, 21, 22, 23, 25, 26
public class Prgs72410 {

    public String solution(String new_id) {
        if (new_id.length() == 0) return "aaa";
        new_id = new_id.toLowerCase();
        new_id = new_id.chars()
                .mapToObj(i -> (char) i)
                .filter(it -> (it >= 'a' && it <= 'z') || (it >= 'A' && it <= 'Z') || (it - 48 >= 0 && it - 48 <= 9) || it == '-' || it == '_' || it == '.')
                .map(String::valueOf)
                .collect(Collectors.joining());
        new_id = new_id.replaceAll("\\.{2,15}", ".");
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        if (new_id.length() == 0) new_id = "a";
        if (new_id.length() >= 16) new_id = new_id.substring(0, 15);
        for (int i = new_id.length() - 1; new_id.charAt(i) == '.'; i--) {
            new_id = new_id.replaceAll("\\.$", "");
        }
        if (new_id.length() <= 2) {
            while (new_id.length() <= 2) {
                new_id += new_id.substring(new_id.length() - 1);
            }
        }

        return new_id;
    }

    public static void main(String[] args) {
        Prgs72410 prgs72410 = new Prgs72410();
        System.out.println(prgs72410.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(prgs72410.solution("z-+.^."));
        System.out.println(prgs72410.solution("=.="));
        System.out.println(prgs72410.solution("123_.def"));
        System.out.println(prgs72410.solution("abcdefghijklmn.p"));

        IntStream.rangeClosed(1, 9).forEach(dan -> {IntStream.rangeClosed(2, 9).forEach(level -> System.out.print(level + " * " + dan + " = " + dan*level + "\t")); System.out.println();});

    }

}
