package jobs.part7;

import java.util.*;


/*
    (1) 스택의 가장 윗부분이 내가 지금 뽑아야 하는 알파벳이라면 pop
    (2) 그게 아니면 push
 */
public class Plate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] alpha = new char[26];
        int num = 0;

        String[] ans = new String[100];
        int temp = 0;

        for (char i = 'a'; i <= 'z'; i++) {
            alpha[num++] = i;
        }
        String st = sc.next();
        char[] arr = st.toCharArray();
        int top = 0;
        int idx = 0;
        while (top < arr.length && idx < alpha.length) {
            if (alpha[idx] == arr[top]) {
                ans[temp++] = "push";
                ans[temp++] = "pop";
                top++;
                idx++;
                if (idx >= 2 && top < arr.length) {
                    int x = idx - 2;
                    while (true) {
                        if (x >= 0 && top < arr.length) {
                            if (alpha[x] == arr[top]) {
                                ans[temp++] = "pop";
                                top++;
                                x--;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } else {
                ans[temp++] = "push";
                idx++;
            }
        }
        int cnt = 0;
        for (int i = 0; i < temp; i++) {
            if (Objects.equals(ans[i], "pop")) {
                cnt++;
            }
        }
        if (cnt != arr.length) {
            System.out.println("impossible");
        } else {
            for (int i = 0; i < temp; i++) {
                System.out.println(ans[i]);
            }
        }
    }
}
