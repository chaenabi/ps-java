package baekjoon.basic;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 일곱 난쟁이
 * https://www.acmicpc.net/problem/2309
 */
public class Bj2309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] shorts = Stream.generate(() -> {
            try {
                return br.readLine().split("\n");
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        })
                .limit(9)
                .flatMapToInt(e -> Arrays.stream(e)
                            .mapToInt(Integer::parseInt)
                )
                .sorted()
                .toArray();
        br.close();

        int sum = 0;
        for (int s : shorts) {
            sum += s;
        }

        int shortsLen = shorts.length;

        for (int i = 0; i < shortsLen; i++) {
            for (int j = i + 1; j < shortsLen; j++) {
                if ((sum - shorts[i] - shorts[j]) == 100) {
                    for (int k = 0; k < shortsLen; k++) {
                        if (k == i || k == j) continue;
                        bw.write(shorts[k] + "\n");
                    }
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
    }
}
