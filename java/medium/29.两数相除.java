/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        // 判断符号位
        int sign = 1;
        if ((dividend > 0 && divisor < 0) ||
            (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        // 转成负数避免越界
        dividend = dividend > 0 ? -dividend : dividend;
        divisor  = divisor  > 0 ? -divisor  : divisor;

        return sign * helper(dividend, divisor);
    }

    private int helper(int a, int b) {
        // a b 均是负数
        if (a >= b) return a > b ? 0 : 1;
        int count = 1;
        int res = 0;
        int tb = b;
        // tb < 0 保证除数翻倍后越界
        // e.g (-1090366779) * 2 = 2114233738
        while (a <= tb && tb < 0) {
            a -= tb;
            res += count;
            tb  = tb << 1;
            count = count << 1;
        }
        return res + helper(a, b);
    }
}
// @lc code=end

