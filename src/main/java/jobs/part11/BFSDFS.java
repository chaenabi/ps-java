package jobs.part11;

import java.util.Scanner;

public class BFSDFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] vertex = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            vertex[a][b] = a;
            vertex[b][a] = b;
        }
        sc.close();

        visited = new boolean[n][n];
    }
}

/*
            0   1   2   3   4   5   6   7   8   9
           ___________________________________________
       0  |     0   0   0
       1  | 1                   1
       2  | 2                   2
       3  | 3
       4  |
       5  |    5   2
       6  |
       7  |
       8  |
       9  |



 */
