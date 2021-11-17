package baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 단어 뒤집기
 * www.acmicpc.net/problem/9093
 * 2021-11-15
 */
public class Bj9093 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> tokens = new LinkedList<>();
        int count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            tokens.offer(br.readLine());
        }
        br.close();

        while (!tokens.isEmpty()) {
            String[] strings = tokens.poll().split(" "); // [I, am, happy, today]
            List<String> list = new ArrayList<>();
            int size = strings.length; // total strings.len (4)
            for (int i = 0; i < size; i++) {
                if (strings[i].length() == 1) {
                    list.add(strings[i]);
                } else {
                    list.add(swap(strings[i]));
                }
            }

            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }

    private static String swap(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }

        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }

        return String.valueOf(chars);
    }
}





