/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {        
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) { // 左边有序
                if (nums[left] <= target && target < nums[mid]) { // 目标值在左边区间内
                    right = mid - 1;
                } else { // 目标值在右边区间
                    left = mid + 1;
                }                
            } else { // 右边有序
                if (nums[mid] < target && target <= nums[right]) { // 目标值在右边区间内
                    left = mid + 1;
                } else { // 目标值在左边区间
                    right = mid - 1;
                }                
            }
        }

        return ans;

    }
}
// @lc code=end

