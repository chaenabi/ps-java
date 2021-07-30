package programmers.codingTestPractice.level2;

/**
 * 문자열 압축
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 * created: 2021-07-30
 */
public class Prgs60057 {
    public int solution(String s) {
        int min = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int compLeng = compression(s, i).length();
            min = Math.min(min, compLeng);
        }

        return min;
    }

    /**
     *
     * @param str 입력받은 문자열
     * @param i i값
     * @return 압축된 문자열
     */
    private String compression(String str, int i) {

        int count = 1;
        StringBuilder compression = new StringBuilder();
        String pattern = "";

        for (int j = 0; j <= str.length() + i; j += i) {

            String nowStr;

            if (j >= str.length()) {
                nowStr = "";
            } else if (str.length() < j + i) {
                nowStr = str.substring(j);
            } else {
                nowStr = str.substring(j, j + i);
            }

            if (j != 0) {
                if (nowStr.equals(pattern)) {
                    count++;
                } else if (count >= 2) {
                    compression.append(count).append(pattern);
                    count = 1;
                } else {
                    compression.append(pattern);
                }
            }
            pattern = nowStr;
        }

        return compression.toString();
    }
}
