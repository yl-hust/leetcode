package 剑指offer.leetcode.editor.cn;
//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？ 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 10^5 
//
// 
//
// 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-s
//tock/ 
// Related Topics 数组 动态规划 
// 👍 250 👎 0


// 股票的最大利润
public class 剑指Offer63 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer63().new Solution();
        solution.maxProfit(new int[]{7,1,5,3,6,4});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        // Seek the lowest price and update profit
        int lowPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            lowPrice = Math.min(lowPrice, price);
            maxProfit = Math.max(maxProfit, price - lowPrice);
        }
        return maxProfit;
    }
/*    public int maxProfit(int[] prices) {
        // dp[i][0] i day no stack
        // dp[i][1] i day has stack
        int days = prices.length;
        if (days == 0) return 0;
        int[][] dp = new int[days][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < days; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // Only 1 buy,means dp[i - 1][0] always = 0
            dp[i][1] = Math.max(dp[i - 1][1], *//**dp[i - 1][0]*//* - prices[i]);
        }
        return dp[days - 1][0];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}