package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
문제

5x5 2차원 배열이 주어질 때 어떤 원소가 상하좌우에 있는 원소보다 작을 때 해당 위치에 * 을 표시하는 프로그램을 작성하시오. 경계선에 있는 수는 상하좌우 중 존재하는 원소만을 비교한다.


입력

5x5 행렬의 정보가 25 개의 수로 주어진다. 각 수는 0 에서 9 사이 수이다.


출력

*를 포함한 행렬을 출력예의 형식으로 출력한다.


예제 입력

3 4 1 4 9
2 9 4 5 8
9 0 8 2 1
7 0 2 8 4
2 7 2 1 4

예제 출력

3 4 * 4 9
* 9 4 5 8
9 0 8 2 *
7 0 2 8 4
* 7 2 * 4


 */
public class Offset {

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 5;
        int[][] arr = new int[n][n];
        int[][] clone = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i] = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            clone[i] = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        }
        br.close();


        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {

                for (int i = 0; i < 4; i++) {
                    int xx = dx[i] + x;
                    int yy = dy[i] + y;
                    if (!(0 <= xx && xx < n && 0 <= yy && yy < n)) {
                        if (i == 3) clone[y][x] = -1;
                        continue;
                    }
                    if (arr[yy][xx] <= arr[y][x]) break;
                    if (i == 3) clone[y][x] = -1;
                }
            }
        }

        for (int[] ar : clone) {
            for (int a : ar) {
                if (a == -1) System.out.print("* ");
                else System.out.print(a + " ");
            }
            System.out.println();
        }
    }

}
