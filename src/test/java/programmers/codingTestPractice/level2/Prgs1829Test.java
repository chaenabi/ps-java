package programmers.codingTestPractice.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Prgs1829Test {


    @Test
    public void pubcase1() {
        Prgs1829 prgs1829 = new Prgs1829();
        Assertions.assertThat(new int[]{4, 5})
                .isEqualTo(prgs1829.solution(6, 4, new int[][]{{1, 1, 1, 0},
                                                                      {1, 2, 2, 0},
                                                                      {1, 0, 0, 1},
                                                                      {0, 0, 0, 1},
                                                                      {0, 0, 0, 3},
                                                                      {0, 0, 0, 3}}
                                            ));

    }
}