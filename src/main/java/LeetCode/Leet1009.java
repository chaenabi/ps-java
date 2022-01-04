package LeetCode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Complement of Base 10 Integer
 * https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class Leet1009 {

    public int bitwiseComplement(int n) {
        char[] bits = Integer.toBinaryString(n).toCharArray();

        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == '1') bits[i] = '0';
            else if (bits[i] == '0') bits[i] = '1';
        }

        return Integer.parseInt(new String(bits), 2);
    }


    public static void main(String[] args) {
        System.out.println(new Leet1009().bitwiseComplement(5));
        System.out.println(new Leet1009().bitwiseComplement(7));
        System.out.println(new Leet1009().bitwiseComplement(10));
    }
}


