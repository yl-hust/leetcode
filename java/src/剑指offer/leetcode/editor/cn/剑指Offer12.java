package 剑指offer.leetcode.editor.cn;
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 
// 👍 593 👎 0


// 矩阵中的路径
public class 剑指Offer12 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer12().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j, visited))
                    return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int k, int i, int j, boolean[][] visited) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] direction = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        boolean result = false;
        for (int l = 0; l < 4; l++) {
            int newX = i + direction[l][0];
            int newY = j + direction[l][1];
            if (newX >= 0 && newX < board.length && newY >=0 && newY < board[0].length
                && !visited[newX][newY]) {
                if (backtrack(board, word, k + 1, newX, newY, visited)) {
                    result = true;
                    break;
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}