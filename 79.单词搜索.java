/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {

    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                } 
            }
        }
        return false;        

    }

    private boolean dfs(char[][] board, String word, int i, int j, int level) {
        if (level == word.length()) {
            return true; 
        }
        //检查位置是否有效
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        //检查是否访问过
        if (visited[i][j]) {
            return false;
        }
        if (board[i][j] == word.charAt(level)) {
            visited[i][j] = true;
            //上下左右
            if (dfs(board, word, i - 1, j, level + 1)) return true;
            if (dfs(board, word, i + 1, j, level + 1)) return true;
            if (dfs(board, word, i, j - 1, level + 1)) return true;
            if (dfs(board, word, i, j + 1, level + 1)) return true;
            visited[i][j] = false; // 回溯
        } 
        return false;      
    }
}
// @lc code=end

