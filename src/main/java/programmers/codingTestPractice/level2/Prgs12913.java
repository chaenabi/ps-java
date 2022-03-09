package programmers.codingTestPractice.level2;

public class Prgs12913 {
    int solution(int[][] land) {
        if (land.length == 0) return 0;
        int sum = 0, remember = 0, max = 0;

        for (int i = 0; i < land.length; i++) {
            for (int j = i + 1; j < land[i].length; j++) {
                max = Math.max(land[i][j], max);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Prgs12913().solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
    }
}
