package baekjoon.basic;

import java.io.*;
import java.util.Arrays;

/**
 * find prime number
 * https://www.acmicpc.net/problem/1978
 */
public class Bj1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        int prime = 0;

        for (int input : inputs) {
            if (input >= 2) {
                boolean isPrime = true;
                for (int i = 2; i * i <= input; i++) {
                    if (input % i == 0) {
                        isPrime = false;
                    }
                }
                if (isPrime) prime++;
            }
        }

        bw.write(prime + "");
        bw.flush();
        bw.close();
    }
}
