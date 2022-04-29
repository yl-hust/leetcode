/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {                
                ans[i] = 1;
            } else {
                int j = i + 2;
                while (j < n) {
                    if (temperatures[j] > temperatures[i]) {
                        ans[i] = j - i;
                        break;
                    }
                    j++;
                }          
            }
        }
        return ans;
    }
}
// @lc code=end

