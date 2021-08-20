package programmers.codingTestPractice.level2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class Prgs42586Test {

    Prgs42586 prgs42586 = new Prgs42586();

    @Test
    public void pubcase1() {
        assertArrayEquals(new int[]{2, 1},
                        prgs42586.solution(new int[]{93, 30, 55},
                                            new int[]{1, 30, 5}));
    }

    @Test
    public void pubcase2() {
        assertArrayEquals(new int[]{1, 3, 2},
                            prgs42586.solution(new int[]{95, 90, 99, 99, 80, 99},
                                                new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void hidcase1() {
        assertArrayEquals(new int[]{3, 3},
                        prgs42586.solution(new int[]{20, 99, 93, 30, 55, 10},
                                            new int[]{5, 10, 1, 1, 30, 5}));
    }

    @Test
    public void hidcase2() {
        assertArrayEquals(new int[]{4},
                prgs42586.solution(new int[]{96, 99, 98, 97},
                        new int[]{1, 1, 1, 1}));
    }

    @Test
    public void hidcase3() {
        assertArrayEquals(new int[]{1, 2, 3},
                prgs42586.solution(new int[]{40, 93, 30, 55, 60, 65},
                        new int[]{60, 1, 30, 5, 10, 7}));
    }

    @Test
    public void hidcase4() {
        assertArrayEquals(new int[]{2, 4},
                prgs42586.solution(new int[]{93, 30, 55, 60, 40, 65},
                        new int[]{1, 30, 5, 10, 60, 7}));
    }

    @Test
    public void hidcase5() {
        assertArrayEquals(new int[]{2, 2},
                prgs42586.solution(new int[]{2, 2, 1, 2},
                        new int[]{1, 1, 1, 1}));
    }

    @Test
    public void hidcase6() {
        assertArrayEquals(new int[]{2},
                prgs42586.solution(new int[]{70},
                        new int[]{20}));
    }

    @Test
    public void hidcase7() {
        assertArrayEquals(new int[]{2, 1},
                prgs42586.solution(new int[]{95, 85, 86},
                        new int[]{2, 5, 4}));
    }
}