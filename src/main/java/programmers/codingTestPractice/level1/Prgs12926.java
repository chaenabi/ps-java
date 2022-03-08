package programmers.codingTestPractice.level1;

public class Prgs12926 {
    public String solution(String s, int n) {

        char[] arr = s.toCharArray();
        int arrLen = arr.length;

        for(int i = 0; i < arrLen; i++) {
            if (arr[i] == ' ') continue;

            if (arr[i] >= 'a' && arr[i] <= 'z') {
                if (arr[i] + n > 'z') arr[i] = (char) (arr[i] + n - 26);
                else arr[i] = (char) (arr[i] + n);
            }
            else if (arr[i] >= 'A' && arr[i] <= 'Z') {
                if (arr[i] + n > 'Z') arr[i] = (char) (arr[i] + n - 26);
                else arr[i] = (char) (arr[i] + n);
            }
        }

        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        System.out.println(new Prgs12926().solution("AB", 1)); // "BC"
        System.out.println(new Prgs12926().solution("z", 1)); // "a"
        System.out.println(new Prgs12926().solution("a B z", 4)); // "e F d"
        System.out.println(new Prgs12926().solution("AaZz", 25)); // "ZzYy"
    }
}
