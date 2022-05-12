/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        // dp[i]为s[0, i]的解码方法总数
        // dp[i] = dp[i - 1] 一位编码 (s[i] != 0)
        // dp[i] = dp[i - 2] 二位编码 (s[i-1] != 0 && s[i-1, i] <= 26)
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' 
                && (10 * (s.charAt(i - 2) - '0') + (s.charAt(i - 1) - '0')) <= 26) {
                    dp[i] += dp[i - 2];
                }            
        }
        return dp[n];
    }
}
// @lc code=end

