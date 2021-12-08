package baekjoon.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Bj2573Test {

    Bj2573 bj2573 = new Bj2573();

    @Test
    public void pubCase1() {
        int[][] map = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 2, 4, 5, 3, 0, 0},
                {0, 3, 0, 2, 5, 2, 0},
                {0, 7, 6, 2, 4, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        assertEquals(bj2573.solution(5, 7, map), 2);
    }

    @Test
    public void hidCase1() {
        int[][] map = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 9, 8, 9, 8, 9, 0},
                {0, 9, 8, 9, 8, 9, 0},
                {0, 9, 8, 9, 8, 9, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        assertEquals(bj2573.solution(5, 7, map), 2);
    }

}