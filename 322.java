class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        for (int i = 1; i <= amount; i++) dp[i] = amount + 1;
        for (int p: coins){
            for (int i = p; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - p] + 1);
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}