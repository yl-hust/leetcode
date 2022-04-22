/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        // 动态规划, 转移方程如下
        // dp[i][j] = grid[i][j] + min(dp[i+1][j], dp[i][j+1])
        // 答案为dp[0][0]
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[row - 1][column - 1] = grid[row - 1][column - 1];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {                
                if (i == row - 1 && j < column - 1) {// 边界条件1,最后一行的来源只能从右侧
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                } else if (j == column - 1 && i < row - 1) { // 边界条件2,最后一列的来源只能从下侧
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                } else if (i != row - 1 && j != column - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

