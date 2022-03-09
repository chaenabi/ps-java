package programmers.codingTestPractice.level1;

import java.util.ArrayList;
import java.util.List;

public class Prgs77884 {
    public int solution(int left, int right) {

        List<Integer> list = new ArrayList<>();
        int answer = 0;

        for (int i = left; i <= right; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) list.add(j);
            }
            if (list.size() % 2 == 0) answer += i;
            else answer -= i;
            list.clear();
        }

        return answer;
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Prgs77884 prgs77884 = new Prgs77884();
        System.out.println(prgs77884.solution(13, 17));
        System.out.println(prgs77884.solution(24, 27));
    }
}
