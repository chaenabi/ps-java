package jobs.part8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TreeTraversal {

    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        tree = new int[n][2];

        while (n-- > 0) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            tree[arr[0]][0] = arr[1];
            tree[arr[0]][1] = arr[2];
        }
        br.close();

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    private static void preOrder(int node) {
        if (tree[node][0] == -1 && tree[node][1] == -1) System.out.print(node + " ");
        else {
            System.out.print(node + " ");
            if (tree[node][0] != -1) preOrder(tree[node][0]);
            if (tree[node][1] != -1) preOrder(tree[node][1]);
        }
    }

    private static void inOrder(int node) {
        if (tree[node][0] == -1 && tree[node][1] == -1) System.out.print(node + " ");
        else {
            if (tree[node][0] != -1) inOrder(tree[node][0]);
            System.out.print(node + " ");
            if (tree[node][1] != -1) inOrder(tree[node][1]);
        }
    }

    private static void postOrder(int node) {
        if (tree[node][0] == -1 && tree[node][1] == -1) System.out.print(node + " ");
        else {
            if (tree[node][0] != -1) postOrder(tree[node][0]);
            if (tree[node][1] != -1) postOrder(tree[node][1]);
            System.out.print(node + " ");
        }
    }
}
