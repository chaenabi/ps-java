package programmers.codingTestPractice.level1;

import java.util.Arrays;

public class Prgs12940 {
    public int[] solution(int n, int m) {
        int[] answer = {};

        int gcd = gcd(n, m);
        int lcm = (n * m) / gcd;

        return new int[]{gcd, lcm};
    }

    int gcd(int n, int m) {
        if (m == 0) return n;
        return gcd(m, n % m);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Prgs12940().solution(3, 12)));
        System.out.println(Arrays.toString(new Prgs12940().solution(2, 5)));
    }

}
