package jobs.part9;

import java.util.Scanner;

public class NumberOfCasesRectangleLocation {

    private static long[] m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = new long[n + 1];

        System.out.println(b(n));
    }

    private static long b(int n) {
        if (n == 0L || n == 1L) return 1L;
        if (m[n] != 0) return m[n];
        return m[n] = (b(n - 1) + b(n - 2)) % 1_000_007L;
    }
}
