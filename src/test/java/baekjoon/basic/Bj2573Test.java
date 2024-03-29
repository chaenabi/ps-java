package baekjoon.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class Bj2573Test {

    Bj2573 bj2573;

    @BeforeEach
    public void setup() {
        bj2573 = new Bj2573();
        System.out.println(bj2573);
    }

    @Test
    public void pubCase1() {
        int[][] map = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 2, 4, 5, 3, 0, 0},
                {0, 3, 0, 2, 5, 2, 0},
                {0, 7, 6, 2, 4, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        assertThat(bj2573.solution(5, 7, map)).isEqualTo(2);
    }

    @Test
    public void hidCase1() {
        int[][] map = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {0, 1, 9, 1, 9, 1, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
        };
        assertThat(bj2573.solution(7, 7, map)).isEqualTo(2);
    }
}