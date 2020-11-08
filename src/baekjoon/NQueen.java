package baekjoon;

import java.util.Scanner;

public class NQueen {

    public static void main(String[] args) {
            solution();
    }

    private static int cnt = 0;
    private static int[] col;
    private static int N;

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();
        for(int i = 1; i <= N; i++) {
            col = new int[N+1];
            col[1] = i;
            dfs(1);
        }
        System.out.println(cnt);
    }

    private static void dfs(int row) {
        if(row == N) {
            cnt++;
        } else {
            for(int i = 1; i <= N; i++) {
                col[row+1] = i;
                if(isPossible(row+1)) {
                    dfs(row+1);
                } else {
                    col[row+1] = 0;
                }
            }
        }
        col[row] = 0;
    }

    private static boolean isPossible(int prevRow) {
        for(int i = 1; i < prevRow; i++) {
            if(col[i] == col[prevRow]) return false;
            if(Math.abs(col[i] - col[prevRow]) == Math.abs(i - prevRow)) return false;
        }
        return true;
    }
}
