package programmers.codingTestPractice.level1;

public class Prgs12903 {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        int slen = s.length();

        if (slen % 2 == 0) {
            return String.valueOf(chars[slen / 2 - 1]) + String.valueOf(chars[slen / 2]);
        }
        else if (slen % 2 == 1) {
            return String.valueOf(chars[slen / 2]);
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Prgs12903().solution("abcde"));
        System.out.println(new Prgs12903().solution("qwer"));

    }
}
