package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 조아나와 홀수
 * http://220.89.64.243/30stair/joana/joana.php?pname=joana
 */
public class dl_joana {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        System.out.println(n * n); // 입력값에 해당하는 줄의 마지막 숫자가 몇번째 순번(4, 9, 16, 25 등)에 있는지 알아낸다.
        long temp = n * n;
        System.out.println(((temp + 2 * n - 1) / 2) + ((temp + 2 * n - 1) / 2) - 2 + (temp + 2 * n - 1) / 2 - 4);

    }

    //1                  1                //  1
    //2               3  5  7             //  3
    //3            9 11 13 15 17          //  5
    //4        19 21 23 25 27 29 31       //  7
    //5     33 35 37 39 41 43 45 47 49    //  9
    //6  51 53 55 57 59 61 63 65 67 69 71 //  11
    //  ...

    //1                       1                                       // 1
    //2                   2   3   4    ->    1 + 3                    // 3  (1+3) = 4
    //3               5   6   7   8   9    ->    4 + 5                // 5  (1+3+5) = 9
    //4          10  11  12  13  14  15  16    ->    9 + 7            // 7  (1+3+5+7) = 16
    //5      17  18   19  20  21  22  23  24  25  ->     16 + 9        // 9  (1+3+5+7+9) = 25
    //6  26  27  28   29  30  31  32  33  34  35  36  ->    25 + 11    // 11 (1+3+5+7+9+11) = 36 ... +13 = 49

}
