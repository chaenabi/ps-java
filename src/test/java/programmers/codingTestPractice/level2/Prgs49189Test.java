package programmers.codingTestPractice.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Prgs49189Test {

    @Test
    public void pubCase1() {
        int[][] ints = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        Assertions.assertThat(new Prgs49189().solution(6, ints)).isEqualTo(3);
    }

    @Test
    public void hidCase1() {
        int[][] ints = {{4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        Assertions.assertThat(new Prgs49189().solution(5, ints)).isEqualTo(2);
    }

    @Test
    public void hidCase2() {
        int[][] ints = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}};
        Assertions.assertThat(new Prgs49189().solution(4, ints)).isEqualTo(1);
    }

    @Test
    public void hidCase3() {
        int[][] ints = {{1, 4}, {1, 3}, {2, 3}, {2, 1}};
        Assertions.assertThat(new Prgs49189().solution(4, ints)).isEqualTo(3);
    }

    @Test
    public void hidCase4() {
        int[][] ints = {{3, 4}, {1, 3}, {2, 3}, {2, 1}};
        Assertions.assertThat(new Prgs49189().solution(4, ints)).isEqualTo(1);
    }

    @Test
    public void hidCase5() {
        int[][] ints = {{4, 3}, {1, 3}, {2, 3}};
        Assertions.assertThat(new Prgs49189().solution(4, ints)).isEqualTo(2);
    }

}