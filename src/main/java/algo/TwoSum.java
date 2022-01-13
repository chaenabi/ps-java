package algo;

import java.util.*;

public class TwoSum {


    private void hash() {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 100};
        Set<Integer> set = new HashSet<>();
        boolean flag = false;
        for (int ar : arr) {
            int temp = target - ar;
            if (!set.contains(temp)) {
                set.add(ar);
            } else {
                flag = true;
                break;
            }
        }
        if (flag) System.out.println(flag);
        else System.out.println(flag);
    }

    private void aaa() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int target = 10;
        boolean flag = false;

        label: for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                if (arr[i] + arr[j] == target) {
                    flag = true;
                    break label;
                }
            }
        }

        if (flag) System.out.println(flag);
        else System.out.println(flag);
    }

    public static void main(String[] args) {
        new TwoSum().min();
    }

    private void min() {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int rand = random.nextInt(100);
            stack.push(rand);
            if (minStack.isEmpty()) {
                minStack.push(rand);
            }
            if (minStack.peek() >= rand) {
                if (!(minStack.peek() == rand)) minStack.push(rand);
            }
            if (i >= rand) {
                if (minStack.peek().equals(stack.pop())) {
                    minStack.pop();
                }
            }
        }

        for (int min : minStack) {
            System.out.print(min + " ");
        }
    }
}
