package baekjoon.basic;

import java.util.Arrays;

public class Solution {

    enum Point {
        A('A', 5), B('B', 4), C('C', 3), D('D', 4), E('E', 5);
        private final char rank;
        private final int point;
        Point(char rank, int point) { this.rank = rank; this.point = point; }

        public static int calculatePoint(char rank) {
            return Arrays.stream(Point.values())
                    .filter(points -> points.hasValidRank(rank))
                    .findAny()
                    .map(p -> p.point)
                    .orElse(0);
        }

        public boolean hasValidRank(char rank) {
            return Arrays.stream(Point.values())
                    .anyMatch(e -> e.rank == rank);
        }
    }

    private int calculatePoint(String score) {
        int point = 0, countf = 0;
        char[] sc = score.toCharArray();

        for (char c : sc) {
            if (c == 'F' || ++countf >= 2) continue;
            point += Point.calculatePoint(c);
        }
        if (countf >= 2) return 0;
        return (point);
    }

    private int codingTest(double valuer, String[] scores) {
        int pass = 0;
        for (String score : scores) {
            if ((calculatePoint(score) / valuer) >= 3) {
                ++pass;
            }
        }
        return (pass);
    }

    public int solution(String[] scores) {
        return codingTest(scores[0].length(), scores);
    }

    public static void main(String[] args) {

        String[] case1 = {"AAFAFA", "FEECAA", "FABBCB", "CBEDEE", "CCCCCC"};
        String[] case2 = {"BCD","ABB","FEE"};

        int result = new Solution().solution(case1);
        System.out.println(result);

        int result2 = new Solution().solution(case2);
        System.out.println(result2);

    }

}
