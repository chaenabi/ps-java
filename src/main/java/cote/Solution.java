package cote;

import java.util.*;
/*
    1. 스트링 s가 입력값. s는 알파벳 대소문자로만 되어있음
    2. 가장 많이 쓰인 알파벳을 찾아서 해당 알파벳 return
    3. 대소문자는 같음
    4. 가장 많이 쓰인 알파벳이 하나이면 소문자로 반환
    5. 가장 많이 쓰인 알파벳이 2개 이상이면 알파벳 순서대로 스트링을 이루어 반환


 */
public class Solution {

    public String solution(String s) {
        if (s.equals("")) return "";

        Map<Character, Integer> map = new HashMap<>();

        for (char al = 97; al <= 122; al++) {
            map.put(al, 0);
        }

        for (char c : s.toCharArray()) {
            char upper = (char) (c + 32);
            if (map.containsKey(c) || map.containsKey(upper)) {
                int count = map.getOrDefault(c, map.get(upper));
                String clower = (c + "").toLowerCase();
                map.put(clower.charAt(0), count + 1);
            }
        }

        Set<Integer> set = new HashSet<>();

        String result = "";
        int max = 0;

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            System.out.println(e);
        }

        for (Map.Entry<Character, Integer> cnt : map.entrySet()) {
            set.add(cnt.getValue());
            if (max < cnt.getValue()) max = cnt.getValue();
        }


        for (Map.Entry<Character, Integer> cnt : map.entrySet()) {
            if (cnt.getValue() == max) {
                result += cnt.getKey() + "";
            }
        }

        return result.toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("BbA"));

    }


    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
