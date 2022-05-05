import javax.swing.text.StyledEditorKit.ForegroundAction;

/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 丢失的数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        boolean[] hash = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]] = true;
        }
        for (int i = 0; i < hash.length; i++) {
            if (!hash[i]) {
                return i;
            }
        }
        return -1;
    }
    
}
// @lc code=end

