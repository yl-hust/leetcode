/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = 0; // 前一个元素(也用来记录更新后的当前元素)
        for (int x : nums) {
            // 前一个元素大于0，累加到当前元素，否则丢弃（x保持不变）
            pre = pre > 0 ? x + pre : x;
            // record max value
            max = Math.max(pre, max);
        }

        return max;
    }
}
// @lc code=end

