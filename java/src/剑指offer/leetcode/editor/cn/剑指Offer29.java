package 剑指offer.leetcode.editor.cn;
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 
// 👍 414 👎 0


// 顺时针打印矩阵
public class 剑指Offer29 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer29().new Solution();
        solution.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[row * col];
        int l = 0, r = col - 1; // left and right border
        int t = 0, b = row - 1; // top and bottom border
        int i = 0;
        while (i < row * col) {
            // row: left -> right
            for (int j = l; j <= r; j++) {
                res[i++] = matrix[t][j];
            }
            // move to next row
            if (++t > b) break;
            // column: top -> bottom
            for (int j = t; j <= b; j++) {
                res[i++] = matrix[j][r];
            }
            // move to next column
            if (--r < l) break;
            // row: right -> left
            for (int j = r; j >= l; j--) {
                res[i++] = matrix[b][j];
            }
            // move to next row
            if (--b < t) break;
            // column: bottom -> top
            for (int j = b; j >= t; j--) {
                res[i++] = matrix[j][l];
            }
            // move to next column
            if (++l > r) break;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}