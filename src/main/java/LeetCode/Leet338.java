package LeetCode;

import java.util.Arrays;

/**
 * Counting Bits
 * https://leetcode.com/problems/counting-bits/
 */
public class Leet338 {

    public int[] countBits(int n) {
        int n1 = 0;

        while (n-- > 0) {
            String bn = Integer.toBinaryString(n);
            n1 += Integer.parseInt(bn);
            System.out.println(n1);
        }

        String s = String.valueOf(n1);
        String[] temp = s.split("");

        return Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Leet338().countBits(5)));
    }
}
