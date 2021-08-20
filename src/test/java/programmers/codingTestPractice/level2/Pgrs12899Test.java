package programmers.codingTestPractice.level2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class Pgrs12899Test {


    final Pgrs12899 pgrs12899 = new Pgrs12899();

    @Test
    public void pubcase1() {
        assertThat(pgrs12899.solution(1)).isEqualTo("1");
    }

    @Test
    public void pubcase2() {
        assertThat(pgrs12899.solution(2)).isEqualTo("2");
    }

    @Test
    public void pubcase3() {
        assertThat(pgrs12899.solution(3)).isEqualTo("4");
    }

    @Test
    public void pubcase4() {
        assertThat(pgrs12899.solution(4)).isEqualTo("11");
    }

    @Test
    public void pubcase5() {
        assertThat(pgrs12899.solution(5)).isEqualTo("12");
    }


    @Test
    public void pubcase6() {
        assertThat(pgrs12899.solution(6)).isEqualTo("14");
    }


    @Test
    public void pubcase7() {
        assertThat(pgrs12899.solution(7)).isEqualTo("21");
    }


    @Test
    public void pubcase8() {assertThat(pgrs12899.solution(8)).isEqualTo("22");}

    @Test
    public void pubcase9() {
        assertThat(pgrs12899.solution(9)).isEqualTo("24");
    }

    @Test
    public void pubcase10() {
        assertThat(pgrs12899.solution(10)).isEqualTo("41");
    }


}