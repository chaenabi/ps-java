package baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1463 {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];
        int result = makeBeingOne(n);
        System.out.println(result);
    }

    static int makeBeingOne(int n) {
        if (n == 1) return 0;
        if (memo[n] > 0) return memo[n];

        memo[n] = makeBeingOne(n - 1) + 1;

        if (n % 2 == 0) {
            int temp = makeBeingOne(n / 2) + 1;
            if (memo[n] > temp) memo[n] = temp;
        }

        if (n % 3 == 0) {
            int temp = makeBeingOne(n / 3) + 1;
            if (memo[n] > temp) memo[n] = temp;
        }

        return memo[n];
    }
}
