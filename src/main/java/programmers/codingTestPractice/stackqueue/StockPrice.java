package programmers.codingTestPractice.stackqueue;

// 42584 주식가격
public class StockPrice {

    public static void main(String[] args) {
        int[] result = new StockPrice().solution(new int[]{1, 2, 3, 2, 1});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    // 1, 2, 3, 2, 1    -->      4,  3,  2,  1,  0
    // 5, 4, 3, 2, 1    -->      1,  1,  1,  1,  0
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int i, k;
        for (i = 0; i < len; i++) { // 배열 순회
            for (k = i + 1; k < len; k++) {
                if (prices[i] > prices[k]) {
                    answer[i] = k - i;
                    break;
                }
                if (k == len - 1) {
                    answer[i] = k - i;
                }
            }
        }
        return answer;
    }

}
