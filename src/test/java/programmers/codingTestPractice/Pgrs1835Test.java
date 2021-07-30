package programmers.codingTestPractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pgrs1835Test {

    private Pgrs1835 pgrs1835;
    private int result;

    @BeforeEach
    public void initialize() {
        pgrs1835 = new Pgrs1835();
        result = Integer.MAX_VALUE - 1;
    }

    @Test
    public void pubcase1() {
        result = pgrs1835.solution(2, new String[]{"N~F=0", "R~T>2"});
        assertSame(result, 3648);
    }

    @Test
    public void pubcase2() {
        result = pgrs1835.solution(2, new String[]{"M~C<2", "C~M>1"});
        assertSame(result, 3648);
    }

}