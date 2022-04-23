package jobs.help;

public class Permutation {
    static int n = 4; // 사용자 입력값
    static int m = 3; // 진수값
    static int[] arr = new int[1_000_000];
    static boolean[] visited = new boolean[1_000_000];

    public static void main(String[] args) {

        duplicate_permutation(0);
        System.out.println("------------------------");
        arr = new int[1_000_000];
        normal_permutation(0,0);
        System.out.println("------------------------");
        arr = new int[1_000_000];
        combination(0, 0);
    }

    // 중복 순열.
    // n자리의 m진수를 모두 출력한다거나,
    // a부터 d까지 모든 순열을 출력하라와 (aaaa, aaab, aaac, ... abcd ... dddc, dddd) 같은 문제에서 사용
    // 반복문의 중첩수를 바꿔야 하므로 재귀함수를 이용하는 것이 편리하다. 즉 n중 반복문을 만들기 쉽다.
    static void duplicate_permutation(int cur) {
        if (cur == n) {
            for (int i = 0; i < n; i++) {
                System.out.printf("%d", arr[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < m; i++) {
            arr[cur] = i;
            duplicate_permutation(cur + 1);
        }
    }

    // 일반 순열 (중복순열 중에서 중복이 있는 것은 제외하고 출력)
    // 즉 0120, 1123, 1111, 0222 등 제외
    static void normal_permutation(int cur, int start) {
        if (cur == n) {
            for (int i = 0; i < n; i++) {
                System.out.printf("%d", arr[i]);
            }
            System.out.println();

            return;
        }

        for (int i = start; i < m; i++) {
            arr[cur] = i;
            normal_permutation(cur + 1, i);
        }
    }

    // 조합. 2111, 1211, 1121, 1112 를 모두 같은 것으로 보고 이 중 하나만을 출력하는 문제에서 사용가능
    // 이 경우에는 내림차순으로 출력됨. (오름차순의 조합이 아님)
    static void combination(int cur, int index) {
        if (cur == n) {
            for (int i = 0; i < index; i++) {
                System.out.printf("%d", arr[i]);
            }
            System.out.println();
            return;
        }

        int curNum = n - cur;

        for (int i = curNum; i >= 1; i--) {
            arr[index] = i;
            if (index > 0 && arr[index - 1] < arr[index]) continue;
            combination(cur + i, index + 1);
        }
    }
}
