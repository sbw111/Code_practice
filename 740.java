class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] a = new int[10001];
        int[][] dp = new int[10001][2];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            a[nums[i]]++;
        }
        for (int i = 1; i < max; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[max][0], dp[max][1]);
    }
}