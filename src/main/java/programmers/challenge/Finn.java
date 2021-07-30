package programmers.challenge;


import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Finn {
    public static void main(String[] args) {
        int result = new Finn().solution(5, new int[]{1, 2, 5});
        System.out.println(result);
    }

    public int solution(int n, int[] money) {
        int answer = 0;

        long [] dp = new long[n+1];

        for(int i=0; i<=n; i++){
            dp[i] = (i % money[0] == 0) ? 1 : 0;
        }

        for(int i=1; i<money.length; i++){
            for(int j=money[i]; j<=n; j++){
                dp[j] += dp[j-money[i]];
            }
        }
        answer = (int)(dp[n] % 1000000007);
        return answer;
    }
}
