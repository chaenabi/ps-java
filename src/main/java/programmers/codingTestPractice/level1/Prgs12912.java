package programmers.codingTestPractice.level1;

public class Prgs12912 {
    public long solution(int a, int b) {

        long answer = 0;
        int temp = 0;

        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }

        for (int i = a; i <= b; i++) {
            answer += i;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Prgs12912().solution(3, 5));
        System.out.println(new Prgs12912().solution(3, 3));
        System.out.println(new Prgs12912().solution(5, 3));
    }
}
