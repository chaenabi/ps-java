package baekjoon.class1;

import java.io.*;
import java.util.Arrays;
// https://www.acmicpc.net/problem/10818
// 최소, 최대
public class MinMaxNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        String[] inputs = br.readLine().split(" ");
        br.close();
        if(inputs.length != n) return;
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(numbers);
        bw.write(numbers[0] + " ");
        bw.write(numbers[numbers.length-1] + "");
        bw.flush();
        bw.close();
    }
}
