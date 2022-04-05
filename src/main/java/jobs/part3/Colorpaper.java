package jobs.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Colorpaper {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(br.readLine()); // 색종이 장수
        int[][] arr = new int[n][n];
        int[][] base = new int[101][101];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // N 장의 색종이에 관한 입력이 한줄씩 주어짐
        }
        br.close();

        int max = Arrays.stream(arr)
                .map(ar -> Arrays.stream(ar).max().getAsInt())
                .max(Comparator.comparingInt(e -> e))
                .get();

        int inc = 1;

        for (int i = 0; i < n; i++) {
            int x1 = arr[i][0], y1 = arr[i][1], w = arr[i][2], h = arr[i][3];

            for (int x = x1; x < w + x1; x++) {
                for (int y = y1; y < h + y1; y++) {
                    base[x][y] = inc;
                }
            }

            ++inc;
        }

        for (int[] ar : base) {
            for (int a : ar) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

        inc = 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int y = 0; y < max; y++) {
                for (int x = 0; x < max; x++) {
                    if (base[y][x] == inc) {
                        count++;
                    }
                }
            }
            ++inc;
            System.out.println(count);
            count = 0;
        }

    }
}
