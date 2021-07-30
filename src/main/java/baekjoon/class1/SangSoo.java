package baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// https://www.acmicpc.net/problem/2908
// 상수
public class SangSoo {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] characters = br.readLine().split(" ");
        String[] reversed = new String[characters.length];
        for(int i = 0; i < characters.length; i++) {
            reversed[i] = reverse(characters[i]);
        }
        String[] result = Arrays.stream(reversed).sorted(Collections.reverseOrder()).toArray(String[]::new);
        System.out.println(result[0]);
    }

    public static String reverse(String s) {
        return ( new StringBuffer(s) ).reverse().toString();
    }

}
