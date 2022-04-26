package jobs.part8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FromTreeDistance {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int x = arr[1];
        int y = arr[2];

        int[] parent = new int[n];
        int[] visitedX = new int[n];
        int[] visitedY = new int[n];

        Arrays.fill(visitedX, -1);
        Arrays.fill(visitedY, -1);
        for(int i = 0; i < n-1; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = edge[0];
            int b = edge[1];
            parent[b] = a;
        }
        br.close();

        int count = 0;

        // x의 조상
        while(true) {
            visitedX[x] = count++;
            if(x == 0) break;
            x = parent[x];
        }

        count = 0;
        // y의 조상
        while(true) {
            if(visitedX[y] != -1) {
                int sum = visitedX[y] + count;
                System.out.println(sum);
                break;
            } else {
                visitedY[y] = count++;
                if(y == 0) break;
                y = parent[y];
            }
        }
    }
}

