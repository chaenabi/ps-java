package codewars;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Persist {
    public static int persistence(long n) {
        if (n < 10) return 0;
        String[] sar = String.valueOf(n).split("");
        return recur(sar, 1, 0);
    }

    public static int recur(String[] sar, int t, int cnt) {
        for (String s : sar) {
            t *= Integer.parseInt(s);
        }
        cnt++;
        if (t < 10) return cnt;
        sar = String.valueOf(t).split("");
        return recur(sar, 1, cnt);
    }
}


class PersistTest {
    @Test
    public void basicTests() {
        assertEquals(3, Persist.persistence( 39), "Incorrect answer for n=39" );
        assertEquals(0, Persist.persistence(  4), "Incorrect answer for n=4"  );
        assertEquals(2, Persist.persistence( 25), "Incorrect answer for n=25" );
        assertEquals(4, Persist.persistence(999), "Incorrect answer for n=999");
    }
}
