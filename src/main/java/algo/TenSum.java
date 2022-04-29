package algo;

public class TenSum {
    public static void main(String[] args) {
        System.out.println(tenSum(10));
    }

    private static int tenSum(int n) {
        if (n == 0) return 0;

        return tenSum(n - 1) + n;
    }
}
