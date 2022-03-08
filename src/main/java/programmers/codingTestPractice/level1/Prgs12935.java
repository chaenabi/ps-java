package programmers.codingTestPractice.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Prgs12935 {
    public int[] solution(int[] arr) {
        Integer[] integers = IntStream.of(arr).boxed().toArray(Integer[]::new);

        int[] answer = new int[arr.length - 1];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) continue;
            answer[idx++] = integers[i];
        }

        return answer.length == 0 ? new int[]{-1} : answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Prgs12935().solution(new int[]{1,5,7,3,2,6})));
    }
}
