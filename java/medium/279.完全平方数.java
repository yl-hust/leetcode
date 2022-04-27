import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                int remain = i - j * j;
                if (remain < 0) break;
                if (remain == 0) dp[i] = 1; // 本身就是完全平方数
                else {
                    dp[i] = Math.min(dp[i], dp[remain] + 1);
                }
            }
        }
        return dp[n];
    }
}
// @lc code=end

