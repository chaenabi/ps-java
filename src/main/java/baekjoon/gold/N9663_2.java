package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// nQueen
// https://www.acmicpc.net/problem/9663
public class N9663_2 {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[0] = i;
            backtracking(arr, 1, N);
        }
        System.out.println(cnt);
    }

    private static void backtracking(int[] arr, int i, int N) {
        if (i == N) {
            cnt++;
            return;
        }
        for (int j = 0; j < N; j++) {
            arr[i] = j;
            if (canLayDownNextQueen(arr, i, j)) {
                backtracking(arr, i + 1, N);
            }
        }
    }

    private static boolean canLayDownNextQueen(int[] arr, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (arr[k] == j) return false;
            if (Math.abs(arr[k] - j) == Math.abs(k - i)) return false;
        }
        return true;
    }
}
