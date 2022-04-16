import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n]; // 每行放置皇后的列 e.g
        List<List<String>> res = new ArrayList<>();
        dfs(res, queens, n, 0, 0, 0, 0);
        return res;
    }

    private void dfs(List<List<String>> res, int[] queens, int n, int row, int col, int pie, int na) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            res.add(board);            
        } else {
            // Available positions
            int ap = (~(col | pie | na)) & ((1 << n) - 1);
            while (ap != 0) {
                int p = ap & -ap; // get a position. e.g. 0010 (低位代表棋盘的左)
                int column = Integer.bitCount(p - 1); // 列的坐标 e.g.0001=>1 
                queens[row] = column;
                dfs(res, queens, n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
                ap &= ap - 1;
                queens[row] = -1;
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
// @lc code=end
