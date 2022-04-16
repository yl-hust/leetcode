/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        int ans = 0;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= N; i++) {
            ans = a + b;
            a = b;
            b = ans;            
        }
        return ans;
    }
}
// @lc code=end

