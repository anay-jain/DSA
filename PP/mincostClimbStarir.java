public static int mincostCLimbStairs_DP(int n, int[] dp, int[] cost) {
        if (n <= 1) {
            return dp[n] = cost[n];
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = Math.min(mincostCLimbStairs_DP(n - 1, dp, cost), mincostCLimbStairs_DP(n - 2, dp, cost));
        if (n == cost.length) {
            // 4=4
             dp[n] = ans;
            // return ans;
        } else {
            dp[n] = ans + cost[n];
            return dp[n];
        }
    }