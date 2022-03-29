package cote.trenbi;

import java.util.*;

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

    private int[] solution2(int[] grade) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < grade.length; i++) {
            int currentPoint = grade[i];
            LinkedList<Integer> list = map.getOrDefault(currentPoint, new LinkedList<>());
            list.add(i);
            map.put(currentPoint, list);
        }
        Integer[] keyArrays = map.keySet().toArray(Integer[]::new);
        Arrays.sort(keyArrays, Collections.reverseOrder());
        int currentGrade = 1;
        int gradeCount = 0;
        for (Integer i : keyArrays) {
            LinkedList<Integer> currentList = map.get(i);
            for (Integer j : currentList) {
                grade[j] = currentGrade;
                gradeCount++;
            }
            currentGrade += gradeCount;
            gradeCount = 0;
        }
        return grade;
    }

    private int[] solution3(int[] grade) {

        int[] answer = new int[grade.length];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < grade.length; i++) { //점수별 몇명 ?
            if (map.get(grade[i]) == null) {
                map.put(grade[i], 1);
            } else {
                map.put(grade[i], map.get(grade[i]) + 1);
            }
        }
        //해당 점수일 경우 나보다 등수 높은사람 몇명 ?
        List<Integer> keyset = new ArrayList<>(map.keySet());
        keyset.sort(Collections.reverseOrder());
        Map<Integer, Integer> map2 = new HashMap<>();

        int n = 1;
        for (int i : keyset) {
            map2.put(i, n);
            n += map.get(i);
        }

        for (int i = 0; i < grade.length; i++) {
            int myScore = grade[i]; // 내랭크
            answer[i] = map2.get(myScore);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution3().solution(new int[]{2, 2, 1})));
        System.out.println(Arrays.toString(new Solution3().solution2(new int[]{2, 2, 1})));
    }
}
