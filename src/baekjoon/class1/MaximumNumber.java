package baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.acmicpc.net/problem/2562
// 최댓값
public class MaximumNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        List<Integer> sortedlist = new ArrayList<>(list);
        Collections.sort(sortedlist);
        int max = sortedlist.get(sortedlist.size()-1); // 정렬된 리스트의 가장 마지막 요소는 max 값이다. (9)
        System.out.println(max);
        System.out.println(list.indexOf(max) + 1);
    }
}
/*
9
8
7
6
5
4
3
2
1
 */