package programmers.codingTestPractice.level1;

public class Prgs12928 {
    public int solution(int n) {
        int answer = n;
        int halfN = n / 2;
        while (halfN > 0) {
            int temp = n % halfN;
            if (temp == 0) {
                answer += halfN;
            }
            halfN--;
        }
        return answer;
    }
}
