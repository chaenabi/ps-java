package baekjoon.basic;

import java.io.*;

/**
 * 1, 2, 3 Sum: not solve yet
 * https://www.acmicpc.net/problem/9095
 */
public class Bj9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 4;
            for (int i = 4; i <= n; i++) {
                arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
            }
            bw.write(arr[n] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
