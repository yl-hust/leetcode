/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        // dp[i][j]: 表示以(i,j)为右下角，且只包含1的正方形的边长最大值
        // dp[i][j] = Min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               if (matrix[i][j] == '1') {
                   if (i == 0 || j == 0) {
                       // base case
                       dp[i][j] = 1;
                   } else {
                       dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                   }
                   max = Math.max(max, dp[i][j]);
               }
            }
        }
        return max*max;
    }
}
// @lc code=end

