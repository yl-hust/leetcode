package 剑指offer.leetcode.editor.cn;
//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 
// 👍 345 👎 0


// 丑数
public class 剑指Offer49 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer49().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        // dp[n] = min{2 * dp[a], 3 * dp[b], 5 * dp[c]}
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        // base case
        dp[0] = 1;
        for (int i = 1; i < n ; i++) {
            int x2 = 2 * dp[a];
            int x3 = 3 * dp[b];
            int x5 = 5 * dp[c];
            dp[i] = Math.min(Math.min(x2, x3), x5);
            if (x2 == dp[i]) a++;
            if (x3 == dp[i]) b++;
            if (x5 == dp[i]) c++;
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}