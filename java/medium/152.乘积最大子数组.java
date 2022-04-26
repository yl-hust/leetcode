/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    // 由于数组元素包含负数，所以要考虑负负得正的情况
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int preMin = nums[0]; // 前一步的最小值
        int preMax = nums[0]; // 前一步的最大值
        for (int i = 1; i < nums.length; i++) {
            // 最大值*负数 or 最小值*正数 ==> 更小
            // 最大值*正数 or 最小值*负数 ==> 更大
            int preMinTemp = preMin * nums[i];
            int preMaxTemp = preMax * nums[i];
            preMin = Math.min(nums[i], Math.min(preMinTemp, preMaxTemp));
            preMax = Math.max(nums[i], Math.max(preMinTemp, preMaxTemp));           
            // System.out.println("min: " + preMin);
            // System.out.println("max: " + preMax);                 
            max = Math.max(max, preMax);
        }
        return max;
    }
}
// @lc code=end

