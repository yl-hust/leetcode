package 剑指offer.leetcode.editor.cn;
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 
// 👍 507 👎 0


// 机器人的运动范围
public class 剑指Offer13 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer13().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, k, visited);
    }
    private int digit_sum(int i) {
        return i / 10 + i % 10;
    }

    private int dfs(int i, int j, int k, boolean[][] visited) {
        if (i >= visited.length || j >= visited[0].length
           || visited[i][j] || (digit_sum(i) + digit_sum(j)) > k) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, k, visited) + dfs(i, j + 1, k, visited);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}