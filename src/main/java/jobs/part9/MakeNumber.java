package jobs.part9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakeNumber {
    static int[] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        int iter = iterative(n);
        memo = new int[n + 1];
        int rec = recursion(n);

        if (iter == rec) System.out.println(iter);
    }

    private static int iterative(int n) {
        int[] memo = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2) {
                memo[i] = i;
            } else if (i == 3) {
                memo[i] = 4;
            } else {
                int ans = memo[i - 1] + memo[i - 2] + memo[i - 3];
                memo[i] = ans % 1000007;
            }
        }
        return memo[n];
    }

    private static int recursion(int n) {
        if (memo[n] != 0) return memo[n];

        if (n == 1 || n == 2) {
            return memo[n] = n;
        } else if (n == 3) {
            return memo[n] = 4;
        }
        return memo[n] = (recursion(n - 1) + recursion(n - 2) + recursion(n - 3)) % 1000007;
    }
}
