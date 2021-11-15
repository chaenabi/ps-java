package programmers.codingTestPractice.level2;

import java.util.*;

/**
 * 메뉴리뉴얼
 * https://programmers.co.kr/learn/courses/30/lessons/72411
 */
public class Prgs72411 {

    static HashMap<String,Integer> map;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        for (int k : course) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;

            for (String order : orders) {
                StringBuilder sb = new StringBuilder();
                if (k <= order.length())
                    comb(order, sb, 0, 0, k);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (max >= 2 && entry.getValue() == max)
                    answer.add(entry.getKey());
            }
        }
        Collections.sort(answer);

        String[] ans = new String[answer.size()];
        return answer.toArray(ans);
    }

    public static void comb(String str, StringBuilder sb, int idx, int cnt, int n) {
        if(cnt == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(),0) + 1);
            return;
        }

        for(int i = idx; i < str.length(); i++){
            sb.append(str.charAt(i));
            comb(str, sb, i + 1,cnt + 1, n);
            sb.delete(cnt,cnt + 1);
        }
    }
}
