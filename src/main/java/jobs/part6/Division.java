package jobs.part6;

import java.util.Scanner;

public class Division {

    static int cnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        divide(n, 0, 0, new int[21]);
        System.out.println(cnt);
    }

    // index:  [0]   [1]   [2]   [3]   [4]   [5]
    // value:   3     2     1     x     x     x
    private static void divide(int n, int curSum, int index, int[] result) {
        // 현재까지 구한 합이 curSum이다.
        // 그리고 지금, index번째 숫자를 결정할 차례. 즉, result[index]
        if (curSum == n) {
            if (result[0] == n) return;
            System.out.print(result[0]);
            for (int i = 1; i < index; i++) {
                System.out.print("+" + result[i]);
            }
            System.out.println();
            cnt++;
        } else {
            int curNum = n - curSum;

            for (int i = curNum; i >= 1; i--) {
                result[index] = i;
                // 배열에 1 + 2 이런식으로, 못들어오게 하기 위함. 다시 말해 2 + 1은 되어도 1 + 2는 되어서는 안된다.
                if (index > 0 && result[index - 1] < result[index]) continue;
                divide(n, curSum + i, index + 1, result);
            }
        }
    }
}
