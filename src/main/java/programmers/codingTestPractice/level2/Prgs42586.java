package programmers.codingTestPractice.level2;

import java.util.*;

/**
 * 기능개발
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * 2021-08-02
 */
public class Prgs42586 {

    public int[] solution(int[] progresses, int[] speeds) {
        final int finish = 100;
        List<Integer> spendTime = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int i = 0;

        for (int task : progresses) {
            int count = 0;
            while (finish > task) {
                task += speeds[i];
                count++;
            }
            spendTime.add(count);
            i++;
        }

        //if (spendTime.size() == 1) return spendTime.stream().mapToInt(Integer::intValue).toArray();

        int count = 1;
        int max = spendTime.get(0);
        // 7, 3, 5, 2, 5, 9
        for (int j = 1; j < spendTime.size(); j++) {
            if (max >= spendTime.get(j)) count++;
            else {
                result.add(count);
                max = spendTime.get(j);
                count = 1;
            }
        }
        result.add(count);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
