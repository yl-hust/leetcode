/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char lc = s.charAt(left);
            if (!Character.isLetterOrDigit(lc)) {
                left++;
                continue;
            }
            char rc = s.charAt(right);
            if (!Character.isLetterOrDigit(rc)) {
                right--;
                continue;
            }
            if (Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end

