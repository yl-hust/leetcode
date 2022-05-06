/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean flag_row = false; // 第一行是否有0
        boolean flag_col = false; // 第一列是否有0
        int row = matrix.length;
        int col = matrix[0].length;

        // 第一行是否有零
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0){
                flag_row = true;
                break;
            }
        }
        // 第一列是否有零
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                flag_col = true;
                break;
            }
        }       
        // 根据其他行和列，更新第一行和第一列做为标志位
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        // 除第一行第一列，其他行置零
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 处理第一行
        if (flag_row) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }            
        }
        // 处理第一列
        if (flag_col) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }            
        }
        
    }
}
// @lc code=end

