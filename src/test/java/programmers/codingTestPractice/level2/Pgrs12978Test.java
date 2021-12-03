package programmers.codingTestPractice.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pgrs12978Test {

    Pgrs12978 pgrs12978 = new Pgrs12978();

    @Test
    public void case1() {
        Assertions.assertThat(
                pgrs12978.solution(5, new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},
                        3))
                .isEqualTo(4);
    }

    @Test
    public void case2() {
        Assertions.assertThat(
                pgrs12978.solution(6,
                        new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}},
                         4))
                .isEqualTo(4);
    }
}