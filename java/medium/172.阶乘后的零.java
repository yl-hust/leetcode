/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        // [5, n]中质因子5的个数的和
        // 最终 5 的个数就是 n / 5 + n / 25 + n / 125 ...
        int count = 0;
        while (n != 0) {            
            n /= 5;
            count += n;
        }
        return count;
    }
}
// @lc code=end

