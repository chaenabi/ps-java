package programmers.codingTestPractice.level2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Pgrs12973Test {

    Pgrs12973 pgrs12973 = new Pgrs12973();

    @Test
    public void pubcase1() {
        assertThat(pgrs12973.solution2("baabaa")).isEqualTo(1);
    }

    @Test
    public void pubcase2() {
        assertThat(pgrs12973.solution2("cdcd")).isEqualTo(0);
    }
}