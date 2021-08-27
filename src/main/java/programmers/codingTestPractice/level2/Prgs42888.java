package programmers.codingTestPractice.level2;

import java.util.*;

/**
 * 오픈 채팅방
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 * 2021-08-18
 */
public class Prgs42888 {
    public String[] solution(String[] record) {
        Map<String, String> idnick = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String message : record) {
            String[] msg = message.split(" ");
            if (!msg[0].equals("Leave")) {
                idnick.put(msg[1], msg[2]);
            }
        }

        for (String log : record) {
            String[] msg = log.split(" ");
            switch (msg[0]) {
                case "Enter":
                    result.add(idnick.get(msg[1]) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    result.add(idnick.get(msg[1]) + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[result.size()];
        return result.toArray(answer);

    }

    public static void main(String[] args) {
        String[] case1 = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(new Prgs42888().solution(case1)));
    }
}
