/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;
        int i = 31;
        while (n != 0 && i >= 0) {
            int x = (n & 1) << i--;
            rev += x;
            n = n >>> 1;
        }
        return rev;    
    }
}
// @lc code=end

