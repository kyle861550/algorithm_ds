package learn.dynamic;

public class DpTable {

    private int fibTaleCompression(int N) {
        if(N == 0) return 0;

        if(N == 1 || N == 2) return 1;

        int pre = 1 , current = 1;

        for(int i = 3; i <= N; i++) {
            int result = pre + current;
            pre = current;
            current = result;
        }

        return current;
    }

    private int fib(int N) {
        if(N == 0) return 0;

        if(N == 1 || N == 2) return 1;

        int[] dp = new int[N + 1];

        // define base case
        dp[1] = dp[2] = 1;

        // bottom to top
        for(int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }

}
