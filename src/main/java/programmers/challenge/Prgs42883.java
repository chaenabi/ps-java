package programmers.challenge;

import java.util.ArrayList;
import java.util.List;

public class Prgs42883 {
    public String solution(String number, int k) {

        char[] splited = number.toCharArray();
        int nLen = number.length();
        int max, index = 0;
        String result = "";

        for (int i = 0; i < nLen - k; i++) {
            max = 0;
            for (int j = index; j <= k + i; j++) {
                if (max < splited[j] - '0') {
                    max = splited[j] - '0';
                    index = j + 1;
                }
            }
            result += max;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Prgs42883().solution("1924", 2));
        System.out.println(new Prgs42883().solution("1231234", 3));
        System.out.println(new Prgs42883().solution("4177252841", 4));

    }
}
