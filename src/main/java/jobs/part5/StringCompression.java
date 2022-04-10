package jobs.part5;

import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int slen = s.length();
        char next = s.charAt(0);
        String result = "";
        int cnt = -1;

        for (int i = 0; i < slen; i++) {
            ++cnt;
            if (next != s.charAt(i)) {
                if (cnt == 1) {
                    result += String.valueOf(next);
                } else {
                    result += cnt + String.valueOf(next);
                }
                next = s.charAt(i);
                if (i != slen - 1) cnt = 0;
            }
            if (i == slen - 1) {
                if (cnt == 1 && s.charAt(i) == s.charAt(i - 1)) {
                    result += (1 + cnt) + String.valueOf(next);
                    break;
                }
                if (s.charAt(i) != s.charAt(i - 1)) {
                    result += String.valueOf(next);
                }
                else {
                    result += (1 + cnt) + String.valueOf(next);
                }
            }
        }

        System.out.println(result);

        String c = Integer.toBinaryString(10);

    }

}
