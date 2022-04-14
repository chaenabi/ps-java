package jobs.part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StackImpl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        MyStack stack = new MyStack(firstLine[0]);
        while (firstLine[1]-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            switch (input[0]) {
                case 1:
                    stack.add(input[1]);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
            }
        }
    }

    // 1: push,
    // 2: pop
    // 3: top -> peek print
    static class MyStack {
        int[] arr;
        int index;
        int top;

        public MyStack(int size) {
            arr = new int[size];
            index = -1;
        }

        public void add(int n) {
            ++index;
            if (index >= arr.length) {
                System.out.println("Overflow");
            } else {

                arr[index] = n;
                top = n;
            }
        }

        public void pop() {
            if (index <= -1) {
                System.out.println("Underflow");
            } else {
                if (index < arr.length) {
                    arr[index] = -1;
                    --index;
                    top = index >= 0 ? arr[index] : -1;
                }
            }
        }

        public void peek() {
            if (index == -1) System.out.println("NULL");
            else System.out.println(top);
        }
    }
}
