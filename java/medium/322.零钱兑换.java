import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

//@lc code=start
class Solution {
    //自顶向下
    //转移方程：dp(n) = 1 + Min(dp(n-coin))
    // int[] memo;
    // public int coinChange(int[] coins, int amount) {
    //     memo = new int[amount + 1];
    //     //dp数组设特殊值，用来判定是否有解
    //     Arrays.fill(memo, -999);
    //     return dp(coins, amount);
    // }
    
    // private int dp(int[] coins, int amount) {
    //     // base case
    //     if (amount == 0) return 0;
    //     if (amount < 0) return -1;
        
    //     if (memo[amount] != -999) {
    //         return memo[amount];
    //     }
    //     int result = Integer.MAX_VALUE;
    //     for (int coin : coins) {            
    //         int subResult = dp(coins, amount - coin);
    //         if (subResult == -1) continue;
    //         result = Math.min(result, subResult + 1);
    //     }
    //     memo[amount] = (result == Integer.MAX_VALUE) ? -1 : result;
    //     return memo[amount];
    // }

    //自底向上递推解法
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if ((i - coin) < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

}

// @lc code=end

