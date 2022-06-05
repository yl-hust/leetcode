/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        // 递归出口
        if (len2 == 0) {
            return len1 == 0;
        }
        boolean firstMatch = len1 > 0 && len2 > 0 
        && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (len2 > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) // *代表0个时
                || (firstMatch && isMatch(s.substring(1), p)); // *代表1...N个时
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
// @lc code=end

