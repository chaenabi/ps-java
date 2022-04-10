package jobs.part4;

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

        /*
        테트리미노를 놓을 수 있는 위치를 판단하는 코드
        - 가장 위에서부터 막대기가 내려오기 때문에 위에서부터 0인 갯수를 카운트
        - 카운트한 갯수가 테트리미노의 사이즈(4)보다 클 경우 해당 자리에 테트리미노를 놓을 수 있다고 판단

        isValidLocation[4] = 7 라는 뜻은, (7, 4) 부터 막대기를 채울 수 있다는 뜻
        isValidLocation[5] = 4 라는 뜻은, (4, 5) 부터 막대기를 채울 수 있다는 뜻
         */
        int[] isValidLocation = new int[col];
        for (int j = 0; j < col; j++) {
            int count = 0;
            int x = 0; // 테트리미노를 놓을 수 있는 행의 위치를 담는 변수
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
            if(x > 0) {
                // 테트리미노 채우기
                for(int k = 0; k < 4; k++) {
                    map[x - k][j] = 1;
                }

                // 매워지는 수평선 검사
                int line = 0;
                for (int k = 0; k < row; k++) {
                    int rowCount = 0;
                    for (int p = 0; p < col; p++) {
                        if(map[k][p] == 1) rowCount++;
                    }
                    // 한 행이 모두 1일 경우 삭제가 가능하다고 판단
                    if(rowCount == col) line++;
                }
                // result[4] = 3 이라는 뜻은 4열에 테트리미노를 놓았을 때 삭제 되는 개수
                // result[5] = 0 이라는 뜻은 5열에 테트리미노를 놓았을 때 삭제 되는 개수
                result[j] = line;

                // 테트리미노 삭제 (원상 복구)
                for (int k = 0; k < 4; k++) {
                    map[x - k][j] = 0;
                }
            }
        }

        int max = 0;
        int location = 0;
        for (int i = 0; i < col; i++) {
            if(max < result[i]) {
                location = i;
                max = result[i];
            }
        }
        System.out.println((location + 1) + " " + max);
    }
}
