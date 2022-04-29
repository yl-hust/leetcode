/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false;

        // 背包问题，n个物品，sum/2装载量
        int halfSum = sum / 2;
        int n       = nums.length;
        boolean[][] dp  = new boolean[n + 1][halfSum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= halfSum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (j >= nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }                    
                }
            }
        }

        return dp[n][halfSum];
    }
}
// @lc code=end

