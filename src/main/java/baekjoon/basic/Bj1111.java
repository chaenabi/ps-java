package baekjoon.basic;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

import static baekjoon.basic.Bj1111.sc.close;
import static baekjoon.basic.Bj1111.sc.init;

public class Bj1111 {
    private static void solve() {
        // TODO: solve
        String s = sc.readLine();
        

    }

    public static void main(String[] args) throws IOException {
        init();
        solve();
        close();
    }

    static class sc {
        private static BufferedReader br;
        private static BufferedWriter bw;
        private static StringTokenizer st;
        private static StringBuilder sb;
        private static Deque<Integer> dq;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            st = new StringTokenizer("");
            sb = new StringBuilder("<");
            dq = new ArrayDeque<>();
        }

        static String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
            }
            return null;
        }

        static String readLineReplace() {
            try {
                return br.readLine().replaceAll("\\s+", "");
            } catch (IOException e) {
            }
            return null;
        }

        static String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        static long nextLong() {
            return Long.parseLong(next());
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static double nextDouble() {
            return Double.parseDouble(next());
        }

        static void close() throws IOException {
            br.close();
            bw.flush();
            bw.close();
        }
    }
}
