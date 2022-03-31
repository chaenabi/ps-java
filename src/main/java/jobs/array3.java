package jobs;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;
/*
N이 주어질 때, 다음과 같은 프로그램을 작성해보자.
입력

첫째 줄에 자연수 N이 주어진다.(1<=N<=100)


출력

예시를 참고하여 작성하자.

예제 입력

3

예제 출력

1 2 4
3 5
6

예제 입력

5

예제 출력

1 2 4 7 11
3 5 8 12
6 9 13
10 14
15

 */
public class array3 {

    private static void solution() throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int inc = 1;
        // (0, 0) (0, 1) (0, 2)
        // (1, 0) (1, 1)
        // (2, 0)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[j][i] = inc++;
            }
        }
        for (int[] ar : arr) {
            for (int a : ar) {
                if (a == 0) continue;
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

    @Test
    void pubcase1() {

    }
}
