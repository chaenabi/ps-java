package jobs.part10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WormVirus {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 10
        int m = sc.nextInt(); // 7
        int[][] edge = new int[n + 1][n + 1];

        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edge[a][b] = edge[b][a] = 1;
        }

        bfs(n, edge, new boolean[n + 1]);
    }

    private static void bfs(int totalEdge, int[][] arr, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int count = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            visited[v] = true;

            for (int i = 1; i <= totalEdge; i++) {
                if (arr[v][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        System.out.println(count);

    }

}
