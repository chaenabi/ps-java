package baekjoon.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/10951
//A+B - 4
public class AplusB4 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try {
                String[] numbers = br.readLine().split(" ");
                if(numbers[0] == null || numbers[1] == null) break;
                int A = Integer.parseInt(numbers[0]);
                int B = Integer.parseInt(numbers[1]);
                if(A > 0 && B < 10) System.out.printf("%d\n", A+B);
            } catch (Exception e) {
                return;
            }
        }
        int[] arr = new int[10];
        int a = arr.length;
        System.out.println(a);
    }
}
