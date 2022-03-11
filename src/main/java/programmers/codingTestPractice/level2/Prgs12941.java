package programmers.codingTestPractice.level2;

import java.util.Arrays;

public class Prgs12941 {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int min = 0;

        for (int i = 0, j = A.length - 1; i < A.length; i++, j--) {
            min += A[i] * B[j];
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Prgs12941().solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        System.out.println(new Prgs12941().solution(new int[]{1, 2}, new int[]{3, 4}));
    }
}
