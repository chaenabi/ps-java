package cote;

import java.util.Arrays;

/*
    N명의 학생이 시험을 보았습니다.
    각 학생에는 1~N의 번호가 있음
    각 학생의 등수는 자신보다 높은 점수를 받은 학생의 수의 1을 더함

    예) 세 학생이 있다.
    1,2,3번 학생의 성적이 각각 2, 2, 1이라면 1,2번 학생은 가장 점수가 높다.
    또한 동점이므로 공동 1등이다.
    3번 학생은 3등이다.
 */
public class Solution3 {
    public int[] solution(int[] grade) {
        int[] answer = new int[grade.length];

        for (int i = 0; i < grade.length; i++) {
            answer[i] = 1; // 모두 1등으로 초기화
            for (int j = 0; j < grade.length; j++) {
                if (grade[i] < grade[j]) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution3().solution(new int[]{2, 2, 1})));
    }
}
