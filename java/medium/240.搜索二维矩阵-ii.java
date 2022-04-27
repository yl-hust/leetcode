/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 关键：从左下角或者右上角出发
        // 选择从左下角开始
        int row = m - 1;
        int column = 0;
        while (row >=0 && column < n) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                row--;
            } else {
                column++;
            }
        }
        return false;        
    }
}
// @lc code=end

