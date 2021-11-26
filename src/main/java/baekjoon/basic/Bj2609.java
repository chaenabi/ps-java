package baekjoon.basic;

import java.io.*;
import java.util.Arrays;

/**
 * gcd, lcm
 * https://www.acmicpc.net/problem/2609
 */
public class Bj2609 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        int a = inputs[0];
        int b = inputs[1];

        int result = gcd(a, b);

        bw.write(result + "\n"); // 최대공약수
        bw.write(((a * b) / result) + ""); // 최소공배수

        bw.flush();
        bw.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
