/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        // dp[i][j] 表示[i, j]区间是否为回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) { // 单个字符
                    dp[i][j] = true;
                } else if (j - i == 1 && s.charAt(i) == s.charAt(j)) { // 两个字符
                    dp[i][j] = true;
                } else if(j - i > 1 && s.charAt(i) == s.charAt(j)) { // 多个字符
                    dp[i][j] = dp[i + 1][j - 1];
                }                
                if (dp[i][j]) {
                    ans++;
                }
            }            
        }
        return ans;
    }
}
// @lc code=end

