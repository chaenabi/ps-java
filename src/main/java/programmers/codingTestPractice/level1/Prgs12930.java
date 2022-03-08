package programmers.codingTestPractice.level1;

public class Prgs12930 {
    public String solution(String s) {

        char[] arr = s.toLowerCase().toCharArray();
        int n = 1, arrLen = arr.length;

        for (int i = 0; i < arrLen; i++) {
            if (arr[i] == ' ') {
                n = 1;
                continue;
            }
            if (n % 2 == 1) arr[i] = (char) (arr[i] - 32);
            n++;
        }

        return String.valueOf(arr);
    }
}
