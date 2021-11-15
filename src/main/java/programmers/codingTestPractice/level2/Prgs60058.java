package programmers.codingTestPractice.level2;

/**
 * 괄호 변환
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 */
public class Prgs60058 {

    public static String reverse(String str) {
        StringBuilder s = new StringBuilder();

        for (int i = 1; i < str.length() - 1; i++){
            if (str.charAt(i) == '(') s.append(")");
            else s.append("(");
        }

        return s.toString();
    }

    public static boolean check(String str) {
        int open = 0;

        if (str.charAt(0) ==')') return false;

        for (int i = 0; i < str.length() ; i++) {
            if (str.charAt(i) == '(') open++;
            else {
                open--;
                if (open < 0) return false;
            }
        }
        return true;
    }

    public static String split(String w) {

        if (w.length() == 0) return "";

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        int open = 0;

        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') open++;
            else open--;

            if (open == 0) {
                u.append(w, 0, i + 1);
                v.append(w.substring(i + 1));

                if (check(u.toString())) {
                    u.append(split(v.toString()));
                } else {
                    return "(" + split(v.toString()) + ")" + reverse(u.toString());
                }
                break;
            }
        }
        return u.toString();
    }

    public String solution(String p) {
        String answer;
        if (check(p)) return p;
        answer = split(p);
        return answer;
    }
}
