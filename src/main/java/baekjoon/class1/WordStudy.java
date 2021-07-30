package baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1157
// 단어 공부
public class WordStudy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");
        Integer[] result = Arrays.stream(words).map(Integer::parseInt).toArray(Integer[]::new);
        if(result[0] < result[1]) System.out.println("<");
        else if(words[0].equals(words[1])) System.out.println("==");
        else System.out.println(">");
    }
}
