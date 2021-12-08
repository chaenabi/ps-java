package baekjoon.basic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Bj2573Test {

    Bj2573 bj2573 = new Bj2573();

    @Test
    public void case1() {
        assertThat(bj2573.solution(5, 7,
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 3, 3, 2, 3, 3, 0},
                        {0, 4, 0, 4, 0, 3, 0},
                        {0, 0, 0, 0, 4, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0}}
                )).isEqualTo(0);
    }
}