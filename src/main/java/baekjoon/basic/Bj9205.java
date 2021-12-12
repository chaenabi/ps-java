package baekjoon.basic;


import java.io.*;
import java.util.Arrays;

/**
 * 맥주 마시면서 걸어가기 (미해결)
 * https://www.acmicpc.net/problem/9205
 */
public class Bj9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int beer = 20;
            int convinience = Integer.parseInt(br.readLine());

            int[] home = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] convin = new int[convinience][2];
            for (int i = 0; i < convinience; i++) {
                convin[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int[] dest = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int y = home[0]; y < dest[0]; y += 50) {
                for (int x = home[1]; x < dest[1]; x += 50) {
                    --beer;

                }
            }

        }

    }
}
