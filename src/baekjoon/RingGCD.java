package baekjoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/3036
public class RingGCD {


        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt(), r;
            int firstCircle = sc.nextInt();

            for(int i = 1; i < N; i++) {

                int nextCircle = sc.nextInt();
                r = gcd(firstCircle, nextCircle); // 최대 공약수 구하기 !

                System.out.println( firstCircle/r + "/" + nextCircle/r );
            }

        }

        private static int gcd(int a, int b) {
            if(b == 0) return a;
            return gcd(b, a%b);
        }




}
