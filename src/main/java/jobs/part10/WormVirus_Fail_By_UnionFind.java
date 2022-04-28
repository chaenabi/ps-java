package jobs.part10;

import java.util.Arrays;
import java.util.Scanner;
/*

10
7
1 2
2 3
3 4
5 6
7 8
8 9
9 1

expected: 6
actual: 4

 */

public class WormVirus_Fail_By_UnionFind {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UnionFind uf = new UnionFind();

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] edge = new int[m + 1][2];

        for (int i = 0; i < m; i++) {
            edge[i][0] = sc.nextInt();
            edge[i][1] = sc.nextInt();
        }

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int[] array : edge) {
            if (!uf.isSameUnion(arr, array[0], array[1])) {
                uf.union(arr, array[0], array[1]);
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.stream(arr).filter(e -> e == 1).count() - 1);
    }
}

class UnionFind {

    int find(int[] arr, int a) {
        if (arr[a] == a) return a;
        return arr[a] = find(arr, arr[a]);
    }

    void union(int[] arr, int a, int b) {
        a = find(arr, a);
        b = find(arr, b);

        if (a < b) arr[b] = a;
        else arr[a] = b;
    }

    boolean isSameUnion(int[] arr, int a, int b) {
        a = find(arr, a);
        b = find(arr, b);
        return a == b;
    }
}

