import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 按层上右下左遍历
        // 最后遍历剩下的横行或者竖行或者中心点
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        List<Integer> ans = new ArrayList<>();
        while (top < bottom && left < right) {
            for (int i = left; i < right; i++) {
                ans.add(matrix[top][i]); // top line
            }
            for (int i = top; i < bottom; i++) {
                ans.add(matrix[i][right]); // right column
            }
            for (int i = right; i > left; i--) {
                ans.add(matrix[bottom][i]); // bottom line
            }
            for (int i = bottom; i > top; i--) {
                ans.add(matrix[i][left]); // left column
            }
            // 收缩内层
            left++;
            right--;
            top++;
            bottom--;
        }
        if (top == bottom) { // 剩一行
            for (int i = left; i <= right; i++) {
                System.out.println(matrix[top][i]);
                ans.add(matrix[top][i]);
            }
        } else if (left == right) { // 剩一列
            for (int i = top; i <= bottom; i++) {                
                ans.add(matrix[i][left]);
            }
        }
        return ans;
    }
}
// @lc code=end

