package programmers.codingTestPractice.level1;

public class Prgs68935 {

    public int solution(int n) {
        String answer = "";

        while (n > 0) {
            answer += (n % 3);
            n /= 3;
        }

        return Integer.parseInt(answer, 3);
    }

    public static void main(String[] args) {
        Prgs68935 prgs68935 = new Prgs68935();
        System.out.println(prgs68935.solution(45));
        System.out.println(prgs68935.solution(125));
    }


}
