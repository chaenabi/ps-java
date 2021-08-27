package programmers.codingTestPractice.level2;

/**
 * 타겟 넘버
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 * created: 2021-08-11
 */

public class Prgs43165 {
    static int answer;

    public static int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private static void dfs(int[] numbers, int target, int idx, int sum) {
        if(idx == numbers.length) {
            if(sum == target) answer++;
            return;
        }
    //    sum += numbers[idx];
        dfs(numbers, target, idx + 1, sum + numbers[idx]);
   //     sum -= numbers[idx];
   //     sum -= numbers[idx];
        dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }

    public static void main(String[] args) {
                                        //   [0, 1, 2, 3, 4]
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
