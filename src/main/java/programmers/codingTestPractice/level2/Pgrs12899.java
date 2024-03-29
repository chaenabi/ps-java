package programmers.codingTestPractice.level2;

/**
 * 124 나라의 숫자
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 * 2021-08-02
 */
public class Pgrs12899 {

    public String solution(int n) {
        String answer = "";
        String[] notation = new String[]{"1", "2", "4"};

        while (n > 0) {
            int j = --n % 3;
            n /= 3;
            answer = notation[j] + answer;
        }
        return answer;
    }
}

/*
    1 -> 1      1 -> 1     v
    2 -> 2      2 -> 2     v
    3 -> 4      3 -> 10       3 % 3 == 0
    4 ->  11    4 -> 11    v
    5 ->  12    5 -> 12    v
    6 ->  14    6 -> 20       3 % 6 == 0
    7 ->  21    7 -> 21    v
    8 ->  22    8 -> 22    v
    9 ->  24    9 -> 100     3 % 9 == 0
    10 -> 41    10 -> 101  v
    11 -> 42    11 -> 102  v
    12 -> 44    12 -> 110     3 % 12 == 0
    13 -> 111   13 -> 111  v
    14 -> 112   14 -> 112  v
    15 -> 124   15 -> 120     3 %  15 == 0
    16 -> 141   16 -> 121
    17 -> 142   17 -> 122
    18 -> 144   18 -> 200
    19 -> 211   19 -> 201
    20 -> 212   20 -> 202
    21 -> 214   21 -> 210
    22 -> 221   22 -> 211
    23 -> 222   23 -> 212
    24 -> 224   24 -> 220
    25 -> 241   25 -> 221
    26 -> 242   26 -> 222
    27 -> 244   27 -> 1000
    28 -> 411   28 -> 1001
    29 -> 412   29 -> 1002
    30 -> 414   30 -> 1010
 */

// 1 3 9