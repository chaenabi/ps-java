package baekjoon.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1799
// 비숍
public class Bishop {
    public static void main(String[] args) throws IOException {
        solution();
    }
    private static int cnt = 0;
    private static int[] col;
    private static int size;
    private static String[][] info;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        info = new String[size+1][size+1];
        // init by input
        for(int i = 1; i <= size; i++) {
            String[] arr = br.readLine().split(" ");
            info[i] = arr;
        }

        for(int i = 1; i <= size; i++) {
            col = new int[size+1];
            col[1] = i;
            dfs(1);
        }
    }

    private static void dfs(int row) {
        if(row == size) {
            cnt++;
        } else {
            for(int i = 1; i < size; i++) {
                if(info[i][row - 1].equals("1")) {
                    col[row + 1] = i;
                }
            }
        }
    }

}
