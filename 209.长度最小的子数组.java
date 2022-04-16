/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int start = 0, end = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                minLength = Math.min(end - start + 1, minLength);
                sum -= nums[start];
                start++;                
            }
            end++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength; 
    }
}
// @lc code=end

