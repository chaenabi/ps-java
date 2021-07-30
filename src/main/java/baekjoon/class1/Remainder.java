package baekjoon.class1;

import java.util.Arrays;
import java.util.Scanner;

//  https://www.acmicpc.net/problem/3052
// 나머지
public class Remainder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] calculated = new int[10];
        for (int i = 0; i < 10; i++) {
            calculated[i] = sc.nextInt() % 42;
        }
        int cnt = 0;
        Arrays.sort(calculated);
        for (int i = 1; i < calculated.length; i++) {
            if (calculated[i] != calculated[i-1]) {
                ++cnt;
            }
        }
        System.out.println(cnt+1);

    }

}
