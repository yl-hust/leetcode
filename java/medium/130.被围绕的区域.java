/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        // 从边界的O，标记所有与它直接或间接相连的字母O
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从边界的O开始
                boolean isEdge = i == 0 || i == m - 1 || j == 0 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }                
            }
        }
    }

    /**
     * 标及与'O'联通的O为'#'
     * @param board
     * @param i
     * @param j
     */
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
            || board[i][j] == 'X' || board[i][j] == '#') {
                // board[i][j] = '#' 说明已经标及过了
                return;
            }
        board[i][j] = '#';
        dfs(board, i - 1, j); // 上
        dfs(board, i + 1, j); // 下
        dfs(board, i, j - 1); // 左
        dfs(board, i, j + 1); // 右
    }
}
// @lc code=end
