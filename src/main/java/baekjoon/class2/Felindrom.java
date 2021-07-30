package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1259
// 펠린드롬수
public class Felindrom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String text = br.readLine();
            if(text.equals("0")) break;
            String[] arr = text.split("");
            int len = text.length();
            for(int i = 0; i < len / 2; i++) {
                String temp = arr[i];
                arr[i] = arr[len - i - 1];
                arr[len - i - 1] = temp;
            }
            String reversed = String.join("", arr);
            if(text.equals(reversed)) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
