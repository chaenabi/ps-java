package jobs.test.secondweek;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        division(n);
    }

    static void division(int n) {
        if (n == 0) {
            
        }
        division(n - 1);
    }
}
