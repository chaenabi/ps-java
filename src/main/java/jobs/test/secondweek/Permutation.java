package jobs.test.secondweek;

import java.util.Scanner;

public class Permutation {

    static char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 4
        int r = sc.nextInt(); // 2
        permutation(0, n, r);
    }

    static void permutation(int s, int n, int r) {
        if (s == r) {
            boolean flag = false;

            // 여기에 도달했다는것은, result안에 숫자가 다 채워졌다는 뜻이다.
            // 중복 체크 (aa, bb, cdda, dcad 이런거 제외)
            label: for (int i = 0; i < r; i++) {
                for (int j = 0; j < r; j++) {
                    if (i != j && alphabet[i] == alphabet[j]) {
                        flag = true;
                        break label;
                    }
                }
            }
            if (!flag) {
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < r; i++) {
                    str.append(alphabet[i]);
                }
                System.out.println(str);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            permutation(s + 1, n, r);
        }
    }
}
