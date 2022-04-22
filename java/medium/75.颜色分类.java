/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // 双指针一次遍历法
        int redP = 0;
        int whiteP = 0;
        // [red....white...blue]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { //遇到0，交换后红白指针一起向前
                nums[i] = nums[redP];
                nums[redP] = 0;
                // 如果是0和1交换, 1和2需要再交换
                if (nums[i] == 1) {
                    nums[i] = nums[whiteP];
                    nums[whiteP] = 1;
                }
                redP++;
                whiteP++;                                
            } else if (nums[i] == 1) { //遇到1，交换后白指针向前
                nums[i] = nums[whiteP];
                nums[whiteP++] = 1;
            }
        }        
    }
}
// @lc code=end

