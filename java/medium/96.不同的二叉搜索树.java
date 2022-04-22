/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        // F(i,n): 以i为根、序列长度为n的不同二叉搜索树个数(1≤i≤n)。
        // G(n)= Sum(F(i,n)) (1<=i<=n)
        // F(i,n)=G(i−1) * G(n−i) => F(3,7)=G(2)⋅G(4)
        int[] G = new int[n + 1];
        // base case
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
// @lc code=end

