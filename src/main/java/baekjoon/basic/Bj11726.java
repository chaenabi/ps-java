package baekjoon.basic;

import java.io.*;

public class Bj11726 {

    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];
        bw.write(tiling(n) + "");
        br.close(); bw.flush(); bw.close();
    }

    private static int tiling(int n) {
        if (memo[n] != 0) return memo[n];
        if (n == 1) {
            memo[n] = 1;
            return memo[n];
        }
        if (n == 2) {
            memo[n] = 2;
            return memo[n];
        }
        memo[n] = (tiling(n - 1) + tiling(n - 2)) % 10007;
        return memo[n];
    }
    /*
        private static long tiling2(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 10007;
        }
        return memo[n];
    }
     */

}
