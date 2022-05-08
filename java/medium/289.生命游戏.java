/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {

    int row, col;
    int[][] direction = new int[][]{{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    
    public void gameOfLife(int[][] board) {
        row = board.length;
        col = board[0].length;
        // 先原地标记
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int liveCells = count(board, i, j);
                board[i][j] += liveCells * 10; // 31代表周边有3个活细胞
            }            
        }
        // 再原地更新
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int x = board[i][j];
                int live = x / 10;
                if (x % 10 == 0) {
                    if (live == 3) {
                        board[i][j] = 1; // 0->1
                    } else {
                        board[i][j] = 0; // 复原
                    }
                } else {
                    if (live < 2 || live > 3) {
                        board[i][j] = 0;
                    } else {
                        board[i][j] = 1;
                    }
                }
            }
        }

    }

    /**
     * 给定位置周围有多少个活细胞
     * @param board
     * @param i
     * @param j
     * @return
     */
    
    private int count(int[][] board, int i, int j) {
        int count = 0;
        for (int k = 0; k < direction.length; k++) {
            int newX = i + direction[k][0];
            int newY = j + direction[k][1];
            if (isValid(newX, newY) && board[newX][newY] % 10 == 1) {
                count++;
            }            
        }
        return count;
    }

    private boolean isValid(int i, int j) {
        return i >=0 && i < row && j>= 0 && j < col;
    }
}
// @lc code=end

