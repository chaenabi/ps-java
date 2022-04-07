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

        for (int i = 0; i < n; i++) input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();



    }
}
