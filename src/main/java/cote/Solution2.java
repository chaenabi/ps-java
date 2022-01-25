package cote;

import java.util.HashSet;
import java.util.Set;

/*
    좋은 부분 문자열
    s의 부분 문자열이면서 같은 알파벳이 두 번 이상 나타나지 않는 문자열
    abac일때 a, ab, bac등은 원래 문자열 abac의 부분문자열
 */
public class Solution2 {
    public int solution(String s) {

        Set<String> set = new HashSet<>();
        Set<String> modiSet = new HashSet<>();
        Set<Character> dupl = new HashSet<>();

        String partial = "";
        int slen = s.length();

        // 부분 문자열 넣기
        for (int i = 0; i < slen; i++) {
            partial = "";
            for (int j = i; j < slen; j++) {
                partial += s.substring(j, j + 1);
                set.add(partial);
                modiSet.add(partial);
            }
        }

        set.forEach(System.out::println);

        // 부분 문자열 중에서 중복이 발생하는 문자가 존재하면 제거해버림
        for (String part : set) {
            boolean isDup = false;
            for (int i = 0; i < part.length(); i++) {
                if (!dupl.contains(part.charAt(i))) {
                    dupl.add(part.charAt(i));
                } else {
                    isDup = true;
                    break;
                }
            }
            if (isDup) modiSet.remove(part);
            dupl.clear();
        }

        return modiSet.size();
    }

    public static void main(String[] args) {
        new Solution2().solution("abac");
    }
}
