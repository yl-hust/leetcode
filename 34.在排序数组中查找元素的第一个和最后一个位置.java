/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }        
        int firstPos = findFirst(nums, target);
        System.out.println(firstPos);
        if (firstPos == -1) {
            return new int[]{-1, -1};
        }
        int lastPos = findLast(nums, target);
        return new int[]{firstPos, lastPos};
    }    

    // 查找首次出现target的位置
    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid;
            } else {
                right = mid - 1;
            }
        }
        // left == right
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    // 查找最后出现target的位置
    private int findLast(int[] nums, int target) {
        // int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1; // 向上取整
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        // left == right        
        return left;
    }
}
// @lc code=end

