package baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1920 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        StringTokenizer st = new StringTokenizer(numbers, " ");
        int[] arr = new int[count];

        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }

        //Arrays.sort(arr);

        count = Integer.parseInt(br.readLine());
        numbers = br.readLine();
        st = new StringTokenizer(numbers, " ");

        int[] comarr = new int[count];

        i = 0;
        while (st.hasMoreTokens()) {
            comarr[i++] = Integer.parseInt(st.nextToken());
        }

        //          arr       comarr
        // 로직 (4 1 5 2 3) (1 3 7 9 5)
        for (i = 0; i < count; i++) {
            recur(arr, 0, comarr[i]);
        }
    }

    private static void recur(int[] arr, int i, int findNumber) {
        if (i == arr.length) {
            System.out.println(0);
            return;
        }

        if (arr[i] == findNumber) {
            System.out.println(1);
            return;
        }

        recur(arr, i + 1, findNumber);
    }

}
