package programmers.codingTestPractice.level1;

import java.util.Arrays;

/*
    participant : 참여선수 명단
    completion : 완주한 선수 명단
    반환값: 완주못한 선수 목록

    조건 : 1. 완주 못한 선수는 항상 1명이다
    2. 동명이인이 있을 수 있음
 */
public class Prgs42576 {
    public String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        // eden isa kiki
        // eden kiki
        for (int i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }
        return participant[participant.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Prgs42576().solution(new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}));

        System.out.println(new Prgs42576().solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}));


        System.out.println(new Prgs42576().solution(new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}));
    }
}
