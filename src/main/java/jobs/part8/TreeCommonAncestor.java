package jobs.part8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TreeCommonAncestor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int x = arr[1];
        int y = arr[2];

        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = edge[0];
            int b = edge[1];
            parent[b] = a;
        }
        br.close();

        // x의 조상
        while (true) {
            visited[x] = true;
            if (x == 0) break;
            x = parent[x];
        }

        // y의 조상
        while (true) {
            if (visited[y]) {
                System.out.println(y);
                break;
            } else {
                visited[y] = true;
                y = parent[y];
            }
        }
    }
}
