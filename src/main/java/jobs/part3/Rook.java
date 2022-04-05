package jobs.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1: 알랩이의 킹
// 0: 비어있음
// 2: 룩 (최대 2개)
// 3: 다른 기물들
public class Rook {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int[][] arr = new int[8][8];

        for (int i = 0; i < 8; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // N 장의 색종이에 관한 입력이 한줄씩 주어짐
        }
        br.close();
        boolean isPossible = false;

        label: for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (arr[i][j] == 2) {
                    int up = j, down = j, left = j, right = j;
                    while (up >= 0) {
                        if (arr[i][up] == 1) {
                            isPossible = true;
                            break label;
                        }
                        if (arr[i][up] == 3) {
                            break;
                        }
                        --up;
                    }

                    while (down <= 7) {
                        if (arr[i][down] == 1) {
                            isPossible = true;
                            break label;
                        }
                        if (arr[i][down] == 3) {
                            break;
                        }
                        ++down;
                    }

                    while (left <= 0) {
                        if (arr[i][left] == 1) {
                            isPossible = true;
                            break label;
                        }
                        if (arr[i][left] == 3) {
                            break;
                        }
                        --left;
                    }

                    while (right <= 7) {
                        if (arr[i][right] == 1) {
                            isPossible = true;
                            break label;
                        }
                        if (arr[i][right] == 3) {
                            break;
                        }
                        ++right;
                    }
                }
            }
        }

        if (isPossible) System.out.println(1);
        else System.out.println(0);
    }
}
