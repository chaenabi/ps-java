package jobs.part10;

import java.util.Arrays;
import java.util.Scanner;

public class Bipartite {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        int[] graph = new int[vertex + 1];

        while (edge-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a] = b;
            graph[b] = a;
        }
        System.out.println("[0, 1, 2, 3, 4, 5, 6]");
        System.out.println(Arrays.toString(graph));

    }
}
