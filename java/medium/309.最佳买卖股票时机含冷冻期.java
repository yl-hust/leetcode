/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int[][] dp = new int[days + 1][2];
        // dp[i][0] 第i天无股票, 0->1 买入
        // dp[i][1] 第i天有股票, 1->0 卖出
        int max = 0;
        dp[0][0] = 0;          // 第0天不交易
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][0] = 0;          // 第一天不交易
        dp[1][1] = -prices[0]; // 第一天买入
        for (int i = 2; i <= days; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i - 1]);
            max = Math.max(max, dp[i][0]);
        }

        return max;

    }
}
// @lc code=end

