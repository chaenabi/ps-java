package programmers.codingTestPractice.level1;

public class Prgs12916 {
    boolean solution(String s) {
        int p = 0, y = 0;

        for (char c : s.toCharArray()) {
            if (c == 'p' || c == 'P') p++;
            if (c == 'y' || c == 'Y') y++;
        }
        return p == y;
    }

    public static void main(String[] args) {
        System.out.println(new Prgs12916().solution("pPoooyY"));
        System.out.println(new Prgs12916().solution("pyy"));
    }
}
