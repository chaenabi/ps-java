package programmers.codingTestPractice.level2;

import java.math.BigInteger;
/**
 * 멀쩡한 사각형
 * https://programmers.co.kr/learn/courses/30/lessons/62048
 * created: 2021-08-11
 */

public class Prgs62048 {
    public static long solution(int w, int h) {
        BigInteger bw = new BigInteger(w + "");
        BigInteger bh = new BigInteger(h + "");
        return ((long) w * h) - (w + h - bw.gcd(bh).intValue());
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 12)); // 4
        System.out.println(solution(7, 14)); // 7
    }
}
