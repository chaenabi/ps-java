package programmers.codingTestPractice.level1;

public class Prgs12943 {
    public int solution(int num) {

        int answer = 0;

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 2 == 1) {
                num = num * 3 + 1;
            }
            answer++;
            if (answer == 500) {
                return -1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Prgs12943().solution(6));
        System.out.println(new Prgs12943().solution(16));
        System.out.println(new Prgs12943().solution(626331));

    }
}
