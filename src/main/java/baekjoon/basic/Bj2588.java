package baekjoon.basic;

import java.util.Scanner;

public class Bj2588 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();
        sc.close();

        for (int i = second.length() - 1; i >= 0; i--) {
            System.out.println(Integer.parseInt(first) * Integer.parseInt(String.valueOf(second.charAt(i))));
        }
        System.out.println(Integer.parseInt(first) * Integer.parseInt(second));

    }

}
