package baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1152
// 단어의 갯수
public class WordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");
        int cnt = words.length;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals("")) cnt--;
        }
        System.out.println(cnt);
    }
}
