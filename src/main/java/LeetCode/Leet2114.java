package LeetCode;

import baekjoon.class1.WordCount;

public class Leet2114 {
    public int mostWordsFound(String[] sentences) {

        int max = 0;

        for (String sentence : sentences) {
            String[] arr = sentence.split(" ");
            if (max < arr.length) max = arr.length;
        }

        return max;
    }

    public int mostWordsFound2(String[] sentences) {
        int max = 0;

        for (String sentence : sentences) {
            int wordCount = 1;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    wordCount++;
                }
            }
            if (wordCount > max) max = wordCount;
        }

        return max == 0 ? 1 : max;
    }

    public static void main(String[] args) {

        System.out.println(new Leet2114()
                .mostWordsFound2(
                        new String[] {"alice and bob love leetcode",
                                "i think so too",
                                "this is great thanks very much"}));

    }
}
