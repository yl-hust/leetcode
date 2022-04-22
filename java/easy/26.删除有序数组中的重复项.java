/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if (size <= 1) return size;
        int slow = 1, fast = 1; // 快慢指针，慢指针
        while (fast < size){
            if (nums[fast] != nums[fast - 1]){//发现非重复元素
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;              
    }
}
// @lc code=end

