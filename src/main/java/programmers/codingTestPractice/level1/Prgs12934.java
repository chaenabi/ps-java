package programmers.codingTestPractice.level1;

public class Prgs12934 {

    // n=4일때, x=2
    public long solution(long n) {
        double x = Math.sqrt((double) n);
        return n % x == 0.0 ? (long) ((x + 1) * (x + 1)) : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Prgs12934().solution(121));
        System.out.println(new Prgs12934().solution(3));
    }
}
