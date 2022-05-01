/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // 找左右边界        
        int len = nums.length;
        int left = len - 1, right = 0;
        int max = nums[0];
        int min = nums[len - 1];
        // 右边界右侧的元素已排序，从左-->右找
        for (int i = 1; i < len; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                right = i;
            }          
        }
        // 特判，如果right没动，说明数组已排序
        if (right == 0) return 0;

        // 左边界左边的元素已排序，从右<--左找
        for (int j = len - 2; j >= 0; j--) {
            if (nums[j] <= min) {
                min = nums[j];
            } else {
                left = j;
            }
        }
        return right - left + 1;
    }
}
// @lc code=end

