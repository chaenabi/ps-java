package baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2475
// 검증수
public class ValidateNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] number = br.readLine().split(" ");
        Integer[] result = Arrays.stream(number).map(Integer::parseInt).toArray(Integer[]::new);
        int hap = 0;
        for(int i = 0; i < result.length; i++) {
            hap += result[i] * result[i];
        }
        int validatedNumber = hap % 10;
        System.out.println(validatedNumber);
    }
}