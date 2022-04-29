package jobs.part12;

import java.util.Scanner;

public class CountingNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] count = new int[n + 1];

        while (n-- > 0) count[sc.nextInt()]++;
        while (q-- > 0) System.out.println(count[sc.nextInt()]);

    }

}
