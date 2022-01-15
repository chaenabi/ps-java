package programmers.codingTestPractice.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prgs12910 {
    public int[] solution(int[] arr, int divisor) {

        List<Integer> list = new ArrayList<>();

        for (int ar : arr) {
            if (ar % divisor == 0) {
                list.add(ar);
            }
        }
        int[] ints = list.stream().mapToInt(Integer::intValue).sorted().toArray();
        if (ints.length == 0) ints = new int[]{-1};

        return ints;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Prgs12910().solution(new int[]{5, 9, 7, 10}, 5)));
        System.out.println(Arrays.toString(new Prgs12910().solution(new int[]{2, 36, 1, 13}, 1)));
        System.out.println(Arrays.toString(new Prgs12910().solution(new int[]{3, 2, 6}, 10)));
    }

}
