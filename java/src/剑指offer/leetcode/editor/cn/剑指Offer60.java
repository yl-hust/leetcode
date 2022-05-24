package 剑指offer.leetcode.editor.cn;
//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// Related Topics 数学 动态规划 概率与统计 
// 👍 426 👎 0


// n个骰子的点数
public class 剑指Offer60 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer60().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] dicesProbability(int n) {
        // 方案总数 6^n
        double all = Math.pow(6, n);
        // dp[i][j] 投掷完i枚骰子后，点数和j的出现概率
        int[][] dp = new int[n + 1][6 * n + 1];
        // base case
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) { // n个筛子
            for (int j = 1; j <= 6 * i ; j++) {
                for (int k = 1; k <= Math.min(j, 6); k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double[] res = new double[5 * n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n][i + n] / all;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}