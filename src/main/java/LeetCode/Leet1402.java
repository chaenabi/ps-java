package LeetCode;

public class Leet1402 {

    static int sum = Integer.MIN_VALUE;

    public int maxSatisfaction(int[] satisfaction) {
        return Math.max(recur(satisfaction.length, satisfaction), 0);
    }

    private static int recur(int len, int[] satis) {
        for (int i = 1; i <= len; i++) {
            int temp = i * satis[i - 1];
            if (sum < temp) sum = temp;
            
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leet1402().maxSatisfaction(new int[]{-1,-8,0,5,-9}));
    }
}
