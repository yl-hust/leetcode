/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    // 暴力解法 Time Limit Exceeded
    // public int maxProfit(int[] prices) {
    //     int max = 0;
    //     for (int i = 0; i < prices.length - 1; i++) {
    //         for (int j = i+1; j < prices.length; j++) {
    //             max = Math.max(max, prices[j] - prices[i]);
    //         }            
    //     }
    //     return max;
    // }

    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > res) {
                res = price - min;
            }
        }
        return res;
    }
}
// @lc code=end

