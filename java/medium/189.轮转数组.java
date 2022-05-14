/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        // 方法一
        int n = nums.length;
        int[] nums1 = nums.clone();
        k = k > n ? k % n : k;
        for (int i = 0; i < n; i++) {
            int index = (n - k + i) % n;
            nums[i] = nums1[index];
        }
    }
}
// @lc code=end

