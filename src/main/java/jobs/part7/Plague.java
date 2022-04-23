package jobs.part7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Plague {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList();

        queue.add(m);
        visited[m] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            count++;
            int div = temp / 3;
            int mul = temp * 2;

            if (div > 0 && div <= n && !visited[div]) {
                queue.add(div);
                visited[div] = true;
            }
            if (mul > 0 && mul <= n && !visited[mul]) {
                queue.add(mul);
                visited[mul] = true;
            }
        }
        System.out.print(n - count);
    }
}
