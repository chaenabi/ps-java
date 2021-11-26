package baekjoon.basic;

import java.io.*;
import java.util.Arrays;

/**
 * GCD Sum (최대공약수의 합)
 * https://www.acmicpc.net/problem/9613
 */
public class Bj9613 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long result = 0;
            for (int i = 1; i < inputs.length; i++) {
               for (int j = i + 1; j < inputs.length; j++) {
                   result += gcd(inputs[i], inputs[j]);
               }
            }
            bw.write(result + "\n");

        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static long gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
