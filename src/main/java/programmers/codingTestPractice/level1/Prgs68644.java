package programmers.codingTestPractice.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prgs68644 {
    public int[] solution(int[] numbers) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    public static void main(String[] args) {
        Prgs68644 prgs68644 = new Prgs68644();
        System.out.println(Arrays.toString(prgs68644.solution(new int[]{2,1,3,4,1})));
        System.out.println(Arrays.toString(prgs68644.solution(new int[]{5,0,2,7})));
    }
}
