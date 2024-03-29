package jobs.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// n: 몇 번이나 질문했는가
// 각 줄마다 민혁이가 질문한 세 자리 수, 영수가 답한 스트라이크 갯수, 볼 갯수
/*
4
123 1 1
356 1 0
327 2 0
489 0 1
*/
// 영수가 생각하고 있을 가능성이 있는 답의 총 갯수
public class BaseballGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        int[][] input = new int[n][3];
        int result = 0;
        for (int i = 0; i < n; i++) input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i == j || j == k || i == k) continue;
                    boolean match = false;

                    for (int m = 0; m < n; m++) {

                        int h = input[m][0] / 100;
                        int t = (input[m][0] / 10) % 10;
                        int o = input[m][0] % 10;

                        int strike = 0, ball = 0;

                        if (h == i) strike++;
                        if (t == j) strike++;
                        if (o == k) strike++;
                        if (h == j || h == k) ball++;
                        if (t == i || t == k) ball++;
                        if (o == i || o == j) ball++;

                        if (input[m][1] != strike || input[m][2] != ball) match = true;
                    }
                    if (!match) result++;
                }
            }
        }

        System.out.println(result);

    }
}
