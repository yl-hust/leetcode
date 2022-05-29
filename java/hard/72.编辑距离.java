/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        //dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
        // word1[i] == word2[j] => dp[i][j] = dp[i-1][j-1]
        // word1[i] != word2[j] => dp[i][j] = min(dp[i-1][j-1](替换), dp[i-1][j](删除), dp[i][j-1])(插入) + 1
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // base case: word1 or word2 is empty
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }                
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

