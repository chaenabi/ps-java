package programmers.codingTestPractice.level1;

import java.util.Arrays;

public class Prgs12982 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int sum = 0, count = 0, remain = budget;
        for (int i : d) {
            if (budget >= sum && remain >= i) {
                sum += i;
                remain -= i;
                count++;
            } else break;
        }
        return count;
    }

    public static void main(String[] args) {
        Prgs12982 prgs12982 = new Prgs12982();
        System.out.println(prgs12982.solution(new int[]{1,3,2,5,4}, 9));
        System.out.println(prgs12982.solution(new int[]{2,2,3,3}, 10));
    }
}
