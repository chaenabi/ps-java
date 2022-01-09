package baekjoon.basic;

import java.io.*;

public class Bj1834 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(n * ~-n * -~n / 2);
    }
}
