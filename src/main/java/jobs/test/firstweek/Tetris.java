package jobs.test.firstweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tetris {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int col = input[0];
        int row = input[1];

        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        int[] isValidLocation = new int[col];
        for (int j = 0; j < col; j++) {
            int count = 0;
            int x = 0;
            for (int i = 0; i < row; i++) {
                if (map[i][j] == 0) {
                    count++;
                    x = i;
                }
                if (map[i][j] == 1) break;
            }
            if (count >= 4) {
                isValidLocation[j] = x;
            }
        }

        int[] result = new int[col];

        for (int j = 0; j < col; j++) {
            int x = isValidLocation[j];
            if (x > 0) {
                for(int k = 0; k < 4; k++) {
                    map[x - k][j] = 1;
                }

                int line = 0;
                for (int k = 0; k < row; k++) {
                    int rowCount = 0;
                    for (int p = 0; p < col; p++) {
                        if (map[k][p] == 1) ++rowCount;
                    }

                    if (rowCount == col) ++line;
                }

                result[j] = line;

                for (int k = 0; k < 4; k++) {
                    map[x - k][j] = 0;
                }
            }
        }

        int max = 0;
        int location = 0;
        for (int i = 1; i <= col; i++) {
            if (max < result[i - 1]) {
                location = i;
                max = result[i - 1];
            }
        }
        System.out.println(location + " " + max);
    }
}
