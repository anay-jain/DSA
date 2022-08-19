class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount ==0)return 0;
        int[] dp = new int[amount+1];
        int n=coins.length;
        for(int i =1;i<dp.length;i++)
            dp[i]=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int coin =coins[i];
            for(int j =1;j<dp.length;j++){
                if(j-coin>=0 && dp[j-coin]!=Integer.MAX_VALUE) 
                dp[j] = Math.min(dp[j],dp[j-coin]+1);
            }
            
        }
        return dp[amount]==Integer.MAX_VALUE ? -1:dp[amount];
    }
}