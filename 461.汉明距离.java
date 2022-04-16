/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int result = 0;
        while (z != 0) {
            z &= z - 1;
            result++;
        }
        return result;
    }
}
// @lc code=end

