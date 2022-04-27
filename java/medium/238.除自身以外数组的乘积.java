/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        // 任意元素x [前缀之积 x 后缀之积]
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {            
            result[i] = nums[i - 1] * result[i - 1];
        }

        // 后缀之积，用一个变量记录，再复用result数组
        int r = 1;
        result[nums.length - 1] *= r;
        for (int i = nums.length - 2; i >= 0; i--) {
            r = nums[i + 1] * r;
            result[i] *= r;
        }
        return result;
    }
}
// @lc code=end

