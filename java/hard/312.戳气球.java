/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            val[i + 1] = nums[i];            
        }
        int[][] dp = new int[n + 2][n + 2];
        // dp[i][j] means the max coins you can get from nums[i:j]
        // l = j - i + 1
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n + 1 - l; i++) {
                int j = i + l - 1; // j <= n ---->i + l <= n + 1
                // 爆破点为K
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], 
                    dp[i][k - 1] + dp[k + 1][j] + val[i - 1] * val[k] * val[j + 1]);
                }
            }            
        }
        return dp[1][n];
    }
}
// @lc code=end

