/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int reachMax = 0; //最远能到达的位置
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > reachMax) { // 跳不到的位置
                return false;
            }
            reachMax = Math.max(reachMax, nums[i] + i);
            if (reachMax >= n) {
                return true;
            }
        }
        return true;
    }
}
// @lc code=end

