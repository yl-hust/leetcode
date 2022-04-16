/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 1, r = x, res = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m == x / m) {
                return m;
            } else if (m > x / m) {
                r = m - 1;
            } else {
                l = m + 1;
                res = m; // 取左界
            }            
        }
        return res;
    }
}
// @lc code=end

