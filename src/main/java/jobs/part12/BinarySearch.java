package jobs.part12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        // 1 2 4 8 10 11 12 14 15 19
        int[] narr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 4 5 8 17
        int[] qarr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int qarrlen = qarr.length;

        for (int i = 0; i < qarrlen; i++) {
            System.out.println(recur(narr, qarr, i, (narr.length / 2)));
        }

    }

    private static String recur(int[] narr, int[] qarr, int q, int len) {
        if (narr[len] > qarr[q]) return recur(narr, qarr, q, len - (len / 2));
        else if (narr[len] < qarr[q]) return recur(narr, qarr, q, len + (len / 2));
        return "";
    }

}
