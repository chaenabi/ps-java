package cote;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void case1() {

        String[] arr = new String[]{
                "######",
                ">#*###",
                "####*#",
                "#<#>>#",
                ">#*#*<",
                "######"
        };

        assertThat(solution.solution(arr)).isEqualTo(4);
    }

    @Test
    public void case2() {

        assertThat(1).isEqualTo(1);
    }
}