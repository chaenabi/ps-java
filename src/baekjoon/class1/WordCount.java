package baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1152
// 단어의 갯수
public class WordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");
        int cnt = words.length;
        for (String word : words) {
            if (word.equals("")) cnt--;
        }
        System.out.println(cnt);
    }
}
