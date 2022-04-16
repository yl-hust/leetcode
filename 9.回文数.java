/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x != 0 && x % 10 == 0)
            return false; // 末尾是0的数
        int y = 0;// 反转数的一半
        // x = 123321 || 12321
        while (x > y) {// 只反转一半
            y = y * 10 + x % 10;
            x = x / 10;
        }
        // x = 123
        // revertX = 123
        return y == x || x == y / 10;
    }
}
// @lc code=end
