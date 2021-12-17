package programmers.codingTestPractice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Prgs43162Test {

    Prgs43162 prgs43162 =  new Prgs43162();

    @Test
    public void pubcase1() {
        int[][] ints = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Assertions.assertThat(prgs43162.solution(3, ints)).isEqualTo(2);
    }

    @Test
    public void pubcase2() {
        int[][] ints = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        Assertions.assertThat(prgs43162.solution(3, ints)).isEqualTo(1);
    }

}