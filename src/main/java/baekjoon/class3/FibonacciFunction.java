package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1003
// 피보나치 함수
public class FibonacciFunction {
    static int zeroCnt = 0;
    static int oneCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int f = Integer.parseInt(br.readLine());
            int[] memo = new int[f + 1];
            fibo(memo, f);
            System.out.print(zeroCnt + " " + oneCnt + "\n");
            zeroCnt = oneCnt = 0;
        }
    }

    static int fibo(int[] memo, int n) {
        if (n == 0) {
            zeroCnt++;
            return 0;
        } else if (n == 1) {
            oneCnt++;
            return 1;
        } else {
            if (memo[n] > 0) return memo[n];
            else memo[n] = fibo(memo, n - 1) + fibo(memo, n - 2);
            return memo[n];
        }
    }
}
