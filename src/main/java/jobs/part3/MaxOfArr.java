package jobs.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxOfArr {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int[][] arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // N 장의 색종이에 관한 입력이 한줄씩 주어짐
        }

        int max = 0, y = 0, x = 0;
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    y = i;
                    x = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((y+1) + " " + (x+1));
    }
}
