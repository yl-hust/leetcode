/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel 表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            int x = c - 'A' + 1;
            ans += x * multiple;
            multiple *= 26;
        }
        return ans;
    }
}
// @lc code=end

