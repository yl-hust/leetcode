/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int ans = 0, first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            ans = first + second;
            first = second;
            second = ans;
        }
        return ans;
    }
}
// @lc code=end

