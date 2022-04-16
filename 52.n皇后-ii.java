/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    int count;
    public int totalNQueens(int n) {    
        count = 0;    
        dfs(n, 0, 0, 0, 0);
        return count;
    }

    private void dfs(int N, int row, int col, int pie, int na) {
        if (row >= N) {
            count++;
            return;
        }
        int bits = (~(col | pie | na)) & (( 1 << N) - 1);
        while (bits > 0) {
            int bit = bits & -bits;
            dfs(N, row + 1, col | bit, (pie | bit) << 1, (na | bit) >> 1);
            bits &= bits - 1;
        }        
    }

}
// @lc code=end

