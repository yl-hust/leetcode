/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    // public int hammingWeight(int n) {
    //     int bits = 0;
    //     int mask = 1;
    //     for (int i = 0; i < 32; i++) {
    //         if ((mask & n) != 0) {
    //             bits++;
    //         }
    //         mask <<= 1;
    //     }
    //     return bits;
    // }
    // 11111111111111111111111111111101
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += 1 & n;
            n >>>= 1;
        }
        return count;
    }
}
// @lc code=end

