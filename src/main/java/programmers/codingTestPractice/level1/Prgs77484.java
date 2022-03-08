package programmers.codingTestPractice.level1;

import java.util.Arrays;
import java.util.Map;

// 로또의 최고 순위와 최저 순위
public class Prgs77484 {
    public int[] solution(int[] lottos, int[] win_nums) {

        Map<Integer, Integer> map = Map.of(6, 1, 5, 2, 4, 3, 3, 4, 2, 5, 1, 6, 0, 6);

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int lowest = 0, highest;

        for (int lotto : lottos) {
            if (lotto == 0) continue;
            for (int win_num : win_nums) {
                if (win_num > lotto) break;
                if (win_num == lotto) {
                    lowest++;
                    break;
                }
            }
        }

        highest = lowest;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) highest++;
            if (lottos[i] != 0) break;
        }

        return new int[]{map.get(highest), map.get(lowest)};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Prgs77484().solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
    }
}
