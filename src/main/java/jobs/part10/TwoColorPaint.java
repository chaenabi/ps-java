package jobs.part10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TwoColorPaint {

    static boolean isPossible = true;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] ss = new int[2][];

        int[][] edge = new int[n][];

        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edge[a][b] = edge[b][a] = 1;
        }
        bfs(n, edge, new int[n]);
        if (isPossible) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void bfs(int totalEdge, int[][] graph, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 0; i < totalEdge; i++) {
                if (graph[x][i] == 1 && visited[i] == 0) {
                    queue.offer(i);
                    if (visited[x] == -1) visited[i] = 1;
                    else if (visited[x] == 1) visited[i] = -1;
                }

                if (graph[x][i] == 1 && visited[i] != 0 && visited[i] == visited[x]) {
                    isPossible = false;
                    return;
                }
            }
        }
    }
}
