package programmers.codingTestPractice.level1;

public class Prgs82612 {
    public long solution(int price, int money, int count) {
        int p = price;

        for (int i = 1; i <= count; i++) {
            price = p * i;
            if (price < money) {
                money -= price;
            }
        }
        return Math.min(money - price, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Prgs82612().solution(3,20,4));
    }
}
