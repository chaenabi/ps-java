package baekjoon.basic;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * 오큰수
 * https://www.acmicpc.net/problem/17298
 */
public class Bj17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int count = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");
        int[] nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        // 3 5 2 7
        List<Integer> result = new ArrayList<>();
        stack.push(nums[0]);

        for (int i = 1; i < count;) {

            while (!stack.empty()) {
                if (stack.peek() < nums[i]) {
                    result.add(nums[i]);
                    stack.pop();
                } else if (stack.peek() > nums[i]) {
                    stack.push(nums[i++]);
                }
            }
            stack.push(nums[i]);
        }

        result.forEach(e -> System.out.println(e + " "));
    }
}
