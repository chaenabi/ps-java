package baekjoon.basic;

public class Solution2 {

    public int solution(int[][] needs, int r) {

        for (int[] material : needs) {
            int count = 0;

            for (int element : material) {
                if (element == 1) count++;
            }
            if (count == r) {

            }

        }


        int answer = 0;
        return answer;
    }


    public static void main(String[] args) {
        int[][] case1 = {{ 1, 0, 0 }, // 0
                         { 1, 1, 0 }, // 0, 1
                         { 1, 1, 0 }, // 0, 1
                         { 1, 0, 1 }, // 0, 2
                         { 1, 1, 0 }, // 0, 1
                         { 0, 1, 1 }}; // 1, 2 <- (가로길이 부품번호)
                        // 세로길이 (완제품의 번호. 0행->0번 완제품, 1행 -> 1번 완제품)

        int result = new Solution2().solution(case1, 2);
        System.out.println(result);


        /*

        0번 로봇: 3
        1번 로봇: 4
        2번 로봇: 3
        3번 로봇: 3
        4번 로봇: 3

        1, 0, 0, 0, 1  // 0, 4
        0, 1, 1, 1, 0  // 1, 2, 3
        1, 1, 1, 1, 1  // 0, 1, 2, 3, 4
        0, 1, 0, 1, 0  // 1, 3
        1, 1, 1, 0, 1  // 0, 1, 2, 4

         */
    }
}
