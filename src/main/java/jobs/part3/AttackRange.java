package jobs.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// n: 맵 크기 (n*n)
// 유닛이 설치될 위치 (x, y)(1~n사이의 자연수), 유닛의 사거리 r(n/2이하의 자연수)
public class AttackRange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int y = input[0] - 1, x = input[1] - 1, c = input[2];
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // (1) (i, j) ~ (y, x) 까지의 거리를 구함
                // (2) 이 거리가 c 안에 들어오는가?

                // (3, 4)  ~ (2, 6) --> 1 + 2 = 3
                int first = Math.abs(i - y); // 세로의 차
                int second = Math.abs(j - x); // 가로의 차

                int dist = first + second; // 거리

                if (dist == 0) arr[i][j] = -1;
                else if (dist <= c) arr[i][j] = dist;
            }
        }

        for (int[] ar: arr) {
            for (int a : ar) {
                if (a == -1) System.out.print("x ");
                else System.out.print(a + " ");
            }
            System.out.println();
        }


    }
}
