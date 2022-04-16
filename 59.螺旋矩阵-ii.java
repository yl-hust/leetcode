import sun.jvm.hotspot.prims.JvmtiExport;

/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int end = n * n;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (num <= end) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++; //left to right                
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++; //top to bottom                
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++; //right to left                
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++; //bottom to top                
            }
            left++;
        }

        return matrix;        

    }
}
// @lc code=end

