public class CorrectionSemanticMemoization {

    private static int[] memo = new int[0];

    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fib(15));
        System.out.println(fib(20));
    }

    public static int fib(int n) {

        if (n <= 1) return 1;

        if (n >= memo.length) {
            int[] newMemo = new int[n + 1];
            System.arraycopy(memo, 0, newMemo, 0, memo.length);
            memo = newMemo;
            memo[0] = 1;
            memo[1] = 1;
        }

        if (memo[n] != 0) return memo[n];

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }

        return memo[n];
    }
}